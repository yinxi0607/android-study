package com.test.niuhongbin.externalstoragedemo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = findViewById(R.id.iv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bitmap = IOUtil.readImg("cat.jpg");
                iv.setImageBitmap(bitmap);
            }
        });
    }

    //保存图片
    public void click(View view) {
        //查看是否有访问外部存储的权限
        int storagePermission = this.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (storagePermission != PackageManager.PERMISSION_GRANTED) {
            //如果没有权限则手动寻求权限
            ActivityCompat.requestPermissions(this, new String[]{android
                    .Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }else {
            save();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        获取权限的结果
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            save();
        }
    }

//    保存文件
    public void save(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.img1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        bitmap.recycle();
        try {
            boolean saveImgResult = IOUtil.saveImg("cat.jpg", byteArrayOutputStream.toByteArray());
            if (saveImgResult) {
                Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
                byteArrayOutputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
