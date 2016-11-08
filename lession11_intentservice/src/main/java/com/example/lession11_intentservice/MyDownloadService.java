package com.example.lession11_intentservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by ff on 2016/9/30.
 */
public class MyDownloadService extends Service {
  int count;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
     count++;
        new MyDownLoadThread("Thread"+count).start();
        return START_REDELIVER_INTENT;
    }
    public class MyDownLoadThread extends Thread{
        public MyDownLoadThread(String name){
            this.setName(name);
        }
//        @Override
        public void run() {
//            super.run();
          for(int i=0;i<100;i++){
            SystemClock.sleep(100);
            Log.i("mytest",this.getName()+"县城下载"+i+"%");
        }
      }
//        n
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    //终止服务就需要结束正在进行的线程

    }
}
