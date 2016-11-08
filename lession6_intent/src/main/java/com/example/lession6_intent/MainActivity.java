package com.example.lession6_intent;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.lession6_intent.entity.StuInfo;
import com.example.lession6_intent.entity.Student;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void clickBtn(View view){
        int id=view.getId();
        if(R.id.btn1==id){


            //显示启动的Intent实际就是指明了Intent中ComponentName组件名称这个部分的内容

            //Intent intent=new Intent(this,SecondActivity.class);//这是一种简写
            Intent intent=new Intent();
            ComponentName cn=new ComponentName(this,SecondActivity.class);
            intent.setComponent(cn);
            startActivity(intent);

        }else if(R.id.btn2==id){
            //隐式Intent一般需要指明Intent的Action以及Date和Categraye这几个部分
            Intent intent=new Intent();
            //Action用来表示你想要执行的操作，他是一个（String）字符串的数据，就是操作名称
            //这个擦作名称你可以自己来取也可以使用Anadroid系统约定好的操作名

            intent.setAction(Intent.ACTION_VIEW);
            //接下来要指明操作需要的数据DATA 这个数据必须是URI格式
            intent.setData(Uri.parse("http://www.sina.com"));
            //隐式Intent 意味着最终启动的复合条件的Intent 你是不确定的，
                //也有可能你启动的intent不属于你的APP

            startActivity(intent);

        }else if(R.id.btn3==id){
            Intent intent=new Intent();
//            intent.setAction(Intent.ACTION_DIAL);

            intent.setAction(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:123456"));
            startActivity(intent);
        }else if(R.id.btn4==id){
            Intent intent=new Intent();
            intent.setAction("android.intent.action.MY_TEST_ACTION");
            startActivity(intent);


        }else if(R.id.btn5==id){
            Intent intent=new Intent();
            intent.setAction("android.intent.action.MY_TEST_ACTION");

//
//            Bundle extra=new Bundle();
//            extra.putString("name","tom");
//            extra.putInt("age",28);
//            extra.putDouble("score",78.5);
//            intent.putExtras(extra);


//  此为简写
//            intent.putExtra("name","tom");
//            intent.putExtra("age",28);
//            intent.putExtra("score",78.5);
//            intent.putExtra()
//            intent.putExtra()
    //传递对象数据
            Student stu=new Student();
            stu.setStuName("jack");
            stu.setStuAge(18);
            stu.setStuScore(82.5);
            intent.putExtra("stu",stu);



            startActivity(intent);


        }else if(R.id.btn6==id){
            Intent intent=new Intent();
            intent.setAction("android.intent.action.MY_TEST_ACTION");


            StuInfo stu=new StuInfo();
            stu.setStuName("Rose");
            stu.setStuAge(13);
            stu.setStuScore(29.0);


            intent.putExtra("stu1",stu);


            startActivity(intent);

        }

    }

}
