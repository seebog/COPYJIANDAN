package com.example.lession4_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SimpleAdapterActivity extends AppCompatActivity {
ListView simpleLst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);
        simpleLst=(ListView) findViewById(R.id.simpleLst);
        List data=loadData();
        String[] from={"gamename","gamesize","gameicon"};
        int[] to={R.id.gameTxt,R.id.sizeTxt,R.id.gameIcon};
        //第一个参数 上下文
        //第二个参数 是数据集合list 这个list中每一个单元室列表框要显示的数据
              //由于每一行的数据可以有多个部分组成，所以list中用map来存放数据并使用
              //map的key值将每一部分的数据区分 参见loadData方法
        //第三个参数  是行布局文件的资源ID，这个行布局文件用于在ListView中显示每一行的数据
        //第4个和第5个参数 分别指明每一行数据的各个部分与行布局文件中的各个空间的对应关系
//SimpleAdapter只能显示并不能互动


        SimpleAdapter  adapter=new SimpleAdapter(this,data,R.layout.line_item,from,to);
        simpleLst.setAdapter(adapter);
    }
    public List<Map<String,String>> loadData(){
    List data=new ArrayList();
       for(int i=0;i<30;i++){
           Map<String,Object> item=new HashMap<>();
           item.put("gamename","奋斗的小鸟"+i);
           item.put("gamesize",(2+i)+"M");
           item.put("gameicon",R.drawable.bird+(i%10));
           data.add(item);




       }


        return data;


    }
}
