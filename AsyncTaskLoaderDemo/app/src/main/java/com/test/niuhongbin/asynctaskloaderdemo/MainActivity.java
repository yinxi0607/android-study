package com.test.niuhongbin.asynctaskloaderdemo;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Loader;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


//1.实现LoaderCallback<Cursor>接口
public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks{

    private ListView lv;
    private SimpleCursorAdapter adapter;
    private static ContentResolver contentResolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv01);
        adapter = new SimpleCursorAdapter(this,R.layout.activity_list_view,null,new String[]{"_id","display_name"},new int[]{R.id.tv_id,R.id.tv_name},SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        lv.setAdapter(adapter);

        contentResolver = getContentResolver();

        //2、初始化Loader，也就是添加监听
        LoaderManager manager = getLoaderManager();
        manager.initLoader(1,null,this);
    }


    /********************以下为接口的方法**********************/

    //3.创建一个loader对象
    @Override
    public Loader onCreateLoader(int i, Bundle bundle) {
        return new MyLoader(this);
    }

    @Override
    public void onLoadFinished(Loader loader, Object o) {
        //利用o来置换原有的cursor
        adapter.swapCursor((Cursor) o);
    }

    @Override
    public void onLoaderReset(Loader loader) {
        //
        adapter.swapCursor(null);
    }

    //异步任务loader
    static class MyLoader extends AsyncTaskLoader<Cursor>{
        public MyLoader(Context context) {
            super(context);
        }

        //开始加载的时候调用的方法
        @Override
        protected void onStartLoading() {
            super.onStartLoading();
            //强制加载
            forceLoad();
        }

        //后台线程中进行数据加载的方法,---->后台线程：进行耗时操作
        @Override
        public Cursor loadInBackground() {
            //content://com.android.contacts/raw_contacts
            return contentResolver.query(ContactsContract.RawContacts.CONTENT_URI,new String[]{"_id","display_name"},null,null,null);
        }
    }
}
