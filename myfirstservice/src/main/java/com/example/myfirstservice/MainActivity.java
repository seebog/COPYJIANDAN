package com.example.myfirstservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("mytest","当前线程的名字"+Thread.currentThread().getName());
    }
    public void clickBtn1(View view){
     btn1=(Button) view.findViewById(R.id.btn1);
        Intent intent=new Intent(this,FirstService.class);
//        开启服务
        startService(intent);
        Toast.makeText(getApplicationContext(),"int",Toast.LENGTH_LONG).show();





    }
    public void clickBtn2(View view){
        btn2=(Button) view.findViewById(R.id.btn2);
            Intent intent=new Intent(this,FirstService.class);
        stopService(intent);


    }



}
