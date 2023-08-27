package com.test.niuhongbin.alertdialogdemo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAlertDialog();
    }

    private void initAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("标题").setMessage("是否退出").setPositiveButton("确定", new DialogInterface.OnClickListener() {

            //确定退出app
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        }).setNegativeButton("取消", null);
        dialog = builder.create();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode==KeyEvent.KEYCODE_BACK)&&(!dialog.isShowing())){
            dialog.show();
        }else if(keyCode==KeyEvent.KEYCODE_MENU){
            Toast.makeText(this,"kkkkk",Toast.LENGTH_SHORT).show();
        }

        return super.onKeyDown(keyCode, event);
    }

    public void click(View view) {
        if(!dialog.isShowing()){
            dialog.show();
        }
    }
}
