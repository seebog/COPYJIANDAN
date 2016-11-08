package com.example.lession11_musicplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by ff on 2016/9/29.
 */
public class MyChageMusicBroadcastReciver extends BroadcastReceiver {
    private static  String CHANGE_MUSIC_BROADCAST="android.intent.action.CHANGE_MUSIC_BROADCAST";
    @Override
    public void onReceive(Context context, Intent intent) {
//        intent  =new Intent();
String action=intent.getAction();
        if(CHANGE_MUSIC_BROADCAST.equalsIgnoreCase(action)){

            Toast.makeText(context,"要换歌了",Toast.LENGTH_LONG).show();

        }


    }
}
