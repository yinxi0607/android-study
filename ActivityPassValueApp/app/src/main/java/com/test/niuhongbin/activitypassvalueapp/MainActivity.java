package com.test.niuhongbin.activitypassvalueapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/*
* 演示通过application传值
*
* 1、创建类继承application 将需要存储的数据定义为application的属性
* 2、发送Activity中的数据
* 3、在resultactivity中获取数据，并显示到textview中
* 4、在清单文件中进行注册  AndroidManifest.xml
*
* <application
        android:name=".MyApplication"
  </application>
* */

public class MainActivity extends AppCompatActivity {

    private MyApplication application;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /*
    * 点击按钮吧数据存储到application中*/
    public void click(View view) {
        application = (MyApplication) getApplication();
        application.setName("小明");
        application.setAge(18);
        startActivity(new Intent(MainActivity.this,ResultActivity.class));
    }
}
