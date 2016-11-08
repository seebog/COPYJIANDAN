package com.example.lession8_shared;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
EditText nameTxt;
    EditText ageTxt;
    ImageView img1;
    ImageView img2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameTxt=(EditText) findViewById(R.id.nameTxt);
        ageTxt=(EditText)findViewById(R.id.ageTxt);
        img1=(ImageView) findViewById(R.id.img1);
        img2=(ImageView) findViewById(R.id.img2);

    }
public void clickBtn(View view){
int id=view.getId();
if(R.id.btn1==id){
    String name=nameTxt.getText().toString();
    int age= Integer.parseInt(ageTxt.getText().toString());
    SharedPreferences sp= this.getSharedPreferences("info",Context.MODE_PRIVATE);
   SharedPreferences.Editor edit= sp.edit();



    BitmapDrawable bd=(BitmapDrawable)img1.getDrawable();
    Bitmap pic=bd.getBitmap();
    //把图片对象转换成String
    ByteArrayOutputStream bos=new ByteArrayOutputStream();
    //将图片压缩，压缩出来的数据使用输出流生成byte数组
    pic.compress(Bitmap.CompressFormat.JPEG,50,bos);
    //获得二进制数组
    byte[] data=bos.toByteArray();
        //吧二进制的数组组装成String使用base64解码
   String imgStr= Base64.encodeToString(data,Base64.DEFAULT);
    edit.putString("name",name);
    edit.putInt("age",age);
    edit.putString("img",imgStr);
    edit.commit();



    edit.putString("name",name);
    edit.putInt("age",age);
   edit.commit();

}else if(R.id.btn2==id){
SharedPreferences sp=this.getSharedPreferences("info",Context.MODE_PRIVATE);
    String name=sp.getString("name","无名氏");
    int age=sp.getInt("age",0);
    String imgstr=sp.getString("img","无名");
    byte[] imgData=Base64.decode(imgstr,Base64.DEFAULT);
    Bitmap pic= BitmapFactory.decodeByteArray(imgData,0,imgData.length);
    img2.setImageBitmap(pic);

    Toast.makeText(this,"读到的名字："+name+"age="+age+"img="+imgstr,Toast.LENGTH_LONG).show();
}
}


}
