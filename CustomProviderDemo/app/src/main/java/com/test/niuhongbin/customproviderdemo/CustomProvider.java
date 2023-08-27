package com.test.niuhongbin.customproviderdemo;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class CustomProvider extends ContentProvider {

    private SQLiteDatabase db;

    private static UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    private static final int PERSON = 1;
    //构建uri路径
    static {
        //content://nhb/person
        uriMatcher.addURI("nhb","person",PERSON);
        //content://nhb/person/1
        uriMatcher.addURI("nhb/#","person",PERSON); //#代表任意数字
        //content://nhb/person/filter/djaslf
        uriMatcher.addURI("nhb/filter/*","person",PERSON); //*代表任意文本
    }

    @Override
    public boolean onCreate() {
        DBHelper dbHelper = new DBHelper(getContext(),null,null,1);
        db = dbHelper.getWritableDatabase();
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        int match = uriMatcher.match(uri);
        switch (match){
            case PERSON:
                Cursor result = db.query("person", strings, s, strings1, s1, null, null);
                return result;
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        int match = uriMatcher.match(uri);
        switch (match){
            case PERSON://content://nhb/person
                long id = db.insert("person", null, contentValues);
                //将原有的uri与id进行拼接，从而形成一个新的uri
                return ContentUris.withAppendedId(uri,id);
        }
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
