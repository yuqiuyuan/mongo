package com.drebander.mongo.pojo;

import com.drebander.mongo.annotation.Column;

public class Student {

    @Column(name = "sname")
    private String sname;
    @Column(name = "sex")
    private String sex;
    @Column(name = "age")
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "sname='" + sname + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
