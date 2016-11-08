package com.veryedu.lession13_alphaanim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity {

    ImageView img1;
    Animation  anim=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        img1=(ImageView)findViewById(R.id.img1);
//        anim=new AlphaAnimation(0,1);
//        //添加差值器
//        anim.setInterpolator(new AccelerateInterpolator());
//        anim.setDuration(3000);
//        anim.setFillAfter(true);
//        anim.setAnimationListener(lst);
//        img1.startAnimation(anim);
    }

    Animation.AnimationListener lst=new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
                  Intent intent=new Intent(WelcomeActivity.this,MainActivity.class);
                  startActivity(intent);
                  finish();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };
    public void clickBtn(View view)
    {
        int id=view.getId();
        Animation anim=null;
        switch (id)
           {
               case R.id.btn1:
                    anim=AnimationUtils.loadAnimation(this, R.anim.alpha);
                   break;
               case R.id.btn2:
                   anim=AnimationUtils.loadAnimation(this, R.anim.translate);
                   break;
               case R.id.btn3:
                   anim=AnimationUtils.loadAnimation(this, R.anim.scale);
                   break;
               case R.id.btn4:
                   anim=AnimationUtils.loadAnimation(this, R.anim.rotate);
                   break;

               case R.id.btn5:
                   anim=AnimationUtils.loadAnimation(this, R.anim.set);

                   break;
           }
        img1.startAnimation(anim);

    }



}
