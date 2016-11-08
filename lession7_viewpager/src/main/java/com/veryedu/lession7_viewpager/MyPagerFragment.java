package com.veryedu.lession7_viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by maggie on 15/8/14.
 */
public class MyPagerFragment extends Fragment{

    ImageView  img1;
    int index;

    public  static  MyPagerFragment  newInstance(int index)
    {
        MyPagerFragment  fragment=new MyPagerFragment();
        Bundle data=new Bundle();
        data.putInt("index", index);
        fragment.setArguments(data);

        return  fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         index=getArguments().getInt("index");
        Log.i("test","index="+index+" onCreate执行");


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pager,container,false);
        img1=(ImageView)view.findViewById(R.id.img1);
        int resId=R.drawable.app_start_bg+index%3;
        img1.setImageResource(resId);
        Log.i("test", "index=" + index + " onCreateView执行");
        return view;
    }


    @Override
    public void onPause() {
        super.onPause();

        Log.i("test", "index=" + index + " onPause执行");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("test", "index=" + index + " onStop执行");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("test", "index=" + index + " onDestroyView执行");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("test", "index=" + index + " onDestroy执行");
    }
}
