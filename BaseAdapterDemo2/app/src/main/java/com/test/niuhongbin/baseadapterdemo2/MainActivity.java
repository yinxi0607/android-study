package com.test.niuhongbin.baseadapterdemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv01);
        list = new ArrayList<String>();
        for(int i=0;i<100;i++){
            list.add("item"+i);
        }
        MybaseAdapter mybaseAdapter = new MybaseAdapter();
        lv.setAdapter(mybaseAdapter);

    }

    class MybaseAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView tv = null;
            ViewHolder holder = null;
            if(view==null){
                view = LayoutInflater.from(MainActivity.this).inflate(R.layout.list_item,null);
                holder = new ViewHolder();
                holder.tv = view.findViewById(R.id.tv01);
                view.setTag(holder);
//                tv = view.findViewById(R.id.tv01);
//                view.setTag(tv);//setTag()给可复用的textview添加标记方便获取
            }
            else {
                //存在可复用的布局
//                tv = (TextView) view.getTag();

                holder = (ViewHolder) view.getTag();
            }




//            tv.setText(list.get(i));
            holder.tv.setText(list.get(i));
            Log.i("tag",i+"--------------convertView------------"+view);
            return view;
        }


    }
    //        定义一个用来描述存储需要复用的类
    static class ViewHolder{
        TextView tv;
    }

}
