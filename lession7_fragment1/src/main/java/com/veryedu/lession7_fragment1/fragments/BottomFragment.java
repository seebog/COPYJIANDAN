package com.veryedu.lession7_fragment1.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.veryedu.lession7_fragment1.R;

/**
 * Created by maggie on 15/8/12.
 */
public class BottomFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

             View view=inflater.inflate(R.layout.frg_bottom,container);
        return view;
    }
}
