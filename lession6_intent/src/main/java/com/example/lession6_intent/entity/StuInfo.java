package com.example.lession6_intent.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ff on 2016/9/23.
 */
public class StuInfo implements Parcelable{

    private  String stuName;
    private  Integer stuAge;
    private  Double stuScore;
    public StuInfo(){

    }
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    public void setStuScore(Double stuScore) {
        this.stuScore = stuScore;
    }

    public String getStuName() {
        return stuName;
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public Double getStuScore() {
        return stuScore;
    }

    @Override
    public int describeContents() {
        return 0;
    }


//这个方法用来序列化对象   也就是把对像的属性值依次保存

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(stuName);
        dest.writeInt(stuAge);
        dest.writeDouble(stuScore);



    }
public static final Parcelable.Creator<StuInfo> CREATOR=new Parcelable.Creator<StuInfo>(){


    @Override
    public StuInfo createFromParcel(Parcel source) {

        return new StuInfo(source);


    }

    @Override
    public StuInfo[] newArray(int size) {


        return new StuInfo[size];


    }
};
        public StuInfo(Parcel source){
        stuName=source.readString();
        stuAge=source.readInt();
        stuScore=source.readDouble();


        }


}
