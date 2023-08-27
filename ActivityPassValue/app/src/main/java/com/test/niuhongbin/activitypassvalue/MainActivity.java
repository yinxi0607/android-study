package com.test.niuhongbin.activitypassvalue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/*
* 演示Activity之间通过Intent传值
* */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void send(View view) {
        Intent intent = new Intent(MainActivity.this,ResultActivity.class);
        intent.putExtra("name","zhangsan");
        intent.putExtra("age",29);
        intent.putExtra("score",92.8);
        intent.putExtra("bl",true);
        intent.putExtra("sex",'男');
        startActivity(intent);
    }

    public void send_bunlde(View view) {
//        1、创建意图对象
        Intent intent = new Intent(MainActivity.this,ResultBunlde.class);
//        2、创建bundle对象 存储数据
        Bundle bd = new Bundle();
//        3、将值传到bundle中
        bd.putString("name","lisi");
        bd.putDouble("sorce",92.3);
        bd.putChar("sex",'男');
        bd.putBoolean("bl",true);
//        4、将bundle存入到intent

        intent.putExtras(bd);
        startActivity(intent);
    }

}
