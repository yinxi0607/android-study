package com.test.niuhongbin.activitylifycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/*
* 演示Activity的生命周期
* */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("tag","---------------MainActivity-----onCreate()------");
    }

    /**
     * 表示activity能够被用户看到时回调的方法
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("tag","---------------MainActivity-----onStart()------");
    }


    /**
     * 表示获取用户焦点时  能与用户交互时
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("tag","---------------MainActivity-----onResume()------");
    }


    /**
     * 失去用户焦点时回调的方法
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("tag","---------------MainActivity-----onPause()------");
    }

    /**
     * 表示activity被完全遮挡时回调的方法
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("tag","---------------MainActivity-----onStop()------");
    }

    /**
     * 表示activity出于停止状态时重新启动是回调的方法
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("tag","---------------MainActivity-----onRestart()------");
    }

    /**
     * 表示activity被销毁时要回调的方法
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("tag","---------------MainActivity-----onDestroy()------");
    }

    public void onClick(View view){
        Intent intent = new Intent(MainActivity.this,OtherActivity.class);
        startActivity(intent);
    }
}
