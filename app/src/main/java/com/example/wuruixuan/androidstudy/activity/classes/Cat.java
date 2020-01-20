package com.example.wuruixuan.androidstudy.activity.classes;

import java.io.Serializable;

public class Cat implements Serializable {
    public String name;
    public int age;
    public String type;

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", type='" + type + '\'' +
                '}';
    }
}
