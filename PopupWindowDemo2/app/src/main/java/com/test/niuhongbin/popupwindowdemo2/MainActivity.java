package com.test.niuhongbin.popupwindowdemo2;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View viewContent;
    private PopupWindow mWindow;
    private ImageView ivBack,ivColloct,ivShare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPopupWindow();
        initView();
    }

    private void initView() {
        ivBack = viewContent.findViewById(R.id.iv_back);
        ivColloct = viewContent.findViewById(R.id.iv_colloct);
        ivShare = viewContent.findViewById(R.id.iv_share);
        ivBack.setOnClickListener(this);
        ivColloct.setOnClickListener(this);
        ivShare.setOnClickListener(this);

    }

    private void initPopupWindow() {
        viewContent = getLayoutInflater().inflate(R.layout.activity_pop,null);
        mWindow = new PopupWindow(viewContent, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        //设置触摸popupwindows外部区域时是否可以使得popupwindows消失
        mWindow.setOutsideTouchable(true);
        //设置背景
//        mWindow.setBackgroundDrawable();
        //设置popupwindows是否在触摸时会有响应
//        mWindow.setTouchable();

    }


    //处理按键方法
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_MENU:
//                isShowing()表示控件是否在展示
                if(mWindow.isShowing()){
                    mWindow.dismiss();
                }else {
                    //如果没有显示，则显示出来
                    mWindow.showAtLocation(viewContent, Gravity.BOTTOM,0,0);
                }
                break;
            case KeyEvent.KEYCODE_BACK:
                if(mWindow.isShowing()){
                    mWindow.dismiss();
                }
                break;
        }
        return super.onKeyDown(keyCode,event);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_back:
                finish();
                if(mWindow.isShowing()){
                    mWindow.dismiss();
                }
                break;
            case R.id.iv_colloct:
                Toast.makeText(this,"收藏",Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_share:
                Toast.makeText(this,"分享",Toast.LENGTH_SHORT).show();
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mWindow!=null){
            mWindow.dismiss();
            mWindow=null;
        }
    }

    //由于使用小米手机 menu按钮没有反应，所有添加textview点击事件启动popupwindows
    public void click(View view) {
        if(mWindow.isShowing()){
            mWindow.dismiss();
        }else {
            //如果没有显示，则显示出来
            mWindow.showAtLocation(viewContent, Gravity.BOTTOM,0,0);
        }
    }
}
