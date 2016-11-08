package com.example.lession_11;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by ff on 2016/10/6.
 */
public class BootReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
//开机打开mainActivity
        Intent intent1=new Intent(context,MainActivity.class);
        //如果在广播里面 开启Acrivity要设置一个任务栈设置
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);


    }
}
