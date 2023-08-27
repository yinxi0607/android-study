package com.test.niuhongbin.createactivity;

import android.app.Activity;
import android.os.Bundle;

/*
    演示创建Activity
* 1、继承Activity
* 2、重写onCreate()方法
* 3、提供xml布局文件 需要在onCreate()方法中调用setContentView()方法 加载xml布局
* 4、配置
* */

public class OtherActivity extends Activity {

    /**
     * 表示当Activity被创建是回调的方法  由系统框架调用
     * Bundle键为Strin的map集合
     */
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_other);
    }

}
