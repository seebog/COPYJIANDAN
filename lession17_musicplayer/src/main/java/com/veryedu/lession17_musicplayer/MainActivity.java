package com.veryedu.lession17_musicplayer;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MediaPlayer  player;
    int pos=0;
    boolean pause=false;
    Button  pauseBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pauseBtn=(Button) findViewById(R.id.pauseBtn);
    }

    public void clickBtn(View view)
    {
           int id =  view.getId();
           switch ( id)
           {
               case  R.id.playBtn:
                       // playFromRawRes();
                       //playFromSDCard();
                         playFromAssets();
                        break;
               case  R.id.pauseBtn:
                        pausePlayer();
                        break;
               case  R.id.stopBtn:
                      stopPlayer();
                      break;


           }
    }

    public void playFromAssets()
    {
        try {
            AssetFileDescriptor afd = getAssets().openFd("test.mp3");
            player = new MediaPlayer();
            player.setDataSource(afd.getFileDescriptor());
            player.prepare();
            player.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void playFromRawRes()
    {
          player = MediaPlayer.create(this,R.raw.test);
          pos = 0;
          player.start();
    }
    public  void playFromSDCard()
    {
       String path = Environment.getExternalStorageDirectory()+"/test.mp3";
       // String path =Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC)+"/test.mp3";
        // String path ="/mnt/shell/emulated/0/Music/test.mp3";
        Log.i("mytest",path);
        player = new MediaPlayer();
        try {
            player.setDataSource(path);
            player.prepare();
            pos = 0;
            player.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopPlayer()
    {
           if(player!=null )
           {
               player.stop();
           }
    }

    public  void  pausePlayer()
    {
           if(!pause  &&  player !=null  && player.isPlaying())
           {
                 pos = player.getCurrentPosition();
                 player.pause();
                 pauseBtn.setText("继续");
                 pause=true;
           }else if(pause && player !=null && !player.isPlaying())
           {
               pauseBtn.setText("暂停");
               pause=false;
               player.seekTo(pos);
               player.start();
           }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(player!=null)
        {
              player.release();
              player = null;
        }
    }
}
