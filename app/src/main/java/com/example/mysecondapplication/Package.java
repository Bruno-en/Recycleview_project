package com.example.mysecondapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Package implements Parcelable {
    private String mpackage_number;
    private String mstreet_name;
    private String mstreet_number;
    private String mpostal_code;
    private String mcity;
    private String text2;
    private String text3;

    public Package(String package_number, String street_name, String street_number, String postal_code, String city) {
        mpackage_number = package_number;
        mstreet_name = street_name;
        mstreet_number = street_number;
        mpostal_code = postal_code;
        mcity = city;
        text2 = mstreet_name + " " + mstreet_number;
        text3 = mpostal_code + " " + mcity;
    }

    protected Package(Parcel in) {
        mpackage_number = in.readString();
        mstreet_name = in.readString();
        mstreet_number = in.readString();
        mpostal_code = in.readString();
        mcity = in.readString();
        text2 = in.readString();
        text3 = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mpackage_number);
        dest.writeString(mstreet_name);
        dest.writeString(mstreet_number);
        dest.writeString(mpostal_code);
        dest.writeString(mcity);
        dest.writeString(text2);
        dest.writeString(text3);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Package> CREATOR = new Creator<Package>() {
        @Override
        public Package createFromParcel(Parcel in) {
            return new Package(in);
        }

        @Override
        public Package[] newArray(int size) {
            return new Package[size];
        }
    };

    public void changeText1(String text) {
        text3 = text;
    }

    public String getPackage_number() {
        return mpackage_number;
    }

    public String getText2() {
        return text2;
    }

    public String getText3() {
        return text3;
    }
}
