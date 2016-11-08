package com.veryedu.lession7_fragment3;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class Frg_info extends Fragment {

    public Frg_info() {
        // Required empty public constructor
    }

    Button  btn1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View  view=inflater.inflate(R.layout.fragment_info, container, false);
        btn1=(Button)view.findViewById(R.id.btn1);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rg1 = (RadioGroup) getActivity().findViewById(R.id.rg1);
                int checkedId = rg1.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) (getActivity().findViewById(checkedId));
                String value = rb.getText().toString();
                Toast.makeText(getActivity(), "您选择的是:" + value, Toast.LENGTH_LONG).show();
            }
        });

    }
}
