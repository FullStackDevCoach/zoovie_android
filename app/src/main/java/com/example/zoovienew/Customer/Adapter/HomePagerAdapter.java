package com.example.zoovienew.Customer.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.zoovienew.Customer.Fragment.HomeEventsFragment;
import com.example.zoovienew.Customer.Fragment.HomeHostsFragment;
import com.example.zoovienew.Customer.Fragment.HomeVenueFragment;

public class HomePagerAdapter extends FragmentPagerAdapter {
    //to keep track on tabs
    private int tabNumber;

    public HomePagerAdapter(@NonNull FragmentManager fm, int behavior, int tabs) {
        super(fm, behavior);
        this.tabNumber =  tabs;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                return new HomeEventsFragment();
            case 1:
                return new HomeHostsFragment();
            case 2:
                return new HomeVenueFragment();

            default:
                return null;

        }
    }
    @Override
    public int getCount() {
        return tabNumber;
    }

}
