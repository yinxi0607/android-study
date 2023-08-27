package com.test.niuhongbin.tweenanimationdemo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Switch;

import java.security.acl.AclNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = findViewById(R.id.iv_01);
    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.btn_a
                                /***图片透明度变化***/:
//                方法一

//                //0.0f 为起始透明度，1.0f为结束时的透明度
//                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.5f);
//                //动画执行时间
//                alphaAnimation.setDuration(2000);
//                //设置重复执行次数
//                alphaAnimation.setRepeatCount(2);
//                //重试模式Animation.REVERSE;Animation.RESTART
//                alphaAnimation.setRepeatMode(Animation.REVERSE);
//                //保持结束时候的状态
//                alphaAnimation.setFillAfter(true);
//                //开始执行动画
//                iv.startAnimation(alphaAnimation);



//                方法二  属性动画

                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iv,"alpha",0,0.5f);
                objectAnimator.setDuration(2000);
                objectAnimator.setRepeatCount(2);
                objectAnimator.start();

                break;
            case R.id.btn_t:
                                /***图片平移***/
////                方法一

//                //x轴开始，x轴结束，y轴开始，y轴结束
////                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f,300.0f,0.0f,200.0f);
//
//                //Animation.RELATIVE_TO_SELF+0.0f 控件现在所在的坐标+0*控件本身的宽度
//                //Animation.RELATIVE_TO_SELF+0.5f 控件现在所在的坐标+0.5*控件本身的宽度
//                //Animation.RELATIVE_TO_PARENT+0.5f 控件现在所在的坐标+0.5*控件的父控件的宽度
//                TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.55f,
//                        Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.3f);
//
//                translateAnimation.setDuration(2000);
//                translateAnimation.setRepeatCount(2);
//                translateAnimation.setRepeatMode(Animation.REVERSE);
//                iv.startAnimation(translateAnimation);


//                方法二  属性动画
                ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(iv,"translationX",0,200f);
                objectAnimator1.setDuration(2000);
                objectAnimator1.setRepeatCount(2);
                objectAnimator1.start();
                break;
            case R.id.btn_s:
                /***图片缩放***/

//                方法一
////                ScaleAnimation scaleAnimation = new ScaleAnimation(0,2,0,1);
//                ScaleAnimation scaleAnimation = new ScaleAnimation(1, 2, 1, 2, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//                scaleAnimation.setDuration(2000);
//                scaleAnimation.setRepeatCount(2);
//                iv.startAnimation(scaleAnimation);

//                方法二
                ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(iv,"scaleX",0,30);
                objectAnimator3.setDuration(200);
                objectAnimator3.start();
                break;
            case R.id.btn_r:
                /****图片旋转**/
//                方法一
////                RotateAnimation rotateAnimation = new RotateAnimation(0,45);
//                RotateAnimation rotateAnimation = new RotateAnimation(0,90,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//                rotateAnimation.setDuration(2000);
//                rotateAnimation.setRepeatCount(2);
//                rotateAnimation.setRepeatMode(Animation.REVERSE);
//                iv.startAnimation(rotateAnimation);


//                方法二
                ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(iv,"rotationX",0,180);
                objectAnimator2.setDuration(200);
                objectAnimator2.start();

                break;
            case R.id.btn_c:
                /***动画集合***/

//                方法一
//                AnimationSet animationSet = new AnimationSet(true);
//                TranslateAnimation translateAnimationSet = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.55f,
//                        Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.3f);
//                RotateAnimation rotateAnimationSet = new RotateAnimation(0,90,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//                animationSet.addAnimation(translateAnimationSet);
//                animationSet.addAnimation(rotateAnimationSet);
//                animationSet.setDuration(5000);
//                animationSet.setRepeatMode(Animation.REVERSE);
//                animationSet.setRepeatCount(2);
//                iv.startAnimation(animationSet);

//                方法二
                AnimatorSet animatorSet = new AnimatorSet();
                ObjectAnimator objectAnimator5 = ObjectAnimator.ofFloat(iv,"scaleX",0,1.5f);
                ObjectAnimator objectAnimator6 = ObjectAnimator.ofFloat(iv,"translationX",0,200f);
                ObjectAnimator objectAnimator7 = ObjectAnimator.ofFloat(iv,"rotationX",0,180);
                List<Animator> list = new ArrayList<>();
                list.add(objectAnimator5);
                list.add(objectAnimator6);
                list.add(objectAnimator7);
                animatorSet.playSequentially(list);
                animatorSet.setDuration(2000);
                animatorSet.start();
                break;
        }
    }
}
