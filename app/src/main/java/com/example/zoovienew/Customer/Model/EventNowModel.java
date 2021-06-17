package com.example.zoovienew.Customer.Model;

public class EventNowModel {
    String profileName;
    String dayofweek;

    public EventNowModel(String profileName, String dayofweek) {
        this.profileName = profileName;
        this.dayofweek = dayofweek;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getDayofweek() {
        return dayofweek;
    }

    public void setDayofweek(String dayofweek) {
        this.dayofweek = dayofweek;
    }
}
