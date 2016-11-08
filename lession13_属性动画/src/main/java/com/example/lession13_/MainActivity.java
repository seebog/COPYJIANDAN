package com.example.lession13_;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ImageView img1=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1=(ImageView)findViewById(R.id.imageView);


    }

    public void popInfo(View view){
        Toast.makeText(this,"你点击了图片",Toast.LENGTH_LONG).show();


    }

    public  void clickBtn(View view){
//    img1.getTr


        if(view.getId()==R.id.btn1){
            //级联操作
//            ObjectAnimator animator=ObjectAnimator.ofFloat(img1,"translationX",0,300f);

//            animator.setInterpolator(new BounceInterpolator());
//            animator.setDuration(1000);
//            animator.start();



//           ObjectAnimator.ofFloat(img1,"translationX",0,300f).setDuration(1000).start();
//           ObjectAnimator.ofFloat(img1,"translationY",0,300f).setDuration(1000).start();
//           ObjectAnimator.ofFloat(img1,"rotation",0,720f).setDuration(1000).start();
//---------------------------------------------------------------------------------------
//            ViewPropertyAnimator anim1=img1.animate();
//
//            anim1.setDuration(1000);
//            anim1.translationX(300);
//
//            anim1.start();
//---------------------------------------------------------------------------
//            img1.animate().translationX(300).translationY(300).rotation(720).setDuration(1000).start();
//            ----------------------------------------------------------------------------------------------------
//            PropertyValuesHolder p1=PropertyValuesHolder.ofFloat("rotation",720);
//            PropertyValuesHolder p2=PropertyValuesHolder.ofFloat("translationX",300);
//            PropertyValuesHolder p3=PropertyValuesHolder.ofFloat("translationY",300);
//            ObjectAnimator anim=ObjectAnimator.ofPropertyValuesHolder(img1,p1,p2,p3);
//            anim.setDuration(1000);
//            anim.start();
//----------------------分开做动画集------------------------------------------
            ObjectAnimator anim1=ObjectAnimator.ofFloat(img1,"rotation",720);
            ObjectAnimator anim2=ObjectAnimator.ofFloat(img1,"translationX",300f);
            ObjectAnimator anim3=ObjectAnimator.ofFloat(img1,"translationY",300f);

            AnimatorSet set=new AnimatorSet();
            set.setDuration(1000);
//            set.playTogether(anim1,anim2,anim3 );
//            set.playSequentially(anim1,anim2,anim3);
            set.play(anim2).with(anim3);
            set.play(anim1).after(anim2);
//            set.cancel();动画取消
//            set.addListener(new Animator.AnimatorListener() {
//                @Override
//                public void onAnimationStart(Animator animation) {
//
//
//
//                }
//
//                @Override
//                public void onAnimationEnd(Animator animation) {
//                    Toast.makeText(MainActivity.this,"动画执行完毕",Toast.LENGTH_LONG).show();
//
//                }
//
//                @Override
//                public void onAnimationCancel(Animator animation) {
//
//                }
//
//                @Override
//                public void onAnimationRepeat(Animator animation) {
//
//                }
//            });
//----------------------------------------------------------------
            set.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    Toast.makeText(MainActivity.this,"动画执行完毕",Toast.LENGTH_LONG).show();
                }
            });


            set.start();


        }

    }

        public void clickBtn2(View view){
           AnimatorSet anim = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.set);
           anim.setTarget(img1);
           anim.start();



        }



}
