package com.example.lession7_fragment2;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.lession7_fragment2.fragments.BottomFragment;
import com.example.lession7_fragment2.fragments.CenterFragment;

public class MainActivity extends FragmentActivity {

    Fragment centerFrg;
    Fragment bottomFrg;
    int count=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        centerFrg=new CenterFragment();
        bottomFrg=new BottomFragment();

////android app中的
//        FragmentManager fm= this.getFragmentManager();
//        extends FragmentActivity时候有这个方法
        FragmentManager fm=this.getSupportFragmentManager();
//           FragmentTransaction ft= fm.beginTransaction();
        fm.beginTransaction().add(R.id.centerLayout,centerFrg,"centerFrg").add(R.id.bottomLayout,bottomFrg,"bottomFrg").commit();

//        fm.beginTransaction().add(R.id.centerLayout,centerFrg,"centerFrg").add(R.id.bottomLayout,new BottomFragment(),"bottomFrg").commit();



    }

    public void clickBtn(View view){
        if(R.id.replaceBtn==view.getId()){
            Fragment fg=new CenterFragment();
            Bundle data=new Bundle();
            data.putInt("count",count);
//            fg.setArguments(data);
            fg.setArguments(data);
            this.getSupportFragmentManager().beginTransaction().replace(R.id.centerLayout,fg,"fg"+count).addToBackStack("").commit();
            count++;







        }else if(R.id.removeBtn==view.getId()) {
            //根据标签找到Fragment
        Fragment fg=this.getSupportFragmentManager().findFragmentByTag("fg3");
            this.getSupportFragmentManager().beginTransaction().remove(fg).commit();

//        this.getSupportFragmentManager().beginTransaction().remove(bottomFrg).commit();

        }

        }



}
