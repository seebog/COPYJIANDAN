package com.example.lession4_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ArrayAdapterActivity extends AppCompatActivity {

    String[] cityArray;
    ListView arryLst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter);
        loadArrat();
        arryLst=(ListView) findViewById(R.id.arrayLst);
//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,cityArray);/单选框
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,cityArray);
        // ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cityArray);
        //设置成单选模式

//        arryLst.setChoiceMode(ListView.CHOICE_MODE_SINGLE);//单选
        arryLst.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);  //多选
        //
        arryLst.setAdapter(adapter);
//        arryLst.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });//被选中目标
    }
    public void loadArrat(){

        cityArray=new String[5];
        cityArray[0]="长沙";
        cityArray[1]="岳阳";
        cityArray[2]="湘潭";
        cityArray[3]="株洲";
        cityArray[4]="邵阳";


    }

}
