package asynctaskcanceldownload;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownLoadAsyncTask extends AsyncTask<String,Integer,byte[]> {
    private ProgressDialog pd;
    private Context context;
    private ImageView iv;

    public DownLoadAsyncTask(Context context, ImageView iv) {
        this.context = context;
        this.iv = iv;
    }


    @Override
    protected void onPreExecute() {
        pd = new ProgressDialog(context);
        pd.setTitle("显示进度");
        pd.setMessage("Loading....");
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//        点击进度条对话框中的按钮取消AsyncTask
        pd.setButton(ProgressDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                cancel(true);//cancel(boolean b) 如果为true表示取消当前的异步任务
            }
        });
        pd.show();
    }


    /**
     * 表示ui线程中调用cancel（）方法取消异步任务成功时回调的方法
     * 注意 如果onCancelled（）被回调 这是将不再执行onPostExecute（）方法
     */
    @Override
    protected void onCancelled() {
        pd.dismiss();
        Log.i("tag","------onCancelled---异步任务停止了----");
    }

    @Override
    protected byte[] doInBackground(String... strings) {
        Log.i("tag","doInBackground_start");
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
                long totalLength = conn.getContentLength();
                int currentLength = 0;
                byte[] data = new byte[1024];
                int temp=0;
//                isCancelled() 表示AsyncTask是否被取消  当文件没有被读取完毕并且AsyncTask没有停止的情况下继续读取
                while ((temp=inputStream.read(data))!=-1 && !isCancelled()){
                    currentLength+=temp;
                    int progress=(int)((currentLength/(float)totalLength)*100);
                    publishProgress(progress);
                    outputStream.write(data,0,temp);
                    outputStream.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.i("tag","doInBackground_end");
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
            Toast.makeText(context,"没有下载完成",Toast.LENGTH_SHORT).show();
        }
        pd.dismiss();
    }
}
