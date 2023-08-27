package com.test.niuhongbin.handlerdemomuke3;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            System.out.println("UI--------->"+Thread.currentThread());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        myThread = new MyThread();
//        myThread.start();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        myThread.handler.sendEmptyMessage(1);
//        handler.sendEmptyMessage(1);


        handlerThread = new HandlerThread("handler thread");
        handlerThread.start();

        handler = new Handler(handlerThread.getLooper()){
            @Override
            public void handleMessage(Message msg) {
                Log.i("ddddd","fdsafdsajfdsaflas");
            }
        };
        handler.sendEmptyMessage(1);
    }

    class MyThread extends Thread{
        public Handler handler;
        public Looper looper;
        @Override
        public void run() {
            Looper.prepare();
            handler = new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    System.out.println("currentThread------->"+Thread.currentThread());
                }
            };
            Looper.loop();
        }

    }

    private HandlerThread handlerThread;
    private MyThread myThread;
}
