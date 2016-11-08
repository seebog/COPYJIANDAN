package com.example.lession13_;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ListView lv1=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv1=(ListView)findViewById(R.id.lv1);


        List<String> list=new ArrayList<>();
        for(int i=0;i<20;i++){
            list.add("line"+i);

        }

        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1);
        lv1.setAdapter(adapter);

    }
public void clickBtn (View view){


    Animation anim= AnimationUtils.loadAnimation(this,R.anim.alpha);
    LayoutAnimationController ctr=new LayoutAnimationController(anim);
    ctr.setOrder(LayoutAnimationController.ORDER_NORMAL);
    ctr.setDelay(0.5f);
    lv1.setLayoutAnimation(ctr);
    lv1.startLayoutAnimation();


}

}
