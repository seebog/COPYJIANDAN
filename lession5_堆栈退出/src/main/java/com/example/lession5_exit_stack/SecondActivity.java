package com.example.lession5_exit_stack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



//        MyApplication application=(MyApplication) this.getApplication();
//        application.addActivity(this);



    }



//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        MyApplication application=(MyApplication) this.getApplication();
//        application.removeActivity(this);
//    }





    public void clickBtn(View view){
        if(view.getId()==R.id.openBtn){
        Intent intent=new Intent(this,ThirdActivity.class);
        startActivityForResult(intent,0x101);

        }else if(view.getId()==R.id.exitBtn){
//            System.exit(0);
//            this.exitApp();
this.exitApp();


        }



    }


}
