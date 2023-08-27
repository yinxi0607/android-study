package com.test.niuhongbin.viewpagerfragmentdemo;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private List<Fragment> flist;
    private PagerTabStrip pts;
    private String[] tabNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = findViewById(R.id.vp_01);
        pts = findViewById(R.id.pts_01);
        pts.setTextColor(Color.RED);
        pts.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        //设置指示线的颜色
        pts.setTabIndicatorColor(Color.GRAY);
        tabNames = getResources().getStringArray(R.array.pts_name);


        //List的泛型必须是v4包中的fragment对象
        flist = new ArrayList<Fragment>();
        for (int i = 0; i < 3; i++) {
            ContentFragmentActivity fragmentActivity = ContentFragmentActivity.newInstance("第" + i + "个Fragment");
            flist.add(fragmentActivity);
        }

        //必须得到一个v4包中的fragmentmanager
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        MyAdapter myAdapter = new MyAdapter(supportFragmentManager);
        vp.setAdapter(myAdapter);
    }

    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        //获取每个界面对应的标题
        @Override
        public CharSequence getPageTitle(int position) {
            return tabNames[position];
        }

        @Override
        public Fragment getItem(int position) {
            return flist.get(position);
        }

        @Override
        public int getCount() {
            return flist!=null?flist.size():0;
        }
    }
}
