package com.veryedu.lession7_fragment1.fragments;

import  com.veryedu.lession7_fragment1.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by maggie on 15/8/12.
 */
public class CenterFragment  extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

             View view=inflater.inflate(R.layout.frg_center,container,false);
        Log.i("test","container="+container+"  view="+view);
        return view;
    }
}
