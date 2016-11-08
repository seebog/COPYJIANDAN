package com.example.lession11_musicplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String  SERVICE_CODE="android.intent.action.MUSIC_SERVICE";
    public static final String  CHANGE_MUSIC_BROADCAST="android.intent.action.CHANGE_MUSIC_BROADCAST";

    public static  final int START=1;
    public static  final int STOP=2;
    public static  final int PAUSE=3;
    public static  final int NEXT=4;

    public  String[]  musics={"music1","music2","music3","music4","music5"};
    public  int index=0;

    ChangeMusicBroadcastReceiver receiver=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注册接收换歌的广播接收器
        receiver=new ChangeMusicBroadcastReceiver();
        IntentFilter filter=new IntentFilter();
        filter.addAction(CHANGE_MUSIC_BROADCAST);
        registerReceiver(receiver,filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除注册
        if(receiver!=null)
            unregisterReceiver(receiver);
    }

    @Override
    protected void onResume() {
        //恢复之前播放的歌曲
        SharedPreferences   sp=getPreferences(Context.MODE_PRIVATE);
        index= sp.getInt("currentMusic",0);
        super.onResume();
    }

    @Override
    protected void onPause() {
        //保存当前播放的歌曲
        SharedPreferences   sp=getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor  edit=sp.edit();
        edit.putInt("currentMusic",index);
        edit.commit();
        super.onPause();
    }

    public void clickBtn(View view)
    {
        int id=view.getId();
        switch (id)
        {
            case  R.id.startBtn:
                startPlay();
                break;
            case  R.id.stopBtn:
                stopPlay();
                break;
            case  R.id.pauseBtn:
                break;
            case  R.id.nextBtn:
                nextMusic();
                break;
            default:
        }

    }

    public void startPlay()
    {
        Intent intent=new Intent();
        intent.setAction(SERVICE_CODE);
        intent.putExtra("cmd", START);
        intent.putExtra("music_name",musics[index]);
        startService(intent);
    }
    public void stopPlay()
    {
        Intent intent=new Intent();
        intent.setAction(SERVICE_CODE);
        intent.putExtra("cmd",STOP);
        startService(intent);

    }

    public void pausePlay()
    {

    }

    public void nextMusic()
    {
        index++;
        index=index>=5?0:index;
        Intent intent=new Intent();
        intent.setAction(SERVICE_CODE);
        intent.putExtra("cmd", NEXT);
        intent.putExtra("music_name",musics[index]);
        startService(intent);
    }


    public  class ChangeMusicBroadcastReceiver extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action=intent.getAction();
            if(CHANGE_MUSIC_BROADCAST.equalsIgnoreCase(action))
            {

                Toast.makeText(context,"Activity要换歌了", Toast.LENGTH_LONG).show();
                nextMusic();
            }
        }
    }

}