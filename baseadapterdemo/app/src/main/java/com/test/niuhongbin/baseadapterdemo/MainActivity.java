package com.test.niuhongbin.baseadapterdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/*
* 演示BaseAdapter的基本使用
* 1、定义子类继承BaseAdapter
* 2、需要重写自定时适配器中的相应函数
* 3、创建自定义适配器对象并使用
* */

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv01);
        list = new ArrayList<String>();
        for (int i=0;i<10;i++){
            list.add("item"+i);
        }
        MyBaseAdapter myBaseAdapter = new MyBaseAdapter();
        lv.setAdapter(myBaseAdapter);
    }

    class MyBaseAdapter extends BaseAdapter{


        /**
         * 表示当前适配器中加载的数据总条目
         * @return
         */
        @Override
        public int getCount() {
            return list.size();
        }

        /**
         * 根据指定下标获取对应item的view
         * @param i
         * @return
         */
        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        /**
         * 表示根据指定下标获取当前item的id
         * @param i
         * @return
         */
        @Override
        public long getItemId(int i) {
            return i;
        }

        /**
         * 表示根据指定下标获取适配器中每个item对应的view对象   得到每个用于展示数据的item视图
         * @param i 当前绘制的item的下标
         * @param view 表示可复用的view对象
         * @param viewGroup 表示当前绘制的item所属的listview控件
         * @return
         */
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
//            代码直接构建控件
//            TextView tv = new TextView(MainActivity.this);
//            tv.setText(list.get(i));
//            tv.setTextSize(25);

//            LayoutInflater 布局填充器， 布局加载器  xml文件转换成view对象
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view01 = inflater.inflate(R.layout.list_view,null);//将list_item这个xml文件转换成view对象
            TextView tv = view01.findViewById(R.id.tv01); //获取list_item布局中的textview控件
            tv.setText(list.get(i));
            return tv;
        }
    }
}
