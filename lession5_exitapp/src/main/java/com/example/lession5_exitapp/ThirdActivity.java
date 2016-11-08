package com.example.lession5_exitapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ThirdActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }
public void clickBtn(View view){

    //exit并不会退出整个应用 而只是关闭当前的activity
//    System.exit(0);
this.exitApp();
}

}
