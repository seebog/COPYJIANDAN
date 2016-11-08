package com.veryedu.lession11_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by maggie on 15/8/26.
 */
public class MyTestService extends Service{

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("mytest","服务的onBind方法");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("mytest", "服务的onCreate方法");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("mytest", "服务的onDestroy方法");

    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        String name=intent.getStringExtra("name");

        if(flags==START_FLAG_REDELIVERY)
        {

        }else if(flags==START_FLAG_RETRY)
        {

        }

        Log.i("mytest", "服务的onStartCommand方法 name="+name);

        return START_REDELIVER_INTENT;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("mytest", "服务的onUnbind方法");
        return super.onUnbind(intent);

    }
}
