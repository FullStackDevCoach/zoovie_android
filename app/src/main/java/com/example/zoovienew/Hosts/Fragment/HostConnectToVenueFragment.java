package com.example.zoovienew.Hosts.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.zoovienew.Customer.Adapter.HomePagerAdapter;
import com.example.zoovienew.Customer.Adapter.HostItemPagerAdapter;
import com.example.zoovienew.Customer.Adapter.ProfileViewAdapter;
import com.example.zoovienew.Customer.Adapter.ProfileViewConnectAdapter;
import com.example.zoovienew.Customer.Model.ProfileModel;
import com.example.zoovienew.Hosts.Activity.HostHomePageActivity;
import com.example.zoovienew.Hosts.Adapter.ConnectToVenueAdapter;
import com.example.zoovienew.R;
import com.example.zoovienew.databinding.FragmentHostConnectToVenueBinding;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class HostConnectToVenueFragment extends Fragment implements View.OnClickListener{

    ViewPager pager;
    TabLayout connectTabLayout;
    TabItem tabVenue, tabSendRequest;
    ImageView btnBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_host_connect_to_venue, container, false);
        pager = view.findViewById(R.id.view_pager_host_connect_to_venue);
        btnBack = view.findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);


        connectTabLayout=view.findViewById(R.id.tabLayout_connect_to_venues);
        tabVenue = view.findViewById(R.id.tab_venues);
        tabSendRequest = view.findViewById(R.id.tab_send_request);

        ConnectToVenueAdapter adapter = new ConnectToVenueAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,connectTabLayout.getTabCount());
        pager.setAdapter(adapter);

        connectTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(connectTabLayout));
        return view;

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_back){
            Intent intent = new Intent(getActivity(), HostHomePageActivity.class);
            startActivity(intent);
        }

    }
}