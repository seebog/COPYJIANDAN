package com.example.ip_shengdianxiaozhushou;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

/**
 * Created by ff on 2016/9/29.
 */
public class SmsListererReceiver extends BroadcastReceiver{
//当短信到来时就执行这个方法
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("mytest","haha");
        //1获取发送短信的手机号
        //pdu一个短信
        Object[] objects=(Object[]) intent.getExtras().get("pdus");
        for(Object pdu:objects){
//            SmsManage smsManager=SmsManager.creater
          //获取smsmessage实例
            SmsMessage smsMessage=SmsMessage.createFromPdu((byte[]) pdu);
            //获取发送短信的内容

            String body=smsMessage.getMessageBody();
            //获取发送者
            String address=smsMessage.getOriginatingAddress();

            Log.i("mytest","body"+body+"address"+address);
            //比如发送

        }



    }
}
