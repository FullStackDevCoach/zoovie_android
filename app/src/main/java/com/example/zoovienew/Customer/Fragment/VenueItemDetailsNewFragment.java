package com.example.zoovienew.Customer.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.zoovienew.Customer.Activity.FragViewerActivity;
import com.example.zoovienew.Customer.Activity.HomePageActivity;
import com.example.zoovienew.Customer.Adapter.VenueEventPagerAdapter;
import com.example.zoovienew.Customer.Adapter.VenueReviewAdapter;
import com.example.zoovienew.Customer.Model.VenueModel;
import com.example.zoovienew.Customer.Model.VenueReviewModel;
import com.example.zoovienew.R;
import com.example.zoovienew.databinding.FragmentVenueItemdetailsNewBinding;
import com.example.zoovienew.utils.PowerMenuUtils;
import com.google.android.material.tabs.TabLayout;
import com.skydoves.powermenu.OnDismissedListener;
import com.skydoves.powermenu.OnMenuItemClickListener;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;

import java.util.ArrayList;
import java.util.List;

public class VenueItemDetailsNewFragment extends Fragment implements View.OnClickListener {
    private FragmentVenueItemdetailsNewBinding binding;
    VenueModel dataHolder;
    List<String> vanueTimeList;
    ArrayList<VenueReviewModel> venueReviewList;

    PowerMenu venueTimeMenu;

    private final OnMenuItemClickListener<PowerMenuItem> onHamburgerItemClickListener =
            new OnMenuItemClickListener<PowerMenuItem>() {
                @Override
                public void onItemClick(int position, PowerMenuItem item) {
                    Toast.makeText(getActivity(), item.getTitle(), Toast.LENGTH_SHORT).show();

                    venueTimeMenu.setSelectedPosition(position);
                    if (venueTimeMenu.isShowing()) {
                        venueTimeMenu.dismiss();
                    }
                }
            };

    private final OnDismissedListener onHamburgerMenuDismissedListener = () -> Log.d("Test", "onDismissed hamburger menu");


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentVenueItemdetailsNewBinding.inflate(getLayoutInflater());

        dataHolder = new VenueModel("ALIBI ATLANTA", "Atlanta, GA, USA", "5.0");
        vanueTimeList = new ArrayList<>();
        vanueTimeList.add("6 AM LOUNGE");
        vanueTimeList.add("8 AM ATLANTA");
        vanueTimeList.add("9 AM LOUNGE");
        vanueTimeList.add("10 AM ATLANTA");
        vanueTimeList.add("11 AM LOUNGE");
        vanueTimeList.add("4 PM ATLANTA");
        vanueTimeList.add("6 PM LOUNGE");

        venueReviewList = new ArrayList<>();

        venueReviewList.add(new VenueReviewModel("", "Rufaro", "I love this venue"));
        venueReviewList.add(new VenueReviewModel("", "John", "I love this venue"));
        venueReviewList.add(new VenueReviewModel("", "Rufaro", "I love this venue"));
        venueReviewList.add(new VenueReviewModel("", "Rufaro", "I love this venue"));


        binding.btnBack.setOnClickListener(this);
        binding.imgShare.setOnClickListener(this);
        binding.tvDetailVenueAddress.setOnClickListener(this);
        binding.lineHoursOpen.setOnClickListener(this);

        binding.headerTitle.setText(dataHolder.getVenueName());
        binding.headerRetting.setText(dataHolder.getVenueRating());
        binding.tvDetailVenueAddress.setText(dataHolder.getVenueLocation());

        binding.headerRetting.setOnClickListener(this);


        binding.rvReviewVenue.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        binding.rvReviewVenue.setAdapter(new VenueReviewAdapter(venueReviewList, getActivity()));

        venueTimeMenu = PowerMenuUtils.getVenueTimePowerMenu(getActivity(), this, onHamburgerItemClickListener, onHamburgerMenuDismissedListener);

        VenueEventPagerAdapter adapter = new VenueEventPagerAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, binding.tabLayout.getTabCount());
        binding.viewPagerVenueEvent.setAdapter(adapter);

        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.viewPagerVenueEvent.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        binding.viewPagerVenueEvent.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout));

        return binding.getRoot();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_ticket_play) {
            Intent intent = new Intent(getContext(), FragViewerActivity.class);
            intent.putExtra("FragmentViewer", "VenueItemDetailsTicketFragment");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_back) {
            Intent n1 = new Intent(getActivity(), HomePageActivity.class);
            startActivity(n1);
        } else if (v.getId() == R.id.img_share) {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Your body here";
            String shareSub = "Your subject here";
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share using"));
        } else if (v.getId() == R.id.tv_detail_venue_address) {
            Uri mapUri = Uri.parse("geo:0,0?q=" + Uri.encode(dataHolder.getVenueLocation()));
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        } else if (v.getId() == R.id.line_hours_open) {
            if (venueTimeMenu.isShowing()) {
                venueTimeMenu.dismiss();
            } else {
                venueTimeMenu.showAsDropDown(v);
            }
        }

    }
}