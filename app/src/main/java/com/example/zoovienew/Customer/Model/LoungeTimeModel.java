package com.example.zoovienew.Customer.Model;

public class LoungeTimeModel {
    String loungeName, loungeTime;

    public LoungeTimeModel(String loungeName, String loungeTime) {
        this.loungeName = loungeName;
        this.loungeTime = loungeTime;
    }

    public String getLoungeName() {
        return loungeName;
    }

    public void setLoungeName(String loungeName) {
        this.loungeName = loungeName;
    }

    public String getLoungeTime() {
        return loungeTime;
    }

    public void setLoungeTime(String loungeTime) {
        this.loungeTime = loungeTime;
    }
}
