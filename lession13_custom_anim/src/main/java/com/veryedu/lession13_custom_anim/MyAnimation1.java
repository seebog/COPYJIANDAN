package com.veryedu.lession13_custom_anim;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

/**
 * Created by maggie on 15/9/28.
 */
public class MyAnimation1  extends Animation {

    int max_scale=1;
    float  scale=0;
    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);

        this.setFillAfter(true);
        this.setDuration(2000);
        this.setInterpolator(new LinearInterpolator());
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
         Matrix  m=t.getMatrix();
        scale=interpolatedTime*max_scale;
        m.postScale(scale,scale);
        super.applyTransformation(interpolatedTime, t);
    }
}
