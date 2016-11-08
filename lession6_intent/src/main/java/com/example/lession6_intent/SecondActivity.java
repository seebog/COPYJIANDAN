package com.example.lession6_intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.lession6_intent.entity.StuInfo;
import com.example.lession6_intent.entity.Student;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
////        Bundle data = intent.getExtras();
////        if (data != null) {
////            String name = data.getString("name");
////            int age = data.getInt("age", 0);
////            double score = data.getDouble("score");
//
//            Student stu=(Student) intent.getSerializableExtra("stu");
//
//
//
//
//            Toast.makeText(this, "学生姓名" + stu.getStuName() + " 年龄" + stu.getStuAge() + " 分数" + stu.getStuScore(), Toast.LENGTH_LONG);
////        }
////  此为简写形式
////        String name=intent.getStringExtra("name");
////        int age=intent.getIntExtra("age",0);
////        double score=intent.getDoubleExtra("score",0);
////
            //获取数据实现了Parcelable接口数据-----
        StuInfo stu=intent.getParcelableExtra("stu1");
        Toast.makeText(this,"姓名"+stu.getStuName()+" 年龄"+stu.getStuAge()+"成绩"+stu.getStuScore(),Toast.LENGTH_LONG).show();


        }

    }