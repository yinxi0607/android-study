package com.test.niuhongbin.updateui;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            tv.setText("ganshaya");
        }
    };

//    方法一
    private void handle1(){
        handler.post(new Runnable() {
            @Override
            public void run() {
                tv.setText("aiyouwoqu");
            }
        });
    }

//    方法二
    private void handle2(){
        handler.sendEmptyMessage(1);
    }

//    方法三
    private void updateUI(){
         runOnUiThread(new Runnable() {
             @Override
             public void run() {
                 tv.setText("noshalei");
             }
         });
    }

//    方法四
    private void viewUI(){
        tv.post(new Runnable() {
            @Override
            public void run() {
                tv.setText("whatareyou");
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= findViewById(R.id.tv_01);
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    viewUI();


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }
}
