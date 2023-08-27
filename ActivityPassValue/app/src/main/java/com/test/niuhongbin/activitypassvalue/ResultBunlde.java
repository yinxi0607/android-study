package com.test.niuhongbin.activitypassvalue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

public class ResultBunlde extends Activity {

    private TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tv = findViewById(R.id.tv01);
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        String name = bd.getString("name");
        char sex = bd.getChar("sex");
        Double sorce = bd.getDouble("sorce");
        tv.setText(String.format("name:%s\nsex:%s\nscore:%s",name,sex,sorce));
    }
}
