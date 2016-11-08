package com.veryedu.lession7_fragment3;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    RadioGroup  rg1=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg1=(RadioGroup)findViewById(R.id.rg1);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
              RadioButton  rb=(RadioButton) findViewById(checkedId);
                String value=rb.getText().toString();
                Fragment  frg=  getSupportFragmentManager().findFragmentById(R.id.infoFrg);
                TextView infoTxt=(TextView)frg.getView().findViewById(R.id.infoTxt);
                infoTxt.setText("您选择的是:"+value);
            }
        });
    }

}
