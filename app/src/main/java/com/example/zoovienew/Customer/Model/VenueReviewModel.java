package com.example.zoovienew.Customer.Model;

public class VenueReviewModel
{
    String profileImage;
    String profileName;
    String profileReview;
    Float profileReting;

    public VenueReviewModel(String profileImage,
                            String profileName,
                            String profileReview,
                            Float profileReting)
    {
        this.profileImage = profileImage;
        this.profileName = profileName;
        this.profileReview = profileReview;
        this.profileReview = profileReview;
        this.profileReting = profileReting;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileReview() {
        return profileReview;
    }

    public void setProfileReview(String profileReview) {
        this.profileReview = profileReview;
    }

    public Float getProfileReting() {
        return profileReting;
    }

    public void setProfileReting(Float profileReting) {
        this.profileReting = profileReting;
    }
}
