package com.test.niuhongbin.imageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/*
* 演示imageview实现图片切换
*
* 将需要展示的图片存储到容器
* 点击上一张 获取当前图片容器中的上一张图片动态展示 如果图片已经是第一张了 直接展示第一张就好
* 点击下一桌 获取当前图片容器中的下一张图片动态展示 如果图片已经是最后一张了 直接展示最后一张就好了
* */

public class MainActivity extends AppCompatActivity {
    private int[] images={R.mipmap.img1,R.mipmap.img2,R.mipmap.img3,R.mipmap.img4,R.mipmap.img5,R.mipmap.img6,R.mipmap.img7,
            R.mipmap.img8,R.mipmap.img9};
    private ImageView iv;
    private int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
        iv = findViewById(R.id.imv);
    }

    public void click(View view){
        switch (view.getId()){
            case R.id.btn_pre:
//                上一张
                index--;
                break;
            case R.id.btn_next:
//                下一张
                index++;
                break;
        }
        if(index<0){
            index=0;
        }
        if(index>images.length-1)
        {
            index=images.length-1;
        }

//        确定当前展示的图片资源id setImageResourced(int imageId) 根据参数指定的图片资源id动态展示对应图片
        iv.setImageResource(images[index]);
    }

}
