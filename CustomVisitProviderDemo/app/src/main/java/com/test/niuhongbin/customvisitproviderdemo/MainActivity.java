package com.test.niuhongbin.customvisitproviderdemo;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ContentResolver resolver;
    private String URI_NHB = "content://nhb/person";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resolver = getContentResolver();
    }

    public void click(View view) {
        switch (view.getId()){
            case R.id.btn_insert:
                Toast.makeText(this,"!!!!!!!!----------!!!!!!!!!",Toast.LENGTH_SHORT).show();
                ContentValues values = new ContentValues();
                values.put("name","宋江");
                Uri result = resolver.insert(Uri.parse(URI_NHB), values);
                if (ContentUris.parseId(result)>0){
                    Toast.makeText(this,"添加成功",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_query:
                Cursor cursor = resolver.query(Uri.parse(URI_NHB),null,null,null,null);
                if (cursor != null) {
                    while (cursor.moveToNext()){
                        String name = cursor.getString(cursor.getColumnIndex("name"));
//                        Log.i("TAG","name="+name);
                        Toast.makeText(this,"name="+name,Toast.LENGTH_SHORT).show();

                    }
                }
                cursor.close();
                break;
        }
    }
}
