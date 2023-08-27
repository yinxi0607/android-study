package com.test.niuhongbin.gridviewdemo;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private static final int RESULT_CODE=2;
    private ImageView iv_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_main = findViewById(R.id.iv01);
    }

//    点击按钮跳转到resultactivity里面选择头像并展示
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        startActivityForResult(intent,RESULT_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==RESULT_CODE&&resultCode== Activity.RESULT_OK)
        {
            int imageId = data.getIntExtra("imageId",R.mipmap.ic_launcher);
            iv_main.setImageResource(imageId);

        }
    }
}
