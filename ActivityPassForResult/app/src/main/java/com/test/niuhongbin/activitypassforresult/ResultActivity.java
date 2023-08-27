package com.test.niuhongbin.activitypassforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends Activity {
    private TextView num1,num2;
    private EditText et1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        num1 = findViewById(R.id.textView5);
        num2 = findViewById(R.id.textView8);
        et1 = findViewById(R.id.editText3);

        Intent intent = getIntent();
        num1.setText(intent.getStringExtra("et_num_str1"));
        num2.setText(intent.getStringExtra("et_num_str2"));
    }

//    点击按钮将数据回传到activity
    public void send(View view) {
        String result = et1.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("info",result);
        setResult(Activity.RESULT_OK,intent);//setResult（表示请求结果码，表示回传数据的intent对象）
        ResultActivity.this.finish();//关闭当前Activity
    }
}
