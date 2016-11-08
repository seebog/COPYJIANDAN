package com.example.lession11_intentservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    int counnt=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
public void clickBtn(View view){
    if(R.id.startBtn==view.getId()){
        Intent intent=new Intent(this,MyDownloadService.class);
        startService(intent);


    }else if(R.id.stoptBtn==view.getId()){
    Intent intent=new Intent(this,MyDownloadService.class);
        stopService(intent);

    }else if(R.id.starttBtn2==view.getId()){
        counnt++;

        Intent intent=new Intent(this,MyDownloadInternService.class);
        intent.putExtra("pic","pic"+counnt);
        startService(intent);

    }else if(R.id.stoptBtn2==view.getId()){
        Intent intent=new Intent(this,MyDownloadInternService.class);
        stopService(intent);

    }

}

}
