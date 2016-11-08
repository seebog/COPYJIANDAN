package com.veryedu.lession7_listfragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity  implements InputFragment.OnNewCityInputListener {

    ArrayAdapter<String>  adapter;
    Fragment inputFrg;
    CityListFragment cityListFrg;
    List cityList=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputFrg=this.getSupportFragmentManager().findFragmentById(R.id.inputFrg);
        cityListFrg=(CityListFragment)this.getSupportFragmentManager().findFragmentById(R.id.cityListFrg);
        init();
    }

    public void init()
    {
        cityList.add("长沙");
        cityList.add("北京");
        cityList.add("上海");
        cityList.add("广州");
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cityList);
        cityListFrg.setListAdapter(adapter);
    }


    @Override
    public void onNewCityInput(String city) {
          cityList.add(city);
        //当数据发生变动时  一定要调用这个方法 通知listview刷新
          adapter.notifyDataSetChanged();

    }
}
