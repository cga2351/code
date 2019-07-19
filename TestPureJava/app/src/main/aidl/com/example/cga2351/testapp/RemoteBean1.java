package com.example.cga2351.testapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * author : yuliang
 * mail : yuliang@navercorp.com
 * date : 2018/8/21
 * description :
 */
public class RemoteBean1 implements Parcelable {
    int a;
    String b;
    double c;


    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.a);
        dest.writeString(this.b);
        dest.writeDouble(this.c);
    }

    public RemoteBean1() {
    }

    protected RemoteBean1(Parcel in) {
        this.a = in.readInt();
        this.b = in.readString();
        this.c = in.readDouble();
    }

    public static final Parcelable.Creator<RemoteBean1> CREATOR = new Parcelable.Creator<RemoteBean1>() {
        @Override
        public RemoteBean1 createFromParcel(Parcel source) {
            return new RemoteBean1(source);
        }

        @Override
        public RemoteBean1[] newArray(int size) {
            return new RemoteBean1[size];
        }
    };
}