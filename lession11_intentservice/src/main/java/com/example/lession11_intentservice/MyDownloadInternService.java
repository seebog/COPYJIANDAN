package com.example.lession11_intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by ff on 2016/9/30.
 */
public class MyDownloadInternService extends IntentService{

    public MyDownloadInternService(String name) {

        super(name);

    }

    public MyDownloadInternService(){
        super("DownloadThrea");

    }
    @Override
    protected void onHandleIntent(Intent intent) {
       String pic= intent.getStringExtra("pic");
        for(int i=0;i<100;i++){

            Log.i("mytest","正在下载图片"+pic+"进度"+i+"%");

        }
    }

    @Override
    public void onCreate() {
         super.onCreate();
    Log.i("mytest","IntentService被创建");
    }

    @Override
    public void onDestroy() {

        Log.i("mytest","IntentService被销毁");
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }
}
