package com.test.niuhongbin.threadblockdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

//ANR Application not responding

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv01);

//        违反了UI线程模型的第一条规定  主线程阻塞
//        while (true){
//            count++;
//            try{
//                Thread.sleep(1000);
//            }
//            catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            tv.setText(count+"");
//
//        }


//        android.view.ViewRootImpl$CalledFromWrongThreadException: Only the original thread that
//        created a view hierarchy can touch its views.
//        违反了UI线程模型的第二条规定  不让其他线程操作UI线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    tv.setText(count+"");
                }
            }
        }).start();
    }


}
