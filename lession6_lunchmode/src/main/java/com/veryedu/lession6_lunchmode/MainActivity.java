package com.veryedu.lession6_lunchmode;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private static  int  count=0;
    TextView infoTxt=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count++;
        int taskId=this.getTaskId();
        infoTxt=(TextView)findViewById(R.id.infoTxt);
        infoTxt.setText("这是第一个窗口"+count+"  taskId="+taskId);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        count--;
    }

    //A --A --A -- B --B -- A

    public void clickBtn(View view)
    {
        if(view.getId()==R.id.btn1)
        {

            Intent intent=new Intent(this,MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }else if(view.getId()==R.id.btn2)
        {
            Intent intent=new Intent(this,SecondActivity.class);
            startActivity(intent);
        }
    }

}
