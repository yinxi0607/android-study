package com.test.niuhongbin.activitylaunchmode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class OtherActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
    }



    public void click(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.btn01:
                intent = new Intent(OtherActivity.this,MainActivity.class);
                break;
            case R.id.btn02:
                intent = new Intent(OtherActivity.this,OtherActivity.class);
                break;
        }
        startActivity(intent);
    }
}
