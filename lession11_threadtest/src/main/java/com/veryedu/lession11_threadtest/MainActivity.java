package com.veryedu.lession11_threadtest;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void  clickBtn(View view)
    {
        int id=view.getId();
        if(id==R.id.startBtn)
        {
            mt=new MyThread();
            mt.start();
        }else if(id==R.id.endBtn)
        {
            if(mt!=null) {
                mt.stopRun();
                mt = null;
            }
        }

    }
    private MyThread mt=null;


    public class  MyThread extends Thread
    {

        volatile boolean  isStop=false;

        @Override
        public void run() {
            while(!isStop) {
                Log.i("mytest", "aaaaaaaaa");
                SystemClock.sleep(1000);
            }
        }

        public  void  stopRun()
        {
            isStop=true;
        }

    }

}
