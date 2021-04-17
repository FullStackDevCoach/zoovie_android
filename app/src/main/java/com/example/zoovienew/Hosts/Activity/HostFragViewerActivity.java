package com.example.zoovienew.Hosts.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.zoovienew.Customer.Fragment.ProfileFragment;
import com.example.zoovienew.Customer.Fragment.VenueItemDetailsFragment;
import com.example.zoovienew.Hosts.Fragment.HostConnectToVenueFragment;
import com.example.zoovienew.Hosts.Fragment.HostTransactionHistoryFragment;
import com.example.zoovienew.R;

public class HostFragViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_frag_viewer);

        String s1 =getIntent().getStringExtra("FragmentViewer");

        if (s1.equals("HostConnectToVenueFragment")){
            getSupportFragmentManager().beginTransaction().replace(R.id.host_fragment_container_in_activity, new HostConnectToVenueFragment()).commit();
        }
        else if (s1.equals("HostTransactionHistoryFragment")){
            getSupportFragmentManager().beginTransaction().replace(R.id.host_fragment_container_in_activity, new HostTransactionHistoryFragment()).commit();
        }
        else if (s1.equals("ProfileFragment")){
            getSupportFragmentManager().beginTransaction().replace(R.id.host_fragment_container_in_activity, new ProfileFragment()).commit();
        }
    }
}