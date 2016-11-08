package com.example.lession5_exit_stack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        MyApplication application=(MyApplication) this.getApplication();
//        application.addActivity(this);



        setContentView(R.layout.activity_main);
    }







//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        MyApplication application=(MyApplication) this.getApplication();
//        application.removeActivity(this);
//    }





public void clickBtn(View view){
    Intent intent=new Intent(this,SecondActivity.class);
    startActivity(intent);

}


}
