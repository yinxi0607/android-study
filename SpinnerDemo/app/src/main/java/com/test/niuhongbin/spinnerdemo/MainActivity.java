package com.test.niuhongbin.spinnerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

/*
演示Spinner使用

*/

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    String[] plantes;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.sp01);
//        1、准备需要加载展示的数据源
        plantes = getResources().getStringArray(R.array.plantes_array);
//        2、将数据源的数据加载到适配器中
        /*
        * context 表示上下文对象
        * resource 表示列表item的布局资源id
        * object 表示传近的数据源
        * */
        adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,plantes);
//        3、将适配器中的数据加载到控件中
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            表示当spinner控件中item被选中是回到的方法

            /*
            AdapterView<?>padapterView 表示当前触发事件的适配器控件对象 spinner
            View view 表示当前被选中item的对象
            int i 表示当前被选中的item的下标
            long l 表示当前被选中item的id
            **/
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String s1 = plantes[i];
                String s2 = adapter.getItem(i);
                String s3 = spinner.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this,"s1="+s1+",s2="+s2+",s3="+s3,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
