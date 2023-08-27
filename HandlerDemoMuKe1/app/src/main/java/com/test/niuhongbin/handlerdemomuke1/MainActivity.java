package com.test.niuhongbin.handlerdemomuke1;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private Handler handler = new Handler();
    private ImageView imageView;
    public int[] imageList = {R.mipmap.img1,R.mipmap.img2,R.mipmap.img3};
    public int index=0;

    private MyRunnable myRunnable=new MyRunnable();

    class MyRunnable implements Runnable{

        @Override
        public void run() {
            index++;
            index = index%3;
            imageView.setImageResource(imageList[index]);
            handler.postDelayed(myRunnable,1000);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv01);
        imageView = findViewById(R.id.imageView);
        handler.postDelayed(myRunnable,1000);




//        new Thread(){
//            @Override
//            public void run() {
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        tv.setText("update textview");
//                    }
//                });
//            }
//        }.start();
    }
}
