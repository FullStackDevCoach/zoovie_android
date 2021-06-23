package com.example.zoovienew.Customer.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.zoovienew.Customer.Fragment.HomeEventsFragment;
import com.example.zoovienew.Customer.Fragment.HomeHostsFragment;
import com.example.zoovienew.Customer.Fragment.HomeVenueFragment;
import com.example.zoovienew.Customer.Fragment.UpcomingEventsFragment;

public class VenueEventPagerAdapter extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public VenueEventPagerAdapter(FragmentManager fm, int behavior, int tabCount) {
        super(fm,behavior);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                return new UpcomingEventsFragment();

            case 1:
                return new UpcomingEventsFragment();

            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}

