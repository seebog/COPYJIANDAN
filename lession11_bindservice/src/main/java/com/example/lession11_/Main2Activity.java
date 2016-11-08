package com.example.lession11_;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    MyBindService mService;
    boolean bindflag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void clickBtn(View view){
        int id=view.getId();
        if(R.id.bindBtn==id)
        {
            Intent intent=new Intent(this,MyBindService.class);
            bindService(intent,mConnetion,BIND_AUTO_CREATE);
//BIND_AUTO_CREA一部方法


        }else if(R.id.unbindBtn==id){
            Intent intent=new Intent(this,MyBindService.class);
//    bindService(intent,mConnetion,BIND_AUTO_CREATE);
            unbindService(mConnetion);
        }else if(R.id.unbindBtn==id){
            if(mService!=null && bindflag){
                mService.asyHelloClient();
            }

        }


    }
    ServiceConnection mConnetion=new ServiceConnection() {
        //当服务端与客户端成功绑定
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i("mytest",name+"服务端于客户端成功绑定");
            MyBindService.MyBinder myBinder= (MyBindService.MyBinder)service;
            mService= myBinder.getService();
            myBinder.sayHello();
            mService.asyHelloClient();
            bindflag=true;


        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("mytest",name+"当服务端与客户端成功jiechu");
            bindflag=false;
        }
    };


    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(bindflag){
            unbindService(mConnetion);

        }
    }
}
