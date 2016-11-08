package com.example.lession13_;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView img=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=(ImageView)findViewById(R.id.imageView1);

    }
    public void popInfo(View view){
        Toast.makeText(this,"你点击了图片",Toast.LENGTH_LONG).show();


    }
    public void clickBtn(View view){
        Animation anim=new TranslateAnimation(0,300,0,0);
        anim.setDuration(2000);
        img.startAnimation(anim);


    }

}
