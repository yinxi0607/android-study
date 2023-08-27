package com.test.niuhongbin.toastdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /*
    点击按钮弹出
    */
    public void click(View view){
        switch (view.getId()){
            case R.id.btn01:
//                makeText()创建Toast上下文对象，表示弹出提示信息文本，表示弹出Toast持续时间 毫秒
                Toast.makeText(MainActivity.this,"我是Toast！",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn02:
                Toast toast = Toast.makeText(MainActivity.this,"网络中断，请检查！",Toast.LENGTH_SHORT);
//                toast.setGravity(设置当前Toast的位置，表示设置x轴的偏移量，表示y轴的偏移量);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
        }
    }
}
