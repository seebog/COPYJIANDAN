package com.example.lession13_matrix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
        MyImageView myview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myview=(MyImageView)findViewById(R.id.myimg);


    }

public void clickBtn(View view){
    float[] v=new float[9];
    for(int i=0;i<9;i++){
        EditText txt=(EditText) findViewById(R.id.txt11+i);
        v[i]=Float.parseFloat(txt.getText().toString());


    }
    myview.changeMatrix(v);

}




}
