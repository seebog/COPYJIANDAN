package com.example.lession14_;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
RelativeLayout layout1=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout1=(RelativeLayout)findViewById(R.id.activity_main);
        layout1.setOnTouchListener(lst);
    }

    View.OnTouchListener lst= new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int action=event.getAction();
           //再多点触摸时，Action一个复合码
            //比如第2个手指按下，得到复合码261（十进制）-->0x01 05 01这个字节是做出按下操作的手指的指针索引（pointerIndex）
            //                          ....05.....01                            而05是对点状态下的动作编码
                                                 //                               06表示抬起
            //                                                        01 06
            //移动时间在单点触摸和多点触摸时都是2
            //指针索引是给在屏幕上的手指从0开始挨个编号。每个手指的指针索引是会变化的。
            int count=event.getPointerCount();
            for(int ponitERIndex=0;ponitERIndex<count;ponitERIndex++){

             //根据指针索引获取指针ID,每个手指的指针ID是不变的
              int pointerID=event.getPointerId(ponitERIndex);
               float x= event.getX(ponitERIndex);
                float y=event.getY(ponitERIndex);
                Log.i("mytest","pointerIndex="+ponitERIndex+"pointerID="+pointerID+"x"+x+"y"+y);

            }
//            event.getPointerCount();
//        int index=action>>8;
            int index=action>>MotionEvent.ACTION_POINTER_INDEX_SHIFT;
//            int actionCode=action & 0xff-5;
            int actionCode=action & MotionEvent.ACTION_MASK;

            Log.i("mytest","action="+action+"--------------"+"index"+index+"actionCode"+actionCode);

            return true;
        }
    };


}
//http://apis.map.qq.com/tools/poimarker?type=1&key=O&keyword=酒店&center=39.908491,116.374328&radius=key&referer=shiyanpin