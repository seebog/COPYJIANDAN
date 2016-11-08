package com.example.ip_bohaoqi;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    edtxt=(EditText) findViewById(R.id.edit_Text);
    }
   public void clickBtn(View view){
      //1获取到用户输入的number
       String number= edtxt.getText().toString().trim();
       //2使用sp  保存起来

     SharedPreferences sp= getSharedPreferences("config",0);
        //3存数据
       sp.edit().putString("ipnumber",number).commit();
       Toast.makeText(getApplicationContext(),"保存成功",Toast.LENGTH_LONG).show();


   }

}
