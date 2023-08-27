package com.test.niuhongbin.intentdemo;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/*
 * 演示intent用法
 * */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
//                Intent intent = new Intent();
//                ComponentName compontent = new ComponentName(MainActivity.this,ResultActivity.class);
//                intent.setComponent(compontent);

//                Intent intent = new Intent();
//                intent.setClass(MainActivity.this,ResultActivity.class);
//                startActivity(intent);

                Intent intent = new Intent();
                intent.setClassName(MainActivity.this, ResultActivity.class.getName());
                startActivity(intent);
                break;
            case R.id.btn_call:
//                Uri.parse() uri抽象类，调用静态的parse（）方法  指定action操作的数据
                Intent intent2 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:10086"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent2);
                break;
            case R.id.btn_send:
                Intent intent3 = new Intent(Intent.ACTION_SENDTO,Uri.parse("sms:10010"));
                startActivity(intent3);
                break;
            case R.id.btn_openview:
                Intent intent4 = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.baidu.com"));
                startActivity(intent4);
                break;
            case R.id.btn_music:
                Intent intent5 = new Intent(Intent.ACTION_VIEW);
//                intent5.setData(Uri.parse("file:///"+ Environment.getDownloadCacheDirectory().getAbsolutePath()+"Far.mp3"));
                intent5.setDataAndType(Uri.parse("file:///"+ Environment.getDownloadCacheDirectory().getAbsolutePath()+"Far.mp3"),"audio/*");
                startActivity(intent5);
                break;
        }
    }
}
