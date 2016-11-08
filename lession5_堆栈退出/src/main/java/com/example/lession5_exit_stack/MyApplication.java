package com.example.lession5_exit_stack;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ff on 2016/9/22.
 */
//Applocation常用来在APP中保存全局数据
    //需要在Manifest.XML中配置
    //Application的创建有Android系统在App启动第一时间加载
    //所以有时也会在application中做一些初始化操作
public class MyApplication extends Application {
        //LinkedList访问慢，但是删除快
    List<Activity> applist=new LinkedList<>();



    @Override
    public void onCreate() {
        super.onCreate();
    }
public void addActivity(Activity a){
Log.i("test","add activity");
    applist.add(a);

}
public void removeActivity(Activity a){
    Log.i("remove","remove activity");
    applist.remove(a);


}

    public void printLst(){
        Log.i("test","list size"+applist.size());

        for(int i=0;i<applist.size();i++){
            Log.i("test",""+applist.get(i));



        }



    }


public void exit(){

   Iterator<Activity> it= applist.iterator();
    while(it.hasNext()){

        it.next().finish();

    }

}



}
