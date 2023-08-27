package com.test.niuhongbin.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv01);
//        1、准备数据源
        final String[] citys = getResources().getStringArray(R.array.citys);
//        2、将数据源的数据加载到适配器中
        adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,citys);
//        3、将适配器中的数据加载到控件中
        lv.setAdapter(adapter);

//      表示当listview控件中每项item被点击的监听事件
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            表示当listview中的item被点击时回调的方法
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//              1、从数据源中获取
                String s1 = citys[i];
//                2、从适配器中获取数据
                String s2 = adapter.getItem(i);
//                3、从parent中获取
                String s3 = adapterView.getItemAtPosition(i).toString();
//                4、在listview控件中获取
                String s4 = lv.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this,s1+s2+s3+s4,Toast.LENGTH_SHORT).show();
            }
        });

//        listview长按事件
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /**
             * 如果listview既绑定了单击事件也绑定了长按事件
             * 返回值 如果返回false 表示对事件不处理（点击事件也会执行），如果返回True表示对事件处理（单击事件不会执行）
             * @param adapterView  parent
             * @param view view
             * @param i position
             * @param l
             * @return
             */
//            表示当listview中的item被长按时回调的函数
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"长按事件执行",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }


}
