package com.test.niuhongbin.buttondemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

/*
1、需要给button所在的xml布局文件中button标签添加android：id属性
2、在对应的activity中调用ViewByID（）方法根据iD获取具体的控件
3、调用button的setOnClickListener()方法设置按钮的单击事件监听
    只要按钮被单击就会回调相应的方法

 */


public class MainActivity extends AppCompatActivity {

    private Button btn,btn01;
    private MyOnClickListener listener = new MyOnClickListener();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn1);//根据资源id获取view视图
        btn01 = findViewById(R.id.btn2);

//        方式二 内部类的形式
        btn.setOnClickListener(listener);
        btn01.setOnClickListener(listener);



        //方式一：匿名内部类的形式  给button按钮设置单击事件
//        给button按钮设置单击事件监听

//        btn.setOnClickListener(new View.OnClickListener(){
////            当前按钮被单击时回调的方法
//            @Override
//            public void onClick(View v){
//                Toast.makeText(MainActivity.this,"我被点击了！！！",Toast.LENGTH_SHORT).show();
//
//            }
//        });



    }
//    定义一个内部类 进行调用
    class MyOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v){
            switch (v.getId()){
                case R.id.btn1:
                    Toast.makeText(MainActivity.this,"第一个按钮被点击了",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn2:
                    Toast.makeText(MainActivity.this,"第二个按钮被点击了",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

}
