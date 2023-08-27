package com.test.niuhongbin.downloadimagedemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.PrecomputedText;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/*
* 演示点击按钮下载图片
*
*
*
* */

public class MainActivity extends AppCompatActivity {
    private String image_url = "http://imgsa.baidu.com/exp/w=235/sign=c95bf9579a58d109c4e3aeb1e458ccd0/b812c8fcc3cec3fde80c3d5cde88d43f879427ec.jpg";
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = findViewById(R.id.iv01);
    }

    public void downLoadImg(View view) {
//        启动异步任务
        new MyAsyncTask().execute(image_url);
    }


    /**
     * AsyncTask<Params,Progress,Result>
     *     Params 表示当前的AsyncTask操作时需要的参数类型
     *     Progress 表示当前AsyncTask耗时操作时的进度类型 Void没有进度
     *     Result 表示当前AsyncTask耗时操作结果的数据类型 byte[]下载图片获取的结果
     *
     * 抽象类所以必须要重写抽象方法
     */
    class MyAsyncTask extends AsyncTask<String,Void,byte[]>{

        /**
         * 表示在AsyncTask执行之前运行在ui线程中的准备方法  初始化操作
         */
        @Override
        protected void onPreExecute() {
            Log.i("tag",Thread.currentThread().getName()+"--------------onPreExecute--------------");
        }

        /**
         * 表示在onPreExecute()方法执行结束后立即执行
         * 主要进行耗时操作
         * 该方法运行在工作线程中
         * @param strings 该方法的参数类型与类中范型第一个参数类型一致
         * @return 返回值与类中范型第三个参数一致
         */
        @Override
        protected byte[] doInBackground(String... strings) {
            Log.i("tag",Thread.currentThread().getName()+"--------------doInBackground--------------");
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] images = null;
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoInput(true);
                conn.setRequestMethod("GET");
                conn.connect();
                int responseCode = conn.getResponseCode();
                if (responseCode==200){
                    InputStream input = conn.getInputStream();
                    byte[] data = new byte[1024];
                    int temp=0;
                    while ((temp=input.read(data))!=-1){
                        outputStream.write(data,0,temp);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            images = outputStream.toByteArray();
            return images;
        }

        /**
         * 当doINBackground()方法执行完毕后将耗时操作的结果返回给该方法
         * 该方法负责将数据结果返回给UI界面
         * @param bytes
         */
        @Override
        protected void onPostExecute(byte[] bytes) {
            Log.i("tag",Thread.currentThread().getName()+"--------------onPostExecute--------------");
            if(bytes!=null&&bytes.length!=0){
//                将图片的字节数组转换成图片对象，bimap对象
                Bitmap bm = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                iv.setImageBitmap(bm);
            }
            else {
                Toast.makeText(MainActivity.this,"图片下载失败",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
