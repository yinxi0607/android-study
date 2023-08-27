package com.test.niuhongbin.listdialogdemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AlertDialog.Builder builder;
    private TextView tvMessage;
    private int checkedItem = 0;
    private AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMessage=findViewById(R.id.tv_message);
    }

    public void click(View view) {
        builder = new AlertDialog.Builder(this);
        builder.setTitle("设置字体大小");
        builder.setIcon(android.R.drawable.btn_star_big_on);
        dialog = builder.setSingleChoiceItems(R.array.font_names, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                checkedItem = i;
//                获取字体列表信息
                String[] fontNames = getResources().getStringArray(R.array.font_names);
//                设置标题栏文本
                setTitle(fontNames[i]);
//                设置字体大小
                int[] fontSizes = getResources().getIntArray(R.array.font_sizes);
                tvMessage.setTextSize(fontSizes[i]);
                dialog.dismiss();
            }
        }).create();
        dialog.show();
    }
}
