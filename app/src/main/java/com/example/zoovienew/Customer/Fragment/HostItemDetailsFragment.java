package com.example.zoovienew.Customer.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zoovienew.Customer.Activity.FragViewerActivity;
import com.example.zoovienew.Customer.Activity.HomePageActivity;
import com.example.zoovienew.Customer.Adapter.HomeHost_CalenderAdapter;
import com.example.zoovienew.Customer.Adapter.HostItemPagerAdapter;
import com.example.zoovienew.Customer.Adapter.SlidingImage_Adapter;
import com.example.zoovienew.Customer.Model.HostCalenderModel;
import com.example.zoovienew.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class HostItemDetailsFragment extends Fragment implements View.OnClickListener,HomeHost_CalenderAdapter.ItemSelectDateListener{
//    private FragmentHostItemDetailsBinding binding;
    private static final Integer[] IMAGES= {R.drawable.profile_girl,R.drawable.profile_girl,R.drawable.profile_girl,R.drawable.profile_girl};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    ViewPager pager;
    TabLayout hostTabLayout;
    TabItem tabAvailability, tabEvents;
    ImageView backBtn, share, message, calender;


    RecyclerView recycler_calener;
    ArrayList<HostCalenderModel> calender_date_list;
    TextView txt_month_name,txt_date;

     @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_host_item_details, container, false);

        backBtn = view.findViewById(R.id.btn_back);
        backBtn.setOnClickListener(this);

        share = view.findViewById(R.id.iv_share);
        message = view.findViewById(R.id.iv_message);
        calender = view.findViewById(R.id.iv_calender);
        share.setOnClickListener(this);
        message.setOnClickListener(this);
        calender.setOnClickListener(this);

        txt_month_name=view.findViewById(R.id.txt_month_name);
        txt_date=view.findViewById(R.id.txt_date);

        initCalenderDateData(view);

        pager = view.findViewById(R.id.view_pager_host_item);
        hostTabLayout=view.findViewById(R.id.tab_layout_host_item);
        tabEvents = view.findViewById(R.id.tab_events);

        HostItemPagerAdapter adapter = new HostItemPagerAdapter(getChildFragmentManager(),
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
        return view;
    }

    private void initCalenderDateData(View view)
    {
        calender_date_list=new ArrayList<>();

        calender_date_list.add(new HostCalenderModel("01/july/2021","01","july","2021"));
        calender_date_list.add(new HostCalenderModel("01/july/2021","02","july","2021"));
        calender_date_list.add(new HostCalenderModel("01/july/2021","03","july","2021"));
        calender_date_list.add(new HostCalenderModel("01/july/2021","04","july","2021"));
        calender_date_list.add(new HostCalenderModel("01/july/2021","05","july","2021"));
        calender_date_list.add(new HostCalenderModel("01/july/2021","06","july","2021"));

        txt_month_name.setText(calender_date_list.get(0).getMonth());
        txt_date.setText(calender_date_list.get(0).getDate());
        recycler_calener=view.findViewById(R.id.recycler_calener);
        recycler_calener.setAdapter(new HomeHost_CalenderAdapter(this,calender_date_list,getActivity()));
    }

    private void init(View view) {
        ImagesArray = new ArrayList<Integer>();
        for(int i=0;i<IMAGES.length;i++)
            ImagesArray.add(IMAGES[i]);
        mPager = (ViewPager) view.findViewById(R.id.pager);
        mPager.setAdapter(new SlidingImage_Adapter(getActivity(),ImagesArray));
        CirclePageIndicator indicator = (CirclePageIndicator)
                view.findViewById(R.id.indicator);
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
        if (v.getId() == R.id.btn_back){
            Intent intent = new Intent(getActivity(), HomePageActivity.class);
            startActivity(intent);
        }
        else if (v.getId() == R.id.iv_share){
            Toast.makeText(getContext(), "Share Clicked", Toast.LENGTH_LONG).show();
        }
        else if (v.getId() == R.id.iv_message){
            Intent intent = new Intent(getActivity(), FragViewerActivity.class);
            intent.putExtra("FragmentViewer","MessageFragment");
            startActivity(intent);
        }
        else if (v.getId() == R.id.iv_calender){
            BottomSheetDialog bottomSheerDialog = new BottomSheetDialog(getContext());
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
    }

    @Override
    public void onDateSelect(int position)
    {
        txt_month_name.setText(calender_date_list.get(position).getMonth());
        txt_date.setText(calender_date_list.get(position).getDate());
    }
}