package com.example.zoovienew.Customer.Model;

public class UpcomingEventModel {
    String evemtName, evemtTime;

    public UpcomingEventModel(String evemtName, String evemtTime) {
        this.evemtName = evemtName;
        this.evemtTime = evemtTime;
    }

    public String getLoungeName() {
        return evemtName;
    }

    public void setLoungeName(String evemtName) {
        this.evemtName = evemtName;
    }

    public String getLoungeTime() {
        return evemtTime;
    }

    public void setLoungeTime(String evemtTime) {
        this.evemtTime = evemtTime;
    }
}
