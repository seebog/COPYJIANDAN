package com.example.lession13_matrix;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ff on 2016/10/17.
 */

public class MyImageView extends View {
    Bitmap pic=null;
    Matrix m=null;
    float[] value={1,0,0,
                    0,1,0,
                    0,0,1};
    public MyImageView(Context context) {
        super(context);
        pic= BitmapFactory.decodeResource(context.getResources(), R.drawable.aa);
        m=new Matrix();
        m.setValues(value);

    }

    public MyImageView(Context context, AttributeSet attrs) {

        super(context, attrs);
        pic= BitmapFactory.decodeResource(context.getResources(), R.drawable.aa);
        m=new Matrix();
        m.setValues(value);
//        m.setRotate(30);
//        m.preTranslate(-100,-85);
//        m.postTranslate(100,85);

//        m.postTranslate(-100,-85);
//        m.postRotate(30);
//        m.postTranslate(100,85);

        m.setRotate(30,100,85);


    }


//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//
//
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//    }




    //onDraw方法绘制自定义控件的样子
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
//        Bitmap pic=
//        paint.setAlpha();
//        paint.setColor();
//        paint.setStrokeWidth();
        paint.setAntiAlias(true);

        canvas.drawColor(Color.BLACK);
//       canvas.drawBitmap(pic,0,0,paint);
        canvas.drawBitmap(pic,m,paint);


//        canvas.drawLine();
//        canvas.drawText();

    }

public void changeMatrix(float[] value){
    m.setValues(value);
    //让当前绘制的内容失效,并自动调用onDraw方法重新绘制组件
    //异部提交
    postInvalidate();

    //同步的
    //invalidate();


}

}


