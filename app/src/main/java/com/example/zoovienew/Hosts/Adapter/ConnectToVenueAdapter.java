package com.example.zoovienew.Hosts.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.zoovienew.Hosts.Fragment.HostConnectionsFragment;
import com.example.zoovienew.Hosts.Fragment.HostProgressFragment;
import com.example.zoovienew.Hosts.Fragment.HostSendRequestFragment;
import com.example.zoovienew.Hosts.Fragment.HostVenueFragment;

public class ConnectToVenueAdapter extends FragmentPagerAdapter {
    //to keep track on tabs
    private int tabNumber;

    public ConnectToVenueAdapter(@NonNull FragmentManager fm, int behavior, int tabs) {
        super(fm, behavior);
        this.tabNumber =  tabs;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                return new HostVenueFragment();
            case 1:
                return new HostSendRequestFragment();

            default:
                return null;

        }
    }
    @Override
    public int getCount() {
        return tabNumber;
    }
}
