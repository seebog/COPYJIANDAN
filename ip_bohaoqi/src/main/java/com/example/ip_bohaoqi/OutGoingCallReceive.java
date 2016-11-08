package com.example.ip_bohaoqi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
//import android.widget.Toast;

/**
 * Created by ff on 2016/9/28.
 */
//定义一个广播接收
public class OutGoingCallReceive extends BroadcastReceiver{
    //当接收到外拨电话的事件被调用的时候执行OnRecive方法

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("mytest","onRecieve");
    //事件的触发
//获取到保存的ip号码
      SharedPreferences sp= context.getSharedPreferences("config",0);
        //【1】获取我们保存的号码
        String ipnumber=sp.getString("ipnumber","");

        //1获取的当前拨打的电话号码
        String currentNumber=getResultData();
        Log.i("mytest","currentNumver");
//        Toast.makeText(context,currentNumber,Toast.LENGTH_LONG);
if(currentNumber.startsWith("0")) {
//在当前的号码前加上17951
    setResultData(ipnumber + currentNumber);

}

    }


}
