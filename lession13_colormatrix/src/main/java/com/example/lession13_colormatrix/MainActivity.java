package com.example.lession13_colormatrix;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
        ImageView img1=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1=(ImageView)findViewById(R.id.img1);
    }

    public void clickBtn(View view){
        float[] value=new float[20];
        for(int i=0;i<20;i++){
            EditText txt=(EditText)findViewById(R.id.txt11+i);
            value[i]=Float.parseFloat(txt.getText().toString());


        }
//构成颜色矩阵
        ColorMatrix matrix=new ColorMatrix(value);
//颜色过滤器
        ColorMatrixColorFilter filter =new ColorMatrixColorFilter(matrix);
        img1.setColorFilter(filter);


    }

}
