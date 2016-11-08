package com.example.myfirstservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by ff on 2016/9/28.
 */
//定义一个服务需要在清单文件中配置
public class FirstService  extends Service{

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

//当服务第一次被开启的时候调用
    @Override
    public void onCreate() {
        Log.i("mytest","onCreate");

        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i("mytest","onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }

//服务销毁的时候执行
    @Override
    public void onDestroy() {
        Log.i("mytest","onDestory");

        super.onDestroy();
    }
}
