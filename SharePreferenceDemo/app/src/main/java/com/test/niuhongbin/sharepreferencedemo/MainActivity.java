package com.test.niuhongbin.sharepreferencedemo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etName,etAge;
    private Button btnSave,btnRecover;
    private SharedPreferences sp; //共享参数，本质是map结构的xml文件
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        sp = getSharedPreferences("config",MODE_PRIVATE);
    }

    private void initView() {
        etName = findViewById(R.id.et_name);
        etAge = findViewById(R.id.et_age);
        btnSave = findViewById(R.id.btn_save);
        btnRecover = findViewById(R.id.btn_recover);
    }

    public void click(View view) {
        switch (view.getId()){
            case R.id.btn_save:
                SharedPreferences.Editor edit = sp.edit();
                String name = etName.getText().toString();
                String Age = etAge.getText().toString();
                if(TextUtils.isEmpty(name)&&TextUtils.isEmpty(Age)){
                    return;
                }
                edit.putString("name",name);
                edit.putString("Age",Age);
                boolean result = edit.commit();
                if(result){
                    Toast.makeText(this,"success",Toast.LENGTH_SHORT).show();
                    etName.setText("");
                    etAge.setText("");
                }
                break;
            case R.id.btn_recover:
                String nameValue = sp.getString("name","");
                String ageValue = sp.getString("Age","");
                etName.setText(nameValue);
                etAge.setText(ageValue);
                break;
        }
    }
}
