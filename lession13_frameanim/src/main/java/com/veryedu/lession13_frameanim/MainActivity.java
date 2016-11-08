package com.veryedu.lession13_frameanim;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img1=null;
    AnimationDrawable  anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1=(ImageView)findViewById(R.id.img1);
        anim=new AnimationDrawable();
        for(int i=0;i<8;i++)
        {
            Drawable  pic= this.getResources().getDrawable(R.drawable.walk1+i);
            anim.addFrame(pic,50);
        }

        anim.setOneShot(false);
        img1.setImageDrawable(anim);
//        anim=(AnimationDrawable)img1.getBackground();
//        anim.setOneShot(true);
    }


    public void  clickBtn(View view)
    {
        if(anim.isRunning())
        {
             anim.stop();
            ((Button)view).setText("开始");
        }else
        {
            anim.start();
            ((Button)view).setText("停止");
        }
    }


}
