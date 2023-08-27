 package com.test.niuhongbin.fragmentpassvalue;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

 public class MainActivity extends AppCompatActivity {

     private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ContentFragmentActivity contentFragmentActivity = new ContentFragmentActivity();
        fragmentTransaction.add(R.id.fl_content,contentFragmentActivity,"content");
        fragmentTransaction.commit();
    }

     public void click(View view) {
         ContentFragmentActivity content = (ContentFragmentActivity) fragmentManager.findFragmentByTag("content");
        content.recMsg("我在Activityzhong");
     }
 }
