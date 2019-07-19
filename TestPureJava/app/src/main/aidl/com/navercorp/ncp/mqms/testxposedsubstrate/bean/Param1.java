package com.navercorp.ncp.mqms.testxposedsubstrate.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * author : yuliang
 * mail : yuliang@navercorp.com
 * date : 2019/1/10
 * description :
 */
public class Param1 implements Parcelable {
    String value1;
    Integer value2;
    ArrayList<String> value3;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.value1);
        dest.writeValue(this.value2);
        dest.writeStringList(this.value3);
    }

    public Param1() {
    }

    protected Param1(Parcel in) {
        this.value1 = in.readString();
        this.value2 = (Integer) in.readValue(Integer.class.getClassLoader());
        this.value3 = in.createStringArrayList();
    }

    public static final Parcelable.Creator<Param1> CREATOR = new Parcelable.Creator<Param1>() {
        @Override
        public Param1 createFromParcel(Parcel source) {
            return new Param1(source);
        }

        @Override
        public Param1[] newArray(int size) {
            return new Param1[size];
        }
    };
}
