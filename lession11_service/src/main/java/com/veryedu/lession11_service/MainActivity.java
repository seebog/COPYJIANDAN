package com.veryedu.lession11_service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void clickBtn(View view)
    {
          if(R.id.startBtn==view.getId())
          {
              Intent intent=new Intent();
              intent.setAction("android.intent.action.MY_SERVICE");
              intent.setPackage(this.getPackageName());
              intent.putExtra("name","tom");
              startService(intent);
          }else if (R.id.endBtn==view.getId())
          {
              Intent intent=new Intent();
              intent.setPackage(this.getPackageName());
              intent.setAction("android.intent.action.MY_SERVICE");
              stopService(intent);
          }
    }
}
