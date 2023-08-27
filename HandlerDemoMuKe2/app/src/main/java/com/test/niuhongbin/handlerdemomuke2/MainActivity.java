package com.test.niuhongbin.handlerdemomuke2;

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
//            tv.setText(""+msg.arg1+'-'+msg.arg2);
            tv.setText(""+msg.obj);
        }
    };

    class Person{
        public int age;
        public String name;

        public String toString(){
            return "name="+name+"---age="+age;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv01);
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
//                    Message message = new Message();
                    Message message = handler.obtainMessage();
                    message.arg1 = 88;
                    message.arg2 = 100;
                    Person person = new Person();
                    person.age = 23;
                    person.name="dddddd";
                    message.obj = person;
                    message.sendToTarget();
//                    handler.sendMessage(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }
}
