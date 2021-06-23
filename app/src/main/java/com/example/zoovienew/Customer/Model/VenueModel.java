package com.example.zoovienew.Customer.Model;

import java.util.List;

public class VenueModel {
    String venueName, venueLocation, venueRating;
    List<String>vanueTimeList;
    List<VenueReviewModel>VenueReviewList;

    public VenueModel(String venueName, String venueLocation) {
        this.venueName = venueName;
        this.venueLocation = venueLocation;
    }

    public VenueModel(String venueName, String venueLocation, String venueRating) {
        this.venueName = venueName;
        this.venueLocation = venueLocation;
        this.venueRating = venueRating;

    }

    public String getVenueRating() {
        return venueRating;
    }

    public void setVenueRating(String venueRating) {
        this.venueRating = venueRating;
    }

    public List<String> getVanueTimeList() {
        return vanueTimeList;
    }

    public void setVanueTimeList(List<String> vanueTimeList) {
        this.vanueTimeList = vanueTimeList;
    }

    public List<VenueReviewModel> getVenueReviewList() {
        return VenueReviewList;
    }

    public void setVenueReviewList(List<VenueReviewModel> venueReviewList) {
        VenueReviewList = venueReviewList;
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
