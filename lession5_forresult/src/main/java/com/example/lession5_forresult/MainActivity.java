package com.example.lession5_forresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView infotxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    infotxt=(TextView)findViewById(R.id.infotxt);

    }
        public void clickBtn(View view){
        if(R.id.btn1==view.getId()){
        //有一个任务栈——新的activity会把旧的挤入栈底
            Intent intent=new Intent(this,PhoneActivity.class);
//            startActivity(intent);


                //第二个参数是requestCode请求编码
            startActivityForResult(intent,0x101);

        }else{

            Intent intent=new Intent(this,EmailActivity.class);
//            startActivity(intent);
            startActivityForResult(intent,0x102);


        }



        }


    //这个回调方法，会在被调用的Activity关闭并返回到本activity时自动调用
         @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //由于所有的回调都会返回到onActivityResult方法中，所以为了区分不同返回数据，就可以使用
        //requestCode和resultCode共同判断intent的来源
             if(0x101==requestCode && 0x201==resultCode){
            String phone=data.getStringExtra("phone");
              infotxt.setText("您输入的电话是："+phone);




             }else if(0x102==requestCode && 0x202==resultCode){

                String email= data.getStringExtra("email");
             infotxt.setText("您输入的email是："+email);

             }

    }
}
