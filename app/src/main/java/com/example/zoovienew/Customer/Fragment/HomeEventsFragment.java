package com.example.zoovienew.Customer.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zoovienew.Customer.Adapter.HomeEventPagerAdapter;
import com.example.zoovienew.Customer.Adapter.HomePagerAdapter;
import com.example.zoovienew.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class HomeEventsFragment extends Fragment {
    ViewPager pager;
    TabLayout homeTabLayout;
    TabItem tabNow, tabLater;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home_events, container, false);
        pager = view.findViewById(R.id.view_pager_home_events);
        homeTabLayout=view.findViewById(R.id.tabLayout);
        tabNow = view.findViewById(R.id.tab_now);
        tabLater = view.findViewById(R.id.tab_later);
        HomeEventPagerAdapter adapter = new HomeEventPagerAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,homeTabLayout.getTabCount());
        pager.setAdapter(adapter);

        homeTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(homeTabLayout));
        return view;
    }
}