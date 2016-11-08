package com.veryedu.lession7_viewpager;

import java.util.Locale;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MainActivity extends FragmentActivity {

    ViewPager welcomeVp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcomeVp=(ViewPager)findViewById(R.id.welcomeVp);
        MyPageAdapter  adapter=new MyPageAdapter(this.getSupportFragmentManager());

        //设置适配器
        welcomeVp.setAdapter(adapter);
        welcomeVp.setOffscreenPageLimit(3);
        welcomeVp.setCurrentItem(Integer.MAX_VALUE/2);

    }

    public class   MyPageAdapter  extends   FragmentPagerAdapter
    {
        public MyPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return MyPagerFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }
    }


}
