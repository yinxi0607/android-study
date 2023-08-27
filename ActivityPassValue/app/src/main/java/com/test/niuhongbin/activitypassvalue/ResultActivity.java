package com.test.niuhongbin.activitypassvalue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

public class ResultActivity extends Activity {

    private TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tv = findViewById(R.id.tv01);
//        获取intent组件对象
        Intent intent = getIntent();
//        根据key获取传值的对象
        String name = intent.getStringExtra("name");
        int age = intent.getIntExtra("age",0);
        double score = intent.getDoubleExtra("score",0.0);
        char sex = intent.getCharExtra("sex",'男');
        Boolean bl = intent.getBooleanExtra("bl",true);
//        将数据展示到TextView控件中
        tv.setText(String.format("name:%s\nage:%d\nscore:%s\nsex:%s\nbl:%s", name, age, score, sex, bl));
    }
}
