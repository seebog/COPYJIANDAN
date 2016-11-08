package com.example.lession5_forresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PhoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
    }
public void clickOKBtn(View view){
   EditText phoneTxt=(EditText) findViewById(R.id.phoneTxt);
   String phone=phoneTxt.getText().toString();
    Intent intent=this.getIntent();
    //intent传入数据
    intent.putExtra("phone",phone);
   //将phone传到主界面当窗口关闭时可以通过这个方法把结果穿会给Activity
            //第一个参数是ResultCode结果编码
            //第二个参数是intent
    this.setResult(0x201,intent);
    this.finish();

}

}
