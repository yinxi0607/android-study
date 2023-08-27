package com.test.niuhongbin.internalstoragedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
* 内部存储：openFileOutput()写入流,openFileInput()读取只读流,deleteFile()删除文件
* 文件保存的位置：/data/data/appname/files/filename
* 内部存储的特点：内存存储里面的东西会随着app的卸载而删除掉
* */

public class MainActivity extends AppCompatActivity {

    private EditText etName,etContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.et_name);
        etContent = findViewById(R.id.et_content);
    }

    public void click(View view) {
        switch (view.getId()){
            case R.id.btn_open:
                String fileName = etName.getText().toString().trim();
                if(TextUtils.isEmpty(fileName)){
                    return;
                }
                try {
                    //得到一个只读的输入流
                    FileInputStream fileInputStream = openFileInput(fileName);
                    byte[] buffer = new byte[fileInputStream.available()];
                    fileInputStream.read(buffer);
                    fileInputStream.close();
                    etContent.setText(new String(buffer));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_save:
                String fileNameSave = etName.getText().toString().trim();
                String fileContent = etContent.getText().toString().trim();
                if(TextUtils.isEmpty(fileNameSave)&&TextUtils.isEmpty(fileContent)){
                    return;
                }
                try {
                    //打开一个用来读写的文件，该文件是与当期上下文所在的包有关的，而且不需要添加任何权限
                    FileOutputStream fileOutputStream = openFileOutput(fileNameSave, MODE_PRIVATE);
                    fileOutputStream.write(fileContent.getBytes());
                    fileOutputStream.close();
                    etContent.setText("");
                    etName.setText("");
                    Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_del:
                String fileNameDel = etName.getText().toString().trim();
                if(TextUtils.isEmpty(fileNameDel)){
                    return;
                }
                //删除上下文中指定名称的文件
                boolean b = deleteFile(fileNameDel);
                if(b){
                    Toast.makeText(this,"删除成功",Toast.LENGTH_SHORT).show();
                    etContent.setText("");
                    etName.setText("");
                }

                break;
        }
    }
}
