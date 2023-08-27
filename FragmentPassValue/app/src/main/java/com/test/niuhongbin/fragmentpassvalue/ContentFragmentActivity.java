package com.test.niuhongbin.fragmentpassvalue;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ContentFragmentActivity extends Fragment {

    private String msg;
    private TextView tv;
    public void recMsg(String msg){
        this.msg = msg;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_content_fragment,null);
        Button button = view.findViewById(R.id.btn_rec);
        tv = view.findViewById(R.id.tv_receive);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(msg!=null){
                    tv.setText("接收到的值为"+msg);
                }else {
                    tv.setText("啥也没有呀");
                }
            }
        });
        return view;

    }
}
