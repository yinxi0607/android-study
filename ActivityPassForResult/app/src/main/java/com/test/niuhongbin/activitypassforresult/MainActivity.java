package com.test.niuhongbin.activitypassforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.ResultReceiver;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/*
* 启动Activity回传数据
* */


/**
 *
 */
public class MainActivity extends AppCompatActivity {
    private EditText et_num1,et_num2;
    private TextView tv_result;
    private static final int REQUEST_CODE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_num1 = findViewById(R.id.editText);
        et_num2 = findViewById(R.id.editText2);
        tv_result = findViewById(R.id.textView4);
    }

//    点击按钮发送数据到目标activity
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        String et_num_str1 = et_num1.getText().toString();
        String et_num_str2 = et_num2.getText().toString();
        intent.putExtra("et_num_str1",et_num_str1);
        intent.putExtra("et_num_str2",et_num_str2);
        startActivityForResult(intent,REQUEST_CODE);//startActivityForResult(请求的intent对象，大于0的整数请求码)
    }


    /**
     * 用来处理setResult()方法回传的数据
     * @param requestCode 请求码
     * @param resultCode  结果码
     * @param data  回传的intent意图对象
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE&&resultCode== Activity.RESULT_OK){
            String result = data.getStringExtra("info");
            tv_result.setText(result);
        }
    }
}
