package com.example.lession5_lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.i("test","第二个窗口的onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("test","第二个窗口的onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("test","第二个窗口的onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i("test","第二个窗口的onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("test","第二个窗口的onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i("test","第二个窗口的onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("test","第二个窗口的onDestroy");
    }




}
