package com.example.lession11_;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by ff on 2016/10/1.
 */
public class MyBindService extends Service{

    IBinder mBinder=new MyBinder();
    public class MyBinder extends Binder {
    public  MyBindService getService(){

        return MyBindService.this;
    }
        public void sayHello(){
            Toast.makeText(getApplicationContext(),"在Binder中sayhello",Toast.LENGTH_LONG).show();


        }



    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("mytest","onBind被执行");
        return mBinder;
    }

    @Override
    public void onCreate() {
        Log.i("mytest","onCreate被执行");

        super.onCreate();

    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("mytest","onUnbind被执行");

        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.i("mytest","onDestory被执行");

        super.onDestroy();
    }
public void asyHelloClient(){
    Toast.makeText(getApplicationContext(),"sayHellpClient",Toast.LENGTH_LONG).show();

}

}
