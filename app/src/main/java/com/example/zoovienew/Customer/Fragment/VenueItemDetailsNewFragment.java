package com.example.zoovienew.Customer.Fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.zoovienew.Customer.Activity.FragViewerActivity;
import com.example.zoovienew.Customer.Activity.HomePageActivity;
import com.example.zoovienew.Customer.Adapter.VenueEventPagerAdapter;
import com.example.zoovienew.Customer.Adapter.VenueReviewAdapter;
import com.example.zoovienew.Customer.Model.VenueModel;
import com.example.zoovienew.Customer.Model.VenueReviewModel;
import com.example.zoovienew.R;
import com.example.zoovienew.utils.PowerMenuUtils;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.skydoves.powermenu.OnDismissedListener;
import com.skydoves.powermenu.OnMenuItemClickListener;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class VenueItemDetailsNewFragment extends Fragment implements View.OnClickListener {
    //    private FragmentDetailvanueBinding binding;
    VenueModel dataHolder;
    List<String> vanueTimeList;
    ArrayList<VenueReviewModel> venueReviewList;

    PowerMenu venueTimeMenu;

    ViewPager pager;
    TabLayout tab_layout;
    TabItem tab_events_upcoming, tab_event_past;

    ImageView btn_back, iv_detail_venue_image, img_share;
    AppCompatTextView header_title, header_retting, tv_detail_venue_address;
    LinearLayout line_hours_open;
    RecyclerView rv_review_venue;

    AppCompatButton btn_ticket_table;

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
        View view = inflater.inflate(R.layout.fragment_detailvenue, container, false);

        pager = view.findViewById(R.id.view_pager_venue_event);
        tab_layout = view.findViewById(R.id.tab_layout);
        tab_events_upcoming = view.findViewById(R.id.tab_events_upcoming);
        tab_event_past = view.findViewById(R.id.tab_event_past);

        btn_back = view.findViewById(R.id.btn_back);
        iv_detail_venue_image = view.findViewById(R.id.iv_detail_venue_image);
        img_share = view.findViewById(R.id.img_share);

        header_title = view.findViewById(R.id.header_title);
        header_retting = view.findViewById(R.id.header_retting);
        tv_detail_venue_address = view.findViewById(R.id.tv_detail_venue_address);

        line_hours_open = view.findViewById(R.id.line_hours_open);
        rv_review_venue = view.findViewById(R.id.rv_review_venue);
        btn_ticket_table = view.findViewById(R.id.btn_ticket_table);


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


        btn_back.setOnClickListener(this);
        img_share.setOnClickListener(this);
        tv_detail_venue_address.setOnClickListener(this);
        line_hours_open.setOnClickListener(this);

        header_title.setText(dataHolder.getVenueName());
        header_retting.setText(dataHolder.getVenueRating());
        tv_detail_venue_address.setText(dataHolder.getVenueLocation());

        header_retting.setOnClickListener(this);


        rv_review_venue.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        rv_review_venue.setAdapter(new VenueReviewAdapter(venueReviewList, getActivity()));

        venueTimeMenu = PowerMenuUtils.getVenueTimePowerMenu(getActivity(), this, onHamburgerItemClickListener, onHamburgerMenuDismissedListener);

        VenueEventPagerAdapter adapter = new VenueEventPagerAdapter(getFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, tab_layout.getTabCount());
        pager.setAdapter(adapter);

        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab_layout));
        return view;

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