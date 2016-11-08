package com.example.lession10_ansyctask;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
         TextView prgTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            prgTxt=(TextView) findViewById(R.id.prgTxt);
    }
    public void clickBtn(View view){
new MyDownloadTask().execute("http://localhost.com/1.png");

    }
//第一个参数  就是知名你异步任务要执行需要获得的参数的类型
    //第er个参数是你的进度表示用什么类型

    //第san个泛型参数 是异步任务完成hou需要提交的结果，他的结果类型
    public class MyDownloadTask extends AsyncTask<String,Integer,Bitmap>{


//在异步任务开始之前完成一些准备初始化工作
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        //下载任务结果
        //这个恶方法中应该改实现操作结果的代码    更新界面
        //这个方法中得代码是在主线程中执行
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            prgTxt.setText("下载完成");
        }
        //更新进度
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            prgTxt.setText("下载中"+values[0]+"%");
        }


        //这个方法是完成后台要执行的任务
        //这个方法的代码是在子线程中执行
        @Override
        protected Bitmap doInBackground(String... params) {
            for(int i=0;i<100;i++){
                SystemClock.sleep(100);
                //更新进度
                this.publishProgress(i);
            }
            return null;
        }



    }





}
