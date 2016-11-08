package com.example.lession4_listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lst1=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lst1=(ListView) findViewById(R.id.lst1);
        lst1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txt=(TextView)view;
                Toast.makeText(MainActivity.this, txt.getText()+"pos="+position+" id="+id, Toast.LENGTH_SHORT).show();
                //Intent意图  他在android的几个主要组建之间充当消息传递的作用
                //四大组件 1，Activity           2，后台服务service 3广播 BroadcastReciever
                //4内容提供者ContentProvider

                //Intent显示Intent 和隐式Intent

//                Intent itent=new Intent(MainActivity.this,ArrayAdapterActivity.class);
                if(position==0){
                Intent itent=new Intent(MainActivity.this,ArrayAdapterActivity.class);
                 startActivity(itent);
                }else if(position==1){
                    Intent itent=new Intent(MainActivity.this,SimpleAdapterActivity.class);
                    startActivity(itent);

                }else if (position==2){

                    Intent itent=new Intent(MainActivity.this,MyAdapterActivity.class);
                    startActivity(itent);

                }else if(position==3){

                }else if(position==4) {

                }


//                switch (position){
//                    case 0 :
//                        startActivity(itent);
//
//                        break;
//                    case 1 :
//                        break;
//                    case 2:
//                        break;
//
//                }

            }
        });
    }
}
