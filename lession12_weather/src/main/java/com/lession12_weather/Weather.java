package com.lession12_weather;

/**
 * Created by ff on 2016/10/15.
 */

public class Weather {
    public  String time;
    public String temp;
    public String icon;

    @Override
    public String toString() {
        return "Weather{" +
                "time='" + time + '\'' +
                ", temp='" + temp + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
