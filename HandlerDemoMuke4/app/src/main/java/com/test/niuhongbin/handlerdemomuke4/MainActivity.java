package com.test.niuhongbin.handlerdemomuke4;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //创建主线程的handler
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Message message = new Message();
            System.out.println("main handler");
            //收到消息后向子线程发送消息
            thredHandler.sendMessageDelayed(message,1000);
        };
    };

    private Handler thredHandler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HandlerThread thread = new HandlerThread("handlerThread");
        thread.start();
        //创建子线程的handler
        thredHandler = new Handler(thread.getLooper()){
            @Override
            public void handleMessage(Message msg) {
                Message message = new Message();
                System.out.println("thread handler");
                //向主线程发送消息
                handler.sendMessageDelayed(message,1000);
            }
        };
    }

    public void click(View view) {
        switch (view.getId()){
            case R.id.button1:
                handler.sendEmptyMessage(1);
                break;
            case R.id.button2:
                handler.removeMessages(1);
                break;
        }
    }
}
