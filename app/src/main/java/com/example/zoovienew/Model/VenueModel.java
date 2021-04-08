package com.example.zoovienew.Model;

public class VenueModel {
    String venueName, venueLocation;

    public VenueModel(String venueName, String venueLocation) {
        this.venueName = venueName;
        this.venueLocation = venueLocation;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueLocation() {
        return venueLocation;
    }

    public void setVenueLocation(String venueLocation) {
        this.venueLocation = venueLocation;
    }
}
