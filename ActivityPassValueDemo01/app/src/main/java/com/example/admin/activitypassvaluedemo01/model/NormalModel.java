package com.example.admin.activitypassvaluedemo01.model;

/**
 * author:Created by LiangSJ
 * date: 2017/7/14.
 * description:？
 */

public class NormalModel {
    private String name;
    private int age;

    public NormalModel(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
