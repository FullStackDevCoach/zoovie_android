package com.example.zoovienew.Customer.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.zoovienew.Customer.Fragment.AvailabilityFragment;
import com.example.zoovienew.Customer.Fragment.EventFragment;
import com.example.zoovienew.Customer.Fragment.ProfileCommentFragment;
import com.example.zoovienew.Customer.Fragment.ProfileVisitedPlacesFragment;

public class OtherProfilePagerAdapter extends FragmentPagerAdapter {
    //to keep track on tabs
    private int tabNumber;

    public OtherProfilePagerAdapter(@NonNull FragmentManager fm, int behavior, int tabs) {
        super(fm, behavior);
        this.tabNumber =  tabs;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                return new ProfileVisitedPlacesFragment();
            case 1:
                return new ProfileCommentFragment();

            default:
                return null;

        }
    }
    @Override
    public int getCount() {
        return tabNumber;
    }
}
