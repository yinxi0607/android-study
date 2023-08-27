package com.test.niuhongbin.contextmenudemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv01);
//        注册上下文菜单-->通常上下文菜单是和listview或者GridView这种适配器控件绑定在一起的
        registerForContextMenu(tv);
    }

    //创建上下文菜单

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
//        将main。xml文件填充到menu对象中
        getMenuInflater().inflate(R.menu.menu_main,menu);
    }

    //处理上下文菜单的点击事件
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_get_width:
                //设置标题的内容
                setTitle("控件的宽度"+tv.getWidth());

                Toast.makeText(MainActivity.this,"控件的宽度"+tv.getWidth(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_get_hight:
                setTitle("控件的宽度"+tv.getHeight());
                Toast.makeText(MainActivity.this,"控件的高度"+tv.getHeight(),Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}
