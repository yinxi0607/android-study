package com.test.niuhongbin.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * 需求：选中checkbox时提示选中的文本信息，点击确认按钮打印最终的选择文本 实现全选
 *1、先绑定checkbox的状态监听事件，选中某一项时给出提示信息
 *2、绑定按钮的单击事件，点击时判断最终选择的checkbox，将选择的文本展示
 * 3、实现全选功能
 */

public class MainActivity extends AppCompatActivity {

    private CheckBox cb1,cb2,cb3,cb4,cb5,cb_all;
    private Button btn;
    private MyOnCheckedChangeListener listener = new MyOnCheckedChangeListener();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cb1 = findViewById(R.id.cb01);
        cb2 = findViewById(R.id.cb02);
        cb3 = findViewById(R.id.cb03);
        cb4 = findViewById(R.id.cb04);
        cb5 = findViewById(R.id.cb05);
        cb_all = findViewById(R.id.cball);
        cb1.setOnCheckedChangeListener(listener);
        cb2.setOnCheckedChangeListener(listener);
        cb3.setOnCheckedChangeListener(listener);
        cb4.setOnCheckedChangeListener(listener);
        cb5.setOnCheckedChangeListener(listener);
        btn = findViewById(R.id.btn_o);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btn_o:
                        String st = checkedString();
                        Toast.makeText(MainActivity.this,"你最终选择的爱好有"+st,Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        cb_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.cball:
                        boolean bl = cb_all.isChecked();
                        cb1.setChecked(bl);
                        cb2.setChecked(bl);
                        cb3.setChecked(bl);
                        cb4.setChecked(bl);
                        cb5.setChecked(bl);
                        break;
                }
            }
        });

    }

    public String checkedString(){
        StringBuilder sb = new StringBuilder();
        if(cb1.isChecked()){
            sb.append(cb1.getText().toString());
        }
        if(cb2.isChecked()){
            sb.append(cb2.getText().toString());
        }
        if(cb3.isChecked()){
            sb.append(cb3.getText().toString());
        }
        if(cb4.isChecked()){
            sb.append(cb4.getText().toString());
        }
        if(cb5.isChecked()){
            sb.append(cb5.getText().toString());
        }
        return sb.toString();
    }


//    以内部类的形式实现选中状态改变的监听事件
    class MyOnCheckedChangeListener implements CompoundButton.OnCheckedChangeListener{
    /**
     *
     * @param compoundButton 表示当前状态切换的控件对象
     * @param b 表示当前控件对象的选中状态
     */
    @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//        获取选中状态的文本并且给出提示
//        CheckBox cb = (CheckBox) compoundButton;
//        String st = cb.getText().toString();
//        if(b){
//            Toast.makeText(MainActivity.this,"选中爱好是："+st,Toast.LENGTH_SHORT).show();
//        }

//        如果发现列表中的checkbox全部被选中则全选被选中 否则全选不被选中
        if(cb1.isChecked()&&cb2.isChecked()&&cb3.isChecked()&&cb4.isChecked()&&cb5.isChecked())
        {
            cb_all.setChecked(true);
        }
        else {
            cb_all.setChecked(false);
        }
        }
    }


}
