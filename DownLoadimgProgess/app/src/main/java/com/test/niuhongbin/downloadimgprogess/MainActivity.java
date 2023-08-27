package com.test.niuhongbin.downloadimgprogess;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/*
* 演示启动异步任务AsyncTask 下载图片显示下载进度
* */

public class MainActivity extends AppCompatActivity {

    private ImageView iv;
    private String imagePath = "http://pic30.photophoto.cn/20140214/0042040378976030_b.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = findViewById(R.id.iv01);
    }

//    点击按钮下载图片并展示下载进度
    public void downLoadImg(View view) {
        new MyAsyncTask().execute(imagePath);
    }

    class MyAsyncTask extends AsyncTask<String,Integer,byte[]>{

        private ProgressDialog pd;


        @Override
        protected void onPreExecute() {
            pd = new ProgressDialog(MainActivity.this);
            pd.setTitle("提示进度");
            pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pd.show();
        }

        @Override
        protected byte[] doInBackground(String... strings) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoInput(true);
                conn.setRequestMethod("GET");
                conn.connect();
                int responseCode = conn.getResponseCode();
                if(responseCode==200){
                    InputStream inputStream = conn.getInputStream();
//                  获取下载图片数据文件的总长度
                    long totalLength = conn.getContentLength();
                    int currentLength =0;//表示当前下载图片的文件长度
                    byte[] data = new byte[1024];
                    int temp = 0;
                    while ((temp=inputStream.read(data))!=-1) {
                        currentLength+=temp;//将每次循环读取的内容添加到当前的进度变量中

//                        根据文件的总长度与当前下载的长度计算 获得图片的下载进度
                        int progress = (int) ((currentLength/(float)totalLength)*100);
//                        将进度发布到主线程中
                        publishProgress(progress);
                        outputStream.write(data,0,temp);
                        outputStream.flush();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return outputStream.toByteArray();
        }

        /**
         * 表示运行在主线程中用了更新进度的回调方法
         * 如果DoInBackground（）方法中调用publishProgress（）方法，向主线程中发布进度，由该方法获取进度后更新UI界面进度
         * @param values
         */
        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.i("tag",Thread.currentThread().getName()+"onProgressUpdate");
            pd.setProgress(values[0]);

        }

        @Override
        protected void onPostExecute(byte[] bytes) {
            if(bytes!=null&&bytes.length!=0){
                Bitmap bm = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                iv.setImageBitmap(bm);
            }
            else{
                Toast.makeText(MainActivity.this,"没有下载完成",Toast.LENGTH_SHORT);
            }
            pd.dismiss();
        }
    }
}
