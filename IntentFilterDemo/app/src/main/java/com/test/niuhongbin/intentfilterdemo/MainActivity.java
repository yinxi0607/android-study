package com.test.niuhongbin.intentfilterdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/*
* 演示隐式启动intent
*
* */


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        switch (view.getId()){
            case R.id.btn_ysqd:
                Intent intent = new Intent();
//                intent.setAction("com.test.action");
//                intent.setData(Uri.parse("test://com:90/res"));
                intent.setDataAndType(Uri.parse("test://com:90/res"),"text/*");
                startActivity(intent);
                break;
            case R.id.btn_qdoa:
                Intent intent2 = new Intent();
                intent2.setAction("com.test.other");
                startActivity(intent2);
                break;
        }
    }
}
