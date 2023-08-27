package com.test.niuhongbin.autocompletetextviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

/*
* 演示AuttoCompleteTextView控件
* */

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView aclt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aclt = findViewById(R.id.aclt);

//      1准备数据源
        String[] countrys = getResources().getStringArray(R.array.country);
//      2、将数据源数据加载到适配器
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,countrys);
//      3、将适配器数据加载到控件中
        aclt.setAdapter(adapter);
//      4、添加选择后的监听事件
        aclt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String aclt_txt = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this,"您输入的国家为："+aclt_txt,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
