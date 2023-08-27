package com.test.niuhongbin.lvsimpleadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 演示SimpleAdpter
* */

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private List<Map<String,Object>> list;
    private int[] images = {R.mipmap.img1,R.mipmap.img2,R.mipmap.img3,R.mipmap.img4,R.mipmap.img5,R.mipmap.img6,R.mipmap.img7,R.mipmap.img8,R.mipmap.img9};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv01);

//      1、  准备数据源
        list = new ArrayList<Map<String,Object>>();
        for(int i=0;i<9;i++){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("img",images[i]);
            map.put("text","item"+i);
            list.add(map);
        }
//      2、 把数据源加载到适配器中


        /*
        * SimpleAdapter 构造函数
        * context 上下文对象
        * data 表示加载到适配器的数据源对象
        * resource 表示adapter控件中每项布局资源id
        * from 表示数据源map中key的数组  表示key指定的数值
        * to 表示需要展示对应数据的控件资源id   通过from和to的对应  将from中key对应的数据指定的值显示到to指定的资源id的控件中
        * */
        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this,list,R.layout.list_item,
                new String[]{"img","text"},new int[]{R.id.imageView,R.id.textView});
        lv.setAdapter(adapter);
    }
}
