package com.example.lession6_intent;

import android.content.Intent;
import android.content.UriMatcher;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MyPhoneActivity extends AppCompatActivity {
TextView infoTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_phone);
    infoTxt=(TextView)findViewById(R.id.infoTxt);
        Intent intent=getIntent();
//       String phone=
        String phone=intent.getData().toString();
        infoTxt.setText("您的电话是"+phone);


    }
}
