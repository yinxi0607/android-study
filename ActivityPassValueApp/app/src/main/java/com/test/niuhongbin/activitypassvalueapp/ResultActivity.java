package com.test.niuhongbin.activitypassvalueapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

public class ResultActivity extends Activity {

    private TextView tv;
    private MyApplication application;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tv = findViewById(R.id.tv01);
        application = (MyApplication) getApplication();
        String name = application.getName();
        int age = application.getAge();
        tv.setText(String.format("name:%s\nage:%s",name,age));

    }
}
