package com.test.niuhongbin.externalstoragedemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtil {

    //存储路径
    public static final String store_path = Environment.getExternalStorageDirectory()+ File.separator+"nhb"+File.separator+"images/";

    //判断SD卡是否已挂载
    public static boolean isMounted(){
        String state = Environment.getExternalStorageState();
        return state.equals(Environment.MEDIA_MOUNTED);
    }

    //保存图片
    public static boolean saveImg(String fileName,byte[] data) throws IOException {
        if(!isMounted()){
            return false;
        }
        File file = new File(store_path);
        if(!file.exists()){
            boolean mkdirs = file.mkdirs();
            if(mkdirs){
            Log.i("tag","111");}
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(new File(file, fileName));
            fileOutputStream.write(data);
            fileOutputStream.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }

    }

    //读取图片
    public static Bitmap readImg(String fileName){
        if(!isMounted()){
            return null;
        }
        File imgFile = new File(store_path,fileName);
        if(imgFile.exists()){
            return BitmapFactory.decodeFile(imgFile.getAbsolutePath());
        }
        return null;
    }
}
