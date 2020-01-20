package com.example.wuruixuan.androidstudy.activity.classes;

import android.os.Parcel;
import android.os.Parcelable;

public class Dog implements Parcelable {
    public String name;
    public int age;
    public String type;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeString(type);
    }

    // 对象的创建器
    public static final Parcelable.Creator<Dog> CREATOR = new Parcelable.Creator<Dog>()
    {
        public Dog createFromParcel(Parcel in)
        {
            Dog dog = new Dog();
            dog.name = in.readString();
            dog.age = in.readInt();
            dog.type = in.readString();
            return dog;
        }

        public Dog[] newArray(int size)
        {
            return new Dog[size];
        }
    };
}
