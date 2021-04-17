package com.example.zoovienew.Hosts.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zoovienew.Customer.Adapter.HostItemPagerAdapter;
import com.example.zoovienew.Customer.Adapter.SlidingImage_Adapter;
import com.example.zoovienew.Customer.Fragment.ThankYouFragment;
import com.example.zoovienew.Hosts.Adapter.HostsItemViewPagerAdapter;
import com.example.zoovienew.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class HostHomePageActivity extends AppCompatActivity implements View.OnClickListener{
    private static final Integer[] IMAGES= {R.drawable.profile_girl,R.drawable.profile_girl,
            R.drawable.profile_girl,R.drawable.profile_girl};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    View view;
    ViewPager pager;
    TabLayout hostTabLayout;
    TabItem tabConnections, tabProgress;
    TextView tv_view_all_connect_to_venues, viewProfile;
    ImageView calender;
    boolean doubleBackToExitPressedOnce = false;

   /* @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_home_page);

        tv_view_all_connect_to_venues = findViewById(R.id.tv_view_all_connect_to_venues);
        tv_view_all_connect_to_venues.setOnClickListener(this);

        viewProfile = findViewById(R.id.tv_view_profile);
        viewProfile.setOnClickListener(this);

        calender = findViewById(R.id.iv_host_home_page_calender);
        calender.setOnClickListener(this);

        pager = findViewById(R.id.view_pager_host_item);
        hostTabLayout=findViewById(R.id.tab_layout_host_item);
        tabConnections = findViewById(R.id.tab_connections);
        tabProgress = findViewById(R.id.tab_progress);

        HostsItemViewPagerAdapter adapter = new HostsItemViewPagerAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,hostTabLayout.getTabCount());
        pager.setAdapter(adapter);

        hostTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(hostTabLayout));

        init(view);
    }


    private void init(View view) {
        ImagesArray = new ArrayList<Integer>();
        for(int i=0;i<IMAGES.length;i++)
            ImagesArray.add(IMAGES[i]);
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new SlidingImage_Adapter(this,ImagesArray));
        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);
        indicator.setViewPager(mPager);
        final float density = getResources().getDisplayMetrics().density;
        indicator.setRadius(5 * density);
        NUM_PAGES =IMAGES.length;
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_view_all_connect_to_venues){
            Intent intent = new Intent(HostHomePageActivity.this, HostFragViewerActivity.class);
            intent.putExtra("FragmentViewer","HostConnectToVenueFragment");
            startActivity(intent);
        }
        else if (v.getId() == R.id.iv_host_home_page_calender){
            BottomSheetDialog bottomSheerDialog = new BottomSheetDialog(this);
            View parentView = getLayoutInflater().inflate(R.layout.dialog_bottom_calender,null);
            bottomSheerDialog.setContentView(parentView);
            bottomSheerDialog.show();

            Button apply = parentView.findViewById(R.id.btn_calender_apply);
            apply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(getContext(),"button clicked",Toast.LENGTH_LONG).show();
                    bottomSheerDialog.dismiss();
                }
            });

            ImageView cancel = parentView.findViewById(R.id.cancel);
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(getContext(),"button clicked",Toast.LENGTH_LONG).show();
                    bottomSheerDialog.dismiss();
                }
            });

        }
        else if (v.getId() == R.id.tv_view_profile){
            Intent intent = new Intent(HostHomePageActivity.this, HostFragViewerActivity.class);
            intent.putExtra("FragmentViewer", "ProfileFragment");
            startActivity(intent);
        }
    }
}