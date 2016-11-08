package com.example.lession14_touch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Switch;

/**
 * Created by ff on 2016/10/27.
 */

public class MyButton  extends Button {
    public MyButton(Context context) {
        super(context,null);
    }

    public MyButton(Context context, AttributeSet attrs) {
//动态设置宽度和高度
        super(context, attrs);
    }
    //一次触摸事件是由一次按下事件 和 拾起事件 以及若 干移动事件 构成的动作序列
    //在一个对象上同时加了监听器和回调方法的话，监听器要优先于回掉方法
    //不管是onTouch方法还是onTouchEvent方法的返回值 都是用来控制事件的传播范围
    //返回值如果为false：则表示这个触摸事件的动作序列都由本方法处理，不再往下一级转交，终止事件的传播
//    ScrollView滚动面板

    //touch事件的回掉方法
    @Override
    public boolean onTouchEvent(MotionEvent event) {
    int action=event.getAction();
        String actionStr=null;
        switch (action){
            case MotionEvent.ACTION_DOWN:
                actionStr="action_down="+MotionEvent.ACTION_DOWN;
                break;
            case MotionEvent.ACTION_MOVE:
                actionStr="action_MOVE="+MotionEvent.ACTION_MOVE;
                break;
            case MotionEvent.ACTION_UP:
                actionStr="action_UP="+MotionEvent.ACTION_UP;
                break;
            case MotionEvent.ACTION_CANCEL:

            case MotionEvent.ACTION_OUTSIDE:
                actionStr="action_outside="+MotionEvent.ACTION_OUTSIDE;


        }
   Log.i("mytest","Button中的onTouch的回调方法");
        return true;

    }

    @Override
    //实际显示范围
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
