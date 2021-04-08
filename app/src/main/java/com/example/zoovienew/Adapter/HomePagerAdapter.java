package com.example.zoovienew.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.zoovienew.Fragment.HomeHostsFragment;
import com.example.zoovienew.Fragment.HomeVenueFragment;

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
                return new HomeHostsFragment();
            case 1:
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
