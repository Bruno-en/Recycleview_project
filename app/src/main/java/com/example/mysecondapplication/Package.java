package com.example.mysecondapplication;

public class Package {
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
