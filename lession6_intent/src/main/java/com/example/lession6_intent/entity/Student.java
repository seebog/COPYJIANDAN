package com.example.lession6_intent.entity;

import java.io.Serializable;

/**
 * Created by ff on 2016/9/23.
 */
public class Student implements Serializable{

    private  String stuName;
    private  Integer stuAge;
    private  Double stuScore;


    public String getStuName() {
        return stuName;
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public Double getStuScore() {
        return stuScore;
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
}
