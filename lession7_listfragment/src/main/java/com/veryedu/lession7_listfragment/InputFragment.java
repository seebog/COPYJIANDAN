package com.veryedu.lession7_listfragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by maggie on 15/8/13.
 */
public class InputFragment extends Fragment {

    EditText  inputTxt=null;

    public interface   OnNewCityInputListener{
          public  void  onNewCityInput(String city);
    }


    OnNewCityInputListener  cityLst;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        cityLst=(OnNewCityInputListener)activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.frg_input,container,false);
        inputTxt=(EditText)view.findViewById(R.id.cityInputTxt);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        inputTxt.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction()==KeyEvent.ACTION_DOWN &&
                        keyCode==KeyEvent.KEYCODE_ENTER
                        )
                {
                  String city=  inputTxt.getText().toString();
                    //激发事件  使得事件监听器的对应处理方法执行
                    //这里的事件监听器就是activity，所city的值就被传给了activity
                    cityLst.onNewCityInput(city);
                    inputTxt.setText("");
                    Toast.makeText(getActivity(),city,Toast.LENGTH_LONG).show();
                }

                //如果为true这一次的按键事件就不会再传播了。
                return false;
            }
        });
    }
}
