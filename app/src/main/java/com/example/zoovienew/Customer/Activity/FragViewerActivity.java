package com.example.zoovienew.Customer.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.zoovienew.Customer.Fragment.CommentsFragment;
import com.example.zoovienew.Customer.Fragment.EventNowItemDetailsFragment;
import com.example.zoovienew.Customer.Fragment.HostItemDetailsFragment;
import com.example.zoovienew.Customer.Fragment.MessageFragment;
import com.example.zoovienew.Customer.Fragment.NotificationSeeAllFragment;
import com.example.zoovienew.Customer.Fragment.ProfileDetailsFragment;
import com.example.zoovienew.Customer.Fragment.SettingsFragment;
import com.example.zoovienew.Customer.Fragment.TicketSeeAllFragment;
import com.example.zoovienew.Customer.Fragment.VenueItemDetailsFragment;
import com.example.zoovienew.Customer.Fragment.VenueItemDetailsTicketFragment;
import com.example.zoovienew.Customer.Fragment.VenueItemDetailsNewFragment;
import com.example.zoovienew.R;

public class FragViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_viewer);

        String s1 =getIntent().getStringExtra("FragmentViewer");

        if (s1.equals("EventNowItemDetailsFragment")){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_in_Activity, new EventNowItemDetailsFragment()).commit();
        }if (s1.equals("Venue_itemDetailsFragmentNew")){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_in_Activity, new VenueItemDetailsNewFragment()).commit();
        }
//        if (s1.equals("VenueItemDetailFragment")){
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_in_Activity, new VenueItemDetailsFragment()).commit();
//        }
        else if (s1.equals("HostItemDetailFragment")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_in_Activity, new HostItemDetailsFragment()).commit();
        }
        else if (s1.equals("ProfileDetailsFragment")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_in_Activity, new ProfileDetailsFragment()).commit();
        }
        else if (s1.equals("VenueItemDetailsTicketFragment")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_in_Activity, new VenueItemDetailsTicketFragment()).commit();
        }
        else if (s1.equals("SettingsFragment")){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_in_Activity, new SettingsFragment()).commit();
        }
        else if (s1.equals("MessageFragment")){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_in_Activity, new MessageFragment()).commit();
        }
        else if (s1.equals("CommentsFragment")){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_in_Activity,new CommentsFragment()).commit();
        }
        else if (s1.equals("NotificationSeeAllFragment")){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_in_Activity,new NotificationSeeAllFragment()).commit();
        }
        else if (s1.equals("TicketSeeAllFragment")){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_in_Activity, new TicketSeeAllFragment()).commit();
        }
        /*else {
            getSupportFragmentManager().beginTransaction().replace(R.id.container_new, new AcceptOrder()).commit();
        }*/
    }
}