package com.test.niuhongbin.viewpagerfragmentdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ContentFragmentActivity extends Fragment {

    //创建ContentFragmentActivity对象的方法
    public static ContentFragmentActivity newInstance(String msg){
        ContentFragmentActivity fragmentActivity = new ContentFragmentActivity();
        Bundle args = new Bundle();
        args.putString("msg",msg);
        fragmentActivity.setArguments(args);
        return fragmentActivity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.activity_content_fragment, null);
        TextView viewById = inflate.findViewById(R.id.tv_content);
        Bundle argments = getArguments();
        if(argments!=null){
            String msg = argments.getString("msg", "");
            viewById.setText(msg);
        }
        return inflate;
    }
}
