package com.test.niuhongbin.fragmentsendvalue;

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

    }

    //Activity给fragment传值
    public void click(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ContentFragment contentFragment = new ContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key","我在Activity中传递的信息");
        contentFragment.setArguments(bundle);
        fragmentTransaction.add(R.id.fl_01,contentFragment);
        fragmentTransaction.commit();
    }
}
