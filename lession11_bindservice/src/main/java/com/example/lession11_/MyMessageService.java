package com.example.lession11_;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by ff on 2016/10/2.
 */
public class MyMessageService extends Service {

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
//            super.handleMessage(msg);

            if(msg.what==0x101){

                sayHelloClient();

            }

        }
    };

    final Messenger msger=new Messenger(handler);


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return msger.getBinder();


    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    public void sayHelloClient(){
        Toast.makeText(this.getApplicationContext(),"服务端sayhello",Toast.LENGTH_LONG).show();



    }

}
