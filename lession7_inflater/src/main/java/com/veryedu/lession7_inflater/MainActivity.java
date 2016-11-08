package com.veryedu.lession7_inflater;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;


public class MainActivity extends Activity {

    LinearLayout layout1=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
        layout1=(LinearLayout)findViewById(R.id.layout1);
//        ViewParent   parent=layout1.getParent();
//        Log.i("test","parent="+parent);
           LayoutInflater  inflater=LayoutInflater.from(this);
        ViewGroup.LayoutParams   params=new ViewGroup.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //1.如果inflate方法的第二个参数root为空  ,那么你所加载的布局文件中
        //的layout_width和layout_height属性将失去作用，会自动创建一个LayoutParms参数使用
        //2. root不为空  第三个参数是true  那么解析出来的view对象会被root.addView方法
        //   加入到root中做为root的子节点,所以后面不要在使用addView了否则会报错
        //   而且由于view对象已经有了parent，所以其设置的layout_width属性会起作用
        //另外，这时inflate方法返回的是root对象而不是解析出来的view对象
        // View btn=inflater.inflate(R.layout.mytest,layout1);
        //View  btn=inflater.inflate(R.layout.mytest,layout1,true);
        //3.如果第三个参数是false，那么解析出来的view不会被放入root中，而且返回的就是view
         View  btn=inflater.inflate(R.layout.mytest,layout1,false);
         Log.i("test","btn="+btn);

          layout1.addView(btn);

    }
}
