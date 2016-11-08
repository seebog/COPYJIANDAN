package com.example.lession7_fragment2.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lession7_fragment2.R;

import java.util.Random;

/**
 * Created by ff on 2016/9/23.
 */
public class CenterFragment extends Fragment {
int count;
     public CenterFragment(){

     }

//   传值需要另一个参数
//    public CenterFragment(int count){
//this.count=count;
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frg_center,container,false);
        Random random=new Random();
        int color= Color.rgb(random.nextInt(256),random.nextInt(256),random.nextInt(256));
        view.setBackgroundColor(color);
       if(this.getArguments()!=null){
           count=this.getArguments().getInt("count");
       }
//        count=this.getArguments().getInt("count");
        TextView  infoTxt=(TextView)view.findViewById(R.id.infoTxt);
        infoTxt.setText("这是中央区域的内容"+count);
        return view;
    }
}
