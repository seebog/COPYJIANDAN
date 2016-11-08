package com.example.lession5_exit_stack;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends BaseActivity {
    Button exitBtn=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


//        MyApplication application=(MyApplication) this.getApplication();
//        application.addActivity(this);




        exitBtn=(Button) findViewById(R.id.exitBtn);
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("test","aaaaaaaaaaa");
                ((MyApplication) getApplication()).printLst();


//                this.exitApp();

                    exitApp();

            }
        });

    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        MyApplication application=(MyApplication) this.getApplication();
//        application.removeActivity(this);
//    }

    /*

    public void clickBtn(View view){

    //exit并不会退出整个应用 而只是关闭当前的activity
//    System.exit(0);
//this.exitApp();
    Log.i("test","aaaaaaaaaaa");
    ((MyApplication) getApplication()).printLst();


    this.exitApp();
}
 */

}
