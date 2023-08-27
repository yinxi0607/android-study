package com.test.niuhongbin.listviewheaderandfooterdemo;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/*
* listview常用方法
* */

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private List<String> list;
    private ArrayAdapter<String> adapter;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv01);
        tv = findViewById(R.id.tv01);
        list = new ArrayList<String>();
        for(int i=0;i<20;i++){
            list.add("item"+i);
        }
        adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,list);
        ImageView iv = new ImageView(MainActivity.this);
        iv.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT));
        iv.setImageResource(R.drawable.ic_launcher_background);
//        将参数中指定的控件view添加到listview的头部
//        注意：addHeaderView（）方法必须在setAdapter()方法执行之前设置
        lv.addHeaderView(iv);
        Button btn = new Button(MainActivity.this);
        btn.setText("加载更多");
        btn.setTextSize(20);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = list.size();

                for(int i=index;i<index+20;i++){
                    list.add("item"+i);
                }
                adapter.notifyDataSetChanged();

            }
        });
        lv.addFooterView(btn);
        lv.setAdapter(adapter);
//        如果listview表示没有显示的数据时展示指定view视图
        lv.setEmptyView(tv);
    }
}
