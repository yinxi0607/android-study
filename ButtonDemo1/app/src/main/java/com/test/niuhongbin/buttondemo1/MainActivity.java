package com.test.niuhongbin.buttondemo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/*
演示Button的点击事件
1、需要绑定单击事件的button标签中设置android:onClick属性值
2、在加载当前layout布局的activity中添加的方法
    public 修饰符   没有返回值void 并且有唯一的view类型的参数
    要求方法名称必须和onClick属性相同
3、在该方法中添加点击按钮的操作代码

 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        int id =view.getId();//获取点击控件的id
        switch (id){
            case R.id.btn:
                Toast.makeText(MainActivity.this,"我被点击了",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn2:
                Toast.makeText(MainActivity.this,"我再次被点击了",Toast.LENGTH_SHORT).show();
                break;
        }

//        Toast.makeText(MainActivity.this,"我被点击了",Toast.LENGTH_SHORT).show();
    }
}
