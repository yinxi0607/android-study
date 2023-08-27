package com.test.niuhongbin.createactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    点击按钮启动otherActivity
    public void onClick(View view){
//        通过Intent意图对象描述启动的activity
        Intent intent = new Intent(MainActivity.this,OtherActivity.class);
        startActivity(intent);//启动
    }
}
