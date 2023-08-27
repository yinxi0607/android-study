package com.test.niuhongbin.gridviewdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultActivity extends Activity {
    private GridView gridView;
    private List<Map<String, Object>> list;
    private int[] images = {R.mipmap.img1, R.mipmap.img2, R.mipmap.img3, R.mipmap.img4, R.mipmap.img5, R.mipmap.img6, R.mipmap.img7, R.mipmap.img8,R.mipmap.img9};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        gridView = findViewById(R.id.gv01);
        list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < images.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("img", images[i]);
            map.put("text", "头像" + i);
            list.add(map);
        }
        MyBaseAdapter adapter = new MyBaseAdapter();
        gridView.setAdapter(adapter);

//        点击gridview中某一项时触发回调方法
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                intent.putExtra("imageId",images[i]);//获取带当前点击头像的资源id
                setResult(Activity.RESULT_OK,intent);//将资源id存储到intent中回传
                ResultActivity.this.finish();
            }
        });

    }

    class MyBaseAdapter extends BaseAdapter {
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
            ViewHolder holder =null;
            if(view==null){
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.grid_item,null);
                holder = new ViewHolder();
                holder.tv = view.findViewById(R.id.gi_tv01);
                holder.iv = view.findViewById(R.id.gi_iv01);
                view.setTag(holder);
            }
            else {
                holder = (ViewHolder) view.getTag();
            }
            holder.tv.setText((CharSequence) list.get(i).get("text"));
            Log.i("tag", list.get(i).get("img").toString());
            holder.iv.setImageResource((Integer) list.get(i).get("img"));
            return view;
        }
    }

    static class ViewHolder {
        ImageView iv;
        TextView tv;
    }


}
