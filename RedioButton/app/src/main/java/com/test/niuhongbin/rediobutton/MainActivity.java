package com.test.niuhongbin.rediobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/*
* 演示RedioButton的使用
* */
public class MainActivity extends AppCompatActivity {

    private Button btn;
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        rg = findViewById(R.id.rg);
        //          表示RadioGroup中RadioButton状态切换时触发的监听
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            /*表示RadioGroup中RadioButton切换是回调的函数
            RadioGroup radioGroup 表示切换的RadioButton属于哪个RadioGroup
            int i 表示选中状态的RadioButton的资源id

             */
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                根据回传的RadioButton的对象的资源ID获取RadioButton对象
                RadioButton rb = findViewById(i);
//                通过获取的RadioButton对象来获取其文本
                String rbt = (String) rb.getText();
                Toast.makeText(MainActivity.this,"您选择的是:"+rbt,Toast.LENGTH_SHORT).show();

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int checkedId = rg.getCheckedRadioButtonId();
                RadioButton rb = findViewById(checkedId);
                Toast.makeText(MainActivity.this,"您最终选中的是:"+rb.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
