package com.test.niuhongbin.asynctaskcanceldemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import asynctaskcanceldownload.DownLoadAsyncTask;

public class MainActivity extends AppCompatActivity {
    private ImageView ivv;
    private String  imagePath = "http://pic30.photophoto.cn/20140214/0042040378976030_b.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivv = findViewById(R.id.iv01);
    }

    public void downLoadImg(View view) {
        Log.v("tag","downLoadImg_start");
        new DownLoadAsyncTask(MainActivity.this,ivv).execute(imagePath);
    }
}
