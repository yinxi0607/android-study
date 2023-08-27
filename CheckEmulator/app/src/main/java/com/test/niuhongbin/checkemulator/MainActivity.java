package com.test.niuhongbin.checkemulator;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.widget.TextView;

import java.io.File;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TextView textView1, textView2, textView3, textView4, textView5, textView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView6);
        textView3 = findViewById(R.id.textView2);
        textView4 = findViewById(R.id.textView3);
        textView5 = findViewById(R.id.textView4);
        textView6 = findViewById(R.id.textView5);
        textView1.setText(CheckDeviceIDS().toString());
        textView2.setText(CheckEmulatorFiles().toString());
        textView3.setText(CheckImsiIDS().toString());
        textView4.setText(CheckPhoneNumber().toString());
        textView5.setText(CheckEmulatorBuild().toString());
        textView6.setText(CheckOperatorNameAndroid());


    }


    private static String[] known_device_ids = {
            "0000000000000000" //默认的ID
    };

    //检测设备的IDS是不是known_device_ids里面的数据
    public Boolean CheckDeviceIDS() {
        TelephonyManager telephonyManager = (TelephonyManager) this.getSystemService(TELEPHONY_SERVICE);

        assert telephonyManager != null;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return true;
        }
        @SuppressLint("HardwareIds") String device_ids = telephonyManager.getDeviceId();
        for (String know_deviceid : known_device_ids) {
            if (know_deviceid.equalsIgnoreCase(device_ids)) {
                return true;
            }
        }
        return false;
    }


    private static String[] known_files = {
            "/system/lib/libc_malloc_debug_qemu.so",
            "/sys/qemu_trace",
            "/system/bin/qemu-props"
    };

    //检测模拟器上特有的几个文件
    public static Boolean CheckEmulatorFiles() {
        for (String file_name : known_files) {
            File qemu_file = new File(file_name);
            if (qemu_file.exists()) {
                return true;
            }
        }
        return false;
    }

    private static String[] known_numbers = {
            "15555215558"
    };

    //检测电话号码是否为默认的电话号码
    public Boolean CheckPhoneNumber() {
        TelephonyManager telephonyManager = (TelephonyManager) this.getSystemService(TELEPHONY_SERVICE);

        assert telephonyManager != null;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_NUMBERS) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return true;
        }
        @SuppressLint("HardwareIds") String phonenumber = telephonyManager.getLine1Number();
        for (String number : known_numbers
                ) {
            if (number.equalsIgnoreCase(phonenumber)) {
                return true;
            }
        }
        return false;
    };


    private static String[] known_imsi_ids = {
            "310260000000000"//默认的imsi id
    };

    public Boolean CheckImsiIDS() {
        TelephonyManager telephonyManager = (TelephonyManager) this.getSystemService(TELEPHONY_SERVICE);

        assert telephonyManager != null;
        @SuppressLint({"MissingPermission", "HardwareIds"}) String imsi_ids = telephonyManager.getSubscriberId();
        for (String know_imsi : known_imsi_ids
                ) {
            if (know_imsi.equalsIgnoreCase(imsi_ids)) {
                return true;
            }

        }
        return false;
    };


    //检测手机上的一些硬件
    public static Boolean CheckEmulatorBuild() {
        String BOARD = Build.BOARD;
        String BOOTLOADER = Build.BOOTLOADER;
        String BRAND = Build.BRAND;
        String DEVICE = Build.DEVICE;
        String HARDWARE = Build.HARDWARE;
        String MODEL = Build.MODEL;
        String PRODUCT = Build.PRODUCT;
        return BOARD.equals("unknown") || BOOTLOADER.equals("unknown") || BRAND.equals("generic") || DEVICE.equals("generic") || MODEL.equals("sdk") || PRODUCT.equals("sdk") || HARDWARE.equals("goldfish");

    }


    //检测手机运营商
    public String CheckOperatorNameAndroid(){
        TelephonyManager tm = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
        String operator = tm.getNetworkOperator();
        String opeType = "0";
        // 中国联通
        if ("46001".equals(operator) || "46006".equals(operator) || "46009".equals(operator)) {
            opeType = "2";
            // 中国移动
        } else if ("46000".equals(operator) || "46002".equals(operator) || "46004".equals(operator) || "46007".equals(operator)) {
            opeType = "1";
            // 中国电信
        } else if ("46003".equals(operator) || "46005".equals(operator) || "46011".equals(operator)) {
            opeType = "3";
        }
        return opeType;
    }

}
