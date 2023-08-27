package com.test.niuhongbin.viewpagerdemo;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private List<ImageView> mlist;
    private TextView tv;
    private String[] titles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = findViewById(R.id.vp_01);
        tv = findViewById(R.id.tv_01);
        mlist = new ArrayList<ImageView>();

        int[] imageRes = getImageRes();
        titles = getTitles();

        for (int imageRe : imageRes) {
            ImageView iv = new ImageView(this);
            iv.setBackgroundResource(imageRe);
            mlist.add(iv);
        }


        vp.setAdapter(new MyAdapter());
        //界面切换监听
        vp.addOnPageChangeListener(new SimpleOnPageChangeListener(){
            //当某个界面（子视图）被选择后调用的方法
            @Override
            public void onPageSelected(int position) {
                tv.setText(titles[position]);
            }
        });
    }

    //创建一个新闻标题的数组
    private String[] getTitles() {
        return new String[]{"泰拳","狗子","吃翔","滚"};
    }

    private int[] getImageRes() {
        return new int[]{R.mipmap.img6,R.mipmap.img7, R.mipmap.img8, R.mipmap.img9};
    }

    //适配器
    class MyAdapter extends PagerAdapter {

        //用来决定viewpager中到底可以显示多少个子视图
        @Override
        public int getCount() {
            return mlist != null ? mlist.size() : 0;
        }

        //判断是否需要重新生成新的子视图
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        //产生一个新的视图
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mlist.get(position));
            return mlist.get(position);
        }

        //从viewpager中移除某个条目
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mlist.get(position));
        }
    }
}
