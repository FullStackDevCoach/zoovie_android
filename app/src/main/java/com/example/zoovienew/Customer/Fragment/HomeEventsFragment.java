package com.example.zoovienew.Customer.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.zoovienew.R;
import com.example.zoovienew.utils.PowerMenuUtils;
import com.skydoves.powermenu.OnDismissedListener;
import com.skydoves.powermenu.OnMenuItemClickListener;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;

import org.jetbrains.annotations.NotNull;

public class HomeEventsFragment extends Fragment {

    AppCompatButton btn_event_now, btn_event_later;
    FrameLayout event_contentFrameLayout;
    PowerMenu hamburgerMenu;
    EventNowFragment eventNowFragment;

    private final OnMenuItemClickListener<PowerMenuItem> onHamburgerItemClickListener =
            new OnMenuItemClickListener<PowerMenuItem>() {
                @Override
                public void onItemClick(int position, PowerMenuItem item) {
                    Toast.makeText(getActivity(), item.getTitle(), Toast.LENGTH_SHORT).show();
                    if (eventNowFragment != null) {
                        eventNowFragment.filterEventNow(item.getTitle().toString());
                        hamburgerMenu.setSelectedPosition(position);
                    }
                    if (hamburgerMenu.isShowing()) {
                        hamburgerMenu.dismiss();
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
        View view = inflater.inflate(R.layout.fragment_home_events, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        listener();

        eventNowFragment = new EventNowFragment();
        load_fragment(eventNowFragment);
    }

    public void init(View view) {
        event_contentFrameLayout = view.findViewById(R.id.event_contentFrameLayout);
        btn_event_now = view.findViewById(R.id.btn_event_now);
        btn_event_later = view.findViewById(R.id.btn_event_later);


    }

    public void listener() {
        hamburgerMenu = PowerMenuUtils.getHamburgerPowerMenu(getActivity(), this, onHamburgerItemClickListener, onHamburgerMenuDismissedListener);

        btn_event_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (hamburgerMenu.isShowing()) {
                    hamburgerMenu.dismiss();
                }
                if (eventNowFragment != null) {
                    hamburgerMenu.clearPreference();
                    hamburgerMenu.setSelectedPosition(-1);
                    eventNowFragment.filterEventNow("");
                }
            }
        });

        btn_event_later.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onHamburger(view);
            }
        });
    }

    public void load_fragment(Fragment fragment) {
        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.event_contentFrameLayout, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

    public void onHamburger(View view) {
        if (hamburgerMenu.isShowing()) {
            hamburgerMenu.dismiss();
        } else {
            hamburgerMenu.showAsDropDown(view);
        }
    }
}