package com.veryedu.lession13_custom_anim;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

/**
 * Created by maggie on 15/9/28.
 */
public class MyAnimation2 extends Animation {

    int max_scale=1;
    float  scale=0;
    float  degree=0;
    int max_degree=720;

    PointF center=new PointF();
    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        Log.i("mytest","width="+width+" height="+height+" pw="+parentWidth+" ph="+parentHeight);
        center.x=width/2.0f;
        center.y=height/2.0f;
        this.setFillAfter(true);
        this.setDuration(2000);
        this.setInterpolator(new LinearInterpolator());
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
         Matrix  m=t.getMatrix();
        scale=interpolatedTime*max_scale;
        degree=interpolatedTime*max_degree;

     //   m.preTranslate(-center.x, -center.y);
        m.postScale(scale, scale,center.x,center.y);
        m.postRotate(degree,center.x,center.y);
      //  m.postTranslate(center.x, center.y);
        super.applyTransformation(interpolatedTime, t);
    }
}
