package com.example.lession11_;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by ff on 2016/9/30.
 */
public class MyBootService extends Service{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("mytest","开机启动的服务已运行");
        return START_REDELIVER_INTENT;
    }
}
