package com.example.admin.activitypassvaluedemo01.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * author:Created by LiangSJ
 * date: 2017/7/14.
 * description:
 *
 */

public class ParcelableModel implements Parcelable {
    private String name;
    private int age;

    protected ParcelableModel(Parcel in) {
        name = in.readString();
        age = in.readInt();
    }

    public ParcelableModel(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static final Creator<ParcelableModel> CREATOR = new Creator<ParcelableModel>() {
        @Override
        public ParcelableModel createFromParcel(Parcel in) {
            return new ParcelableModel(in);
        }

        @Override
        public ParcelableModel[] newArray(int size) {
            return new ParcelableModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
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
