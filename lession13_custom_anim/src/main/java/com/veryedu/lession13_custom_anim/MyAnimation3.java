package com.veryedu.lession13_custom_anim;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

/**
 * Created by maggie on 15/9/28.
 */
public class MyAnimation3 extends Animation {

    int max_scale=1;
    float  scale=0;
    float  degree=0;
    int max_degree=720;
    Camera camera;



    PointF center=new PointF();
    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        Log.i("mytest", "width=" + width + " height=" + height + " pw=" + parentWidth + " ph=" + parentHeight);


        center.x=width/2.0f;
        center.y=height/2.0f;
        this.setDuration(2000);
        this.setInterpolator(new LinearInterpolator());
        this.setFillAfter(true);
        camera=new Camera();


    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
         Matrix  m=t.getMatrix();

        camera.save();

        camera.translate(0.0f, 0.0f, 13000 - 13000 * interpolatedTime);

        camera.rotateX(360 * interpolatedTime);
        camera.rotateY(360 * interpolatedTime);
        camera.rotateZ(360 *interpolatedTime);
        camera.getMatrix(m);


        m.preTranslate(-center.x,-center.y);
        m.postTranslate(center.x,center.y);

        camera.restore();

        super.applyTransformation(interpolatedTime, t);
    }
}
