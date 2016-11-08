package com.veryedu.lession13_custom_anim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img1=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1=(ImageView)findViewById(R.id.img1);
    }


    public void clickBtn(View view)
    {
          int id=view.getId();
          switch(id)
          {
              case R.id.btn1:
                  Animation anim1=new MyAnimation1();
                  img1.startAnimation(anim1);
                  break;
              case R.id.btn2:
                  Animation anim2=new MyAnimation2();
                  img1.startAnimation(anim2);
                  break;
              case R.id.btn3:
                  Animation anim3=new MyAnimation3();
                  img1.startAnimation(anim3);
                  break;

          }
    }
}
