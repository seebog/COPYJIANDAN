package com.example.lession5_exitapp;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by ff on 2016/9/22.
 * App中所有Activity都继承自BaseActivity
 */
public class BaseActivity extends Activity {
public static final int EXIT_CODE=0x9999;

public void exitApp(){

   Intent intent=this.getIntent();
    setResult(EXIT_CODE,intent);
    this.finish();

}


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    if(EXIT_CODE==resultCode){
    exitApp();

    }

    }
}
