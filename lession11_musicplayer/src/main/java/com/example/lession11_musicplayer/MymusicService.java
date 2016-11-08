package com.example.lession11_musicplayer;

//import android.app.Service;
//import android.content.Intent;
//import android.os.IBinder;
//import android.os.SystemClock;
//import android.support.annotation.Nullable;
//import android.util.Log;
//import android.widget.Toast;
//
///**
// * Created by ff on 2016/9/29.
// */
//public class MymusicService extends Service {
//    String currentMusic;
//    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
//
//    @Override
//    public void onCreate() {
//
//
//        super.onCreate();
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//    }
//
//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        int cmd=intent.getIntExtra("cmd",0);
//        switch (cmd){
//            case MainActivity.START:
//                   startPlay(intent);
//                    break;
//            case MainActivity.STOP:
//                stopPlay();
//                break;
//            case MainActivity.PAUSE:
//                break;
//            case MainActivity.NEXT:
//                nextMusic(intent);
//                break;
//
//        }
//
//        return super.onStartCommand(intent, flags, startId);
//    }
//
//
//    public void startPlay(Intent intent){
//        currentMusic = intent.getStringExtra("music_name");
//        Toast.makeText(this.getApplicationContext(),"开始播放"+currentMusic,Toast.LENGTH_LONG).show();
//        if(player==null){
//            player.start();
//        }
//
//    }
//
//public void nextMusic(Intent intent){
//    currentMusic = intent.getStringExtra("music_name");
//    Toast.makeText(this.getApplicationContext(),"播放下一首"+currentMusic,Toast.LENGTH_LONG).show();
//
//}
//
//    public void stopPlay(){
//        if(player!=null){
//            player.stopPlay();
//            player=null;
//        }
//Toast.makeText(this.getApplicationContext(),"停止播放"+currentMusic,Toast.LENGTH_LONG).show();
//    }
//    playThread player=null;
//    public class playThread extends Thread{
//       boolean isStop=false;
//   int count=0;
//        @Override
//        public void run() {
//
//            while(!isStop){
//                SystemClock.sleep(1000);
//               count++;
//               if(count%10==0){
//                 count=0;
//                   //每十秒换一首歌
//                   Intent intent=new Intent();
//                   intent.setAction("android.intent.action.CHANGE_MUSIC_BROADCAST");
//                    sendBroadcast(intent);
//
//               }
//                Log.i("mytest","正在播放"+currentMusic);
//            }
//
//
////            super.run();
//        }
//    //线程暂停
//        public void stopPlay(){
//            isStop=true;
//
//
//
//        }
//    }
//
//}


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by maggie on 15/8/26.
 */
public class MymusicService extends Service {

    String currentMusic;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        int cmd=intent.getIntExtra("cmd",0);
        switch (cmd)
        {
            case MainActivity.START:
                startPlay(intent);
                break;
            case MainActivity.STOP:
                stopPlay();
                break;
            case MainActivity.PAUSE:
                break;
            case MainActivity.NEXT:
                nextMusic(intent);
                break;
        }



        return super.onStartCommand(intent, flags, startId);
    }


    public void  startPlay(Intent intent)
    {
        currentMusic= intent.getStringExtra("music_name");
        Toast.makeText(this.getApplicationContext(),"开始播放:"+currentMusic,Toast.LENGTH_LONG).show();
        if(player==null)
        {
            player=new PlayThread();
            player.start();
        }


    }

    public  void   nextMusic(Intent intent)
    {
        currentMusic= intent.getStringExtra("music_name");
        Toast.makeText(this.getApplicationContext(),"播放下一首:"+currentMusic,Toast.LENGTH_LONG).show();

    }

    public void stopPlay()
    {
        if(player!=null)
        {
            player.stopPlay();
            player=null;
        }
        Toast.makeText(this.getApplicationContext(),"停止播放:"+currentMusic,Toast.LENGTH_LONG).show();
    }

    PlayThread player =null;

    public class  PlayThread  extends  Thread
    {
        boolean  isStop=false;
        int count=0;
        @Override
        public void run() {
            while(!isStop)
            {
                SystemClock.sleep(1000);
                count++;
                if(count%10==0)
                {
                    //每十秒钟换首歌
                    count=0;
                    Intent intent=new Intent();
                    intent.setAction("android.intent.action.CHANGE_MUSIC_BROADCAST");
                    sendBroadcast(intent);
                }
                Log.i("myteste","正在播放:"+currentMusic);
            }

        }

        public  void stopPlay()
        {
            isStop=true;
        }
    }

}



