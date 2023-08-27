package com.test.niuhongbin.cursorloaderdemo;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

//1、实现LoaderCallbacks<Cursor>接口
public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks {

    private ListView lv;
    private SimpleCursorAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv_01);
        adapter = new SimpleCursorAdapter(this,R.layout.activity_list_view,null,new String[]{"_id","display_name"},new int[]{R.id.tv_id,R.id.tv_name},SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        lv.setAdapter(adapter);

        //2、初始化loader
        getLoaderManager().initLoader(1,null,this);

    }

    //3、创建loader对象
    @Override
    public Loader onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this, ContactsContract.RawContacts.CONTENT_URI,new String[]{"_id","display_name"},null,null,null);
    }

    //4、数据加载完毕
    @Override
    public void onLoadFinished(Loader loader, Object o) {
        adapter.swapCursor((Cursor) o);
    }

    //5、数据加载充值
    @Override
    public void onLoaderReset(Loader loader) {
        adapter.swapCursor(null);
    }
}
