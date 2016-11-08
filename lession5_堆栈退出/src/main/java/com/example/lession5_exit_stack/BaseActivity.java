package com.example.lession5_exit_stack;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

/**
 * Created by ff on 2016/9/22.
 */
public class BaseActivity extends Activity {
    //一被创建就被执行

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("test","父类的onCreat被执行");
        MyApplication application=(MyApplication) this.getApplication();

        application.addActivity(this);

    }


    /*

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
        Log.i("test","父类的onCreat被执行");
//        MyApplication application=(MyApplication) this.getApplication();
//
//        application.addActivity(this);

    }
 */

    //被销毁时就执行
    @Override
    protected void onDestroy() {
        super.onDestroy();
//        MyApplication application=(MyApplication) this.getApplication();
//        application.removeActivity(this);
    }
public void exitApp(){
    MyApplication application=(MyApplication) this.getApplication();
application.exit();



}

}
