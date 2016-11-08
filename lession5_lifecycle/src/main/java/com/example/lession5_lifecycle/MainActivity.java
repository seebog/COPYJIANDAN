package com.example.lession5_lifecycle;

import android.app.AliasActivity;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
//生命周期的七种方法

//    09-22 10:06:18.933 3373-3373/? I/test: 主窗口的onCreate方法被执行
//    09-22 10:06:19.017 3373-3373/? I/test: 主窗口的onStart方法被执行
//    09-22 10:06:19.018 3373-3373/? I/test: 主窗口的onResume方法被执行
//    09-22 10:09:45.408 3463-3463/? I/test: 主窗口的onCreate方法被执行
//    09-22 10:09:45.410 3463-3463/? I/test: 主窗口的onStart方法被执行
//    09-22 10:09:45.415 3463-3463/? I/test: 主窗口的onResume方法被执行
//    09-22 10:11:40.209 3463-3463/? I/test: 主窗口的onPause方法被执行
//    09-22 10:11:40.319 3463-3463/? I/test: 主窗口的onStop方法被执行
//                                                   onDestroy



//onCreate会在Activity一被创建时就会调用
    //在这个方法里一般完成UI的初始化

        EditText infoTxt;
        String info=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            infoTxt=(EditText) findViewById(R.id.infoTxt);
            Log.i("test","主窗口的onCreate方法被执行");
            Log.i("test","info"+info);
    }
    //onStart方法紧跟着onCreate执行。这个方法执行完毕
    //Activity就在屏幕上可见了

    @Override
    protected void onStart() {
        super.onStart();

        Log.i("test","主窗口的onStart方法被执行");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i("test","主窗口的onRestart方法被执行");
    }
//这个方法会紧跟着onStart方法执行
    //这个方法执行完毕，Activity就获得焦点，这时就处于一个运行状态了

    @Override
    protected void onResume() {
        super.onResume();
            //从文件中读取出来

        Log.i("test","主窗口的onResume方法被执行");
    }
//----------------------------------------------------------------



    @Override
    protected void onPause() {
        super.onPause();
        //可以写入文件中

        Log.i("test","主窗口的onPause方法被执行");
    }
    //onSaveInstaceState可以用来保存窗口的中间数据
    //本意上这两个方法是做APP的灾难备份和灾难 恢复的
    //比如有个app在后台执行，这时系统内存很低需要将其杀死，以便节省内存，
    //那么android有可能就会执行onSaveInstanceState做灾难备份
    //之后有可能在内存足够时会恢复这个App,那么就会调用onRestoreInstanceState


    //所以这两个方法的执行时间是不一定的。





    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("test","onSaveInstanceState被执行了");
    }
//这个方法用来恢复onSaveInstanceState中保存的数据
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("test","savedInstanceState被执行了");


    }

    @Override
    protected void onStop() {
        super.onStop();


        Log.i("test","主窗口的onStop方法被执行");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


        Log.i("test","主窗口的onDestroy方法被执行");
    }






public void clickBtn(View view){
    int id=view.getId();
    if(R.id.btn1==id){
        Intent intent=new Intent(this,SecondActivity.class);
        startActivity(intent);

    }else if(R.id.btn2==id){
        Intent intent=new Intent(this,ThirdActivity.class);
        startActivity(intent);



    }else if(R.id.btn3==id){

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("这是一个警告框");
        builder.setTitle("对话框");
        builder.show();

//        Intent intent=new Intent(this,)


    }else if(R.id.btn4==id){

        info=infoTxt.getText().toString();



    }


}

}
