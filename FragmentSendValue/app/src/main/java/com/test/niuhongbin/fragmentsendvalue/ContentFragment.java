package com.test.niuhongbin.fragmentsendvalue;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ContentFragment extends Fragment {

    private TextView tv;
    private Button btn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_content_fragment,null);
//        return super.onCreateView(inflater, container, savedInstanceState);

        btn = view.findViewById(R.id.btn_get);

        tv = view.findViewById(R.id.tv_02);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getArguments();
                if(bundle!=null){
                    String value = bundle.getString("key");
                    tv.setText("接收的信息是"+value);
                }
            }
        });

        return view;
    }
}
