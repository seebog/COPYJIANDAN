package com.example.lession14_touch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
MyButton btn1=null;
    RelativeLayout layout1;
    LinearLayout layout2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=(MyButton)findViewById(R.id.btn1);
        layout1=(RelativeLayout)findViewById(R.id.layout1);
        layout2=(LinearLayout)findViewById(R.id.layout2);
        layout1.setOnTouchListener(lst2);
        layout2.setOnTouchListener(lst3);

        btn1.setOnTouchListener(lst);


    }

    View.OnTouchListener lst=new View.OnTouchListener(){
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            Log.i("mytest","Button中的onTouch的方法");

            return true;
        }
    };


    View.OnTouchListener lst2=new View.OnTouchListener(){

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int action=event.getAction();
            float x=event.getX();
            float y=event.getY();

            Log.i("mytest","layout1中的onTouch的方法"+event.getAction()+"x="+x+"y"+y);

            return false;
        }
    };

    View.OnTouchListener lst3=new View.OnTouchListener(){

        @Override

        public boolean onTouch(View v, MotionEvent event) {
            Log.i("mytest","layout2中的onTouch的方法");

            return false;
        }
    };

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("mytest","Activity中的onTouch的回调方法");

        return false;


    }
}
