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
import com.example.zoovienew.Customer.Activity.HomePageActivity;
import com.example.zoovienew.Customer.Adapter.OtherProfilePagerAdapter;
import com.example.zoovienew.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


public class ProfileDetailsFragment extends Fragment implements View.OnClickListener{
    ViewPager pager;
    TabLayout profileTabLayout;
    TabItem tabVisitedPlaces, tabComments;
    ImageView backBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_profile_details, container, false);
        pager = view.findViewById(R.id.view_pager_other_profile);
        profileTabLayout=view.findViewById(R.id.tab_layout_other_profile);
        tabVisitedPlaces = view.findViewById(R.id.tab_visited_places);
        tabComments = view.findViewById(R.id.tab_comments);
        backBtn= view.findViewById(R.id.btn_back);
        backBtn.setOnClickListener(this);

        OtherProfilePagerAdapter adapter = new OtherProfilePagerAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,profileTabLayout.getTabCount());
        pager.setAdapter(adapter);

        profileTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(profileTabLayout));

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_back){
            Intent intent = new Intent(getActivity(), HomePageActivity.class);
            startActivity(intent);
        }
    }
}