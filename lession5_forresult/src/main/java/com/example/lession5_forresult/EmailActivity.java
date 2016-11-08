package com.example.lession5_forresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);



    }

    public void clickOKBtn(View view){
        EditText emailTxt=(EditText) findViewById(R.id.emailTxt);
        String email=emailTxt.getText().toString();
        Intent intent=this.getIntent();
        //intent传入数据
        intent.putExtra("email",email);
        //将phone传到主界面当窗口关闭时可以通过这个方法把结果穿会给Activity
        //第一个参数是ResultCode结果编码
        //第二个参数是intent
        this.setResult(0x202,intent);
        this.finish();

    }

}


