package com.example.lession5_exitapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
    public void clickBtn(View view){
        if(view.getId()==R.id.openBtn){
        Intent intent=new Intent(this,ThirdActivity.class);
        startActivityForResult(intent,0x101);

        }else if(view.getId()==R.id.exitBtn){
//            System.exit(0);
            this.exitApp();
        }



    }


}
