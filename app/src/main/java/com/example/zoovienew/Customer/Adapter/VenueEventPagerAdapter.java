package com.example.zoovienew.Customer.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.zoovienew.Customer.Fragment.HomeEventsFragment;
import com.example.zoovienew.Customer.Fragment.HomeHostsFragment;
import com.example.zoovienew.Customer.Fragment.HomeVenueFragment;
import com.example.zoovienew.Customer.Fragment.UpcomingEventsFragment;

public class VenueEventPagerAdapter extends FragmentPagerAdapter {
    //to keep track on tabs
    private int tabNumber;

    public VenueEventPagerAdapter(@NonNull FragmentManager fm, int behavior, int tabs) {
        super(fm, behavior);
        this.tabNumber =  tabs;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                return new UpcomingEventsFragment();
            case 1:
                return new UpcomingEventsFragment();

            default:
                return null;

        }
    }
    @Override
    public int getCount() {
        return tabNumber;
    }

}
