package com.example.lession8_innerfile;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
EditText nameTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            nameTxt=(EditText)findViewById(R.id.nameTxt);

    }
public void clickBtn(View view) {
    int id = view.getId();
    String name = nameTxt.getText().toString();

    FileOutputStream fos = null;
    if (R.id.btn1 == id) {
        try {
            fos = this.openFileOutput("info.txt", Context.MODE_PRIVATE);

//        fos=this.openFileOutput("info.txt", Context.MODE_WORLD_WRITEABLE);
            fos.write(name.getBytes("utf-8"));
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    } else if (R.id.btn2 == id) {
        try {
            FileInputStream fis = this.openFileInput("info.txt");
            byte[] data = new byte[1024];
            int length = fis.read(data);
            String info = new String(data, 0, length);
            Toast.makeText(this, "读到的数据是：" + info, Toast.LENGTH_LONG).show();
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } else if (R.id.btn2 == id) {
        try {
            FileInputStream fis = this.openFileInput("info.txt");
            byte[] data = new byte[1024];
            int length = fis.read(data);
            String info = new String(data, 0, length);
            Toast.makeText(this, "读到的数据是：" + info, Toast.LENGTH_LONG).show();
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } else if (R.id.btn3 == id) {
//        String name=nameTxt.getText().toString();
//        FileOutputStream fos=null;
        //获得存贮器路径
        String path=Environment.getExternalStorageDirectory()+"/mydata/info.txt";
        //2.2 path=/sdcard
        //2.3-4.1 path=/mnt/sdcard
        //4.1网上 path=/storage/elumated/legency/0
        Log.i("test","path="+path);
        try {
//            fos = this.openFileOutput("info.txt", Context.MODE_PRIVATE);
            fos=new FileOutputStream(path);
            fos.write(name.getBytes("utf-8"));
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } else if (R.id.btn4 == id) {

        String path="";
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            path=Environment.getExternalStorageDirectory()+"/mydata/info.txt";

//            path=  Environment.getExternalStorageDirectory()+"/mydata/info.txt";

        }
        try {
            FileInputStream fis = new FileInputStream(path);

            byte[] data = new byte[1024];
            int length = fis.read(data);
            String info = new String(data, 0, length);
         Log.i("test","info"+info);
            Toast.makeText(this, "sdcard读到的数据是：" + info, Toast.LENGTH_LONG).show();
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        }


    }

