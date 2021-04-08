package com.example.zoovienew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.example.zoovienew.Adapter.HomePagerAdapter;
import com.example.zoovienew.Fragment.HomeFragment;
import com.example.zoovienew.Fragment.NotificationFragment;
import com.example.zoovienew.Fragment.PlayFragment;
import com.example.zoovienew.Fragment.ProfileFragment;
import com.example.zoovienew.databinding.ActivityHomePageBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class HomePageActivity extends AppCompatActivity {
    private ActivityHomePageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_home_page);
        binding = ActivityHomePageBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        binding.bottomNavigation.setItemIconTintList(null);
        initBottomNav();
    }

    private void initBottomNav() {


        binding.bottomNavigation.setSelectedItemId(R.id.bn_home);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
        binding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment temp = null;
                switch (item.getItemId()) {
                    case R.id.bn_home:
                        temp = new HomeFragment();
                        break;

                    case R.id.bn_play:
                        temp = new PlayFragment();
                        break;

                    case R.id.bn_bell:
                        temp = new NotificationFragment();
                        break;

                    case R.id.bn_profile:
                        temp = new ProfileFragment();
                        break;
                }

                if (temp != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, temp).commit();
                }
                return true;
            }

        });
    }
}
        /*pager = findViewById(R.id.view_pager_home);

        homeTabLayout=findViewById(R.id.tabLayout);
        tabHosts = findViewById(R.id.tab_hosts);
        tabVenues = findViewById(R.id.tab_venues);


        HomePagerAdapter adapter = new HomePagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,homeTabLayout.getTabCount());
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
    }
*/



