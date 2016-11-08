package com.example.lession11_;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

MyBindService mService;
boolean bindflag=false;
boolean msgFlag=false;
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
}else if(R.id.opemBBtn==id){
        Intent intent=new Intent(this,Main2Activity.class);
        startActivity(intent);

    }

}


    }
    //这是绑定服务的第二种方式 Mesenger
    public void clickBtn2(View view){
        int id=view.getId();
        if(R.id.msgBindBtn==id){
        Intent intent=new Intent(this,MyMessageService.class);
            bindService(intent,mConnetion2,BIND_AUTO_CREATE);



        }else if(R.id.sayHelloBtn==id) {
    //使用Message玩服务器端发送消息使得服务端开始运行
            if(!msgFlag) return;
            Message msg=Message.obtain();
            msg.what=0x101;
            try {
                mMessenger.send(msg);
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }else if(R.id.msgunBindBtn==id){
unbindService(mConnetion2);



        }

    }
    Messenger mMessenger;
    ServiceConnection mConnetion2=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mMessenger=new Messenger(service);
            msgFlag=true;
            //与服务通信
          }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


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
