package com.example.zoovienew.Customer.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.zoovienew.Customer.Activity.FragViewerActivity;
import com.example.zoovienew.Customer.Adapter.HomePagerAdapter;
import com.example.zoovienew.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


public class HomeFragment extends Fragment implements View.OnClickListener{

    ViewPager pager;
    TabLayout homeTabLayout;
    TabItem tabHosts, tabVenues, tabEvents;
    ImageView message;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        pager = view.findViewById(R.id.view_pager_home);
        message = view.findViewById(R.id.iv_chat);
        message.setOnClickListener(this);

        homeTabLayout=view.findViewById(R.id.tabLayout);
        tabEvents = view.findViewById(R.id.tab_events);
        tabHosts = view.findViewById(R.id.tab_hosts);
        tabVenues = view.findViewById(R.id.tab_venues);

        HomePagerAdapter adapter = new HomePagerAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,homeTabLayout.getTabCount());
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

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_chat){
            Intent intent = new Intent(getActivity(), FragViewerActivity.class);
            intent.putExtra("FragmentViewer","MessageFragment");
            startActivity(intent);
        }

    }
}