package com.test.niuhongbin.listviewheaderandfooterdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class OtherActivity extends Activity {
    private List<String> list;
    private ListView lv;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv01);
        list = new ArrayList<String>();
        for(int i=0;i<20;i++){
            list.add("item"+i);
        }
        adapter = new ArrayAdapter<String>(OtherActivity.this,android.R.layout.simple_list_item_1,list);
//        将lv_header xml 布局文件转换成view视图
//        View headerView = LayoutInflater.from(OtherActivity.this).inflate(R.layout.lv_header,null);
        View headerView = LayoutInflater.from(OtherActivity.this).inflate(R.layout.lv_header,null);
        ImageView iv = headerView.findViewById(R.id.iv_01);
        iv.setImageResource(R.mipmap.ic_launcher);
        lv.addHeaderView(headerView);

        View footerView = LayoutInflater.from(OtherActivity.this).inflate(R.layout.lv_footer,null);
        Button btn = footerView.findViewById(R.id.btn_footer);
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
        lv.addFooterView(footerView);
        lv.setAdapter(adapter);
    }
}
