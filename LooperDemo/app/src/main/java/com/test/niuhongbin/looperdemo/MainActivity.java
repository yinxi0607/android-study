package com.test.niuhongbin.looperdemo;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Handler handler;
    private Button btn;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Activity属于助线程，同时它内部封装了一个Looper
        //Looper轮询器，---->"Looper线程"
        new LooperThread().start();
        tv = findViewById(R.id.tv_01);
    }

    public void SendMsg(View view) {
        Message msg = new Message();
        msg.obj = "狗子，东厂需要你这样的人才";
        handler.sendMessage(msg);
    }

    //自定义Looper线程--->不停的处理主线程发来的消息
    class LooperThread extends Thread{
        @SuppressLint("HandlerLeak")
        @Override
        public void run() {
            //1、准备成为looper线程
            Looper.prepare();

            //2、处理消息
            handler = new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    String value = (String) msg.obj;
                    Log.i("TAG","从主线程中接受的消息="+value);
                }
            };

            //3、循环的方法
            Looper.loop();
        }
    }

}
