package com.example.zoovienew.Customer.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zoovienew.Customer.Activity.FragViewerActivity;
import com.example.zoovienew.Customer.Adapter.NotificationVenueAdapter;
import com.example.zoovienew.Customer.Model.NotificationVenueModel;
import com.example.zoovienew.R;
import com.example.zoovienew.databinding.FragmentNotificationBinding;

import java.util.ArrayList;


public class NotificationFragment extends Fragment implements View.OnClickListener{
    private FragmentNotificationBinding binding;
    ArrayList<NotificationVenueModel> dataHolder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentNotificationBinding.inflate(getLayoutInflater());
        binding.ivChat.setOnClickListener(this);
        binding.tvTicketSeeAll.setOnClickListener(this);
        binding.tvMessageSeeAll.setOnClickListener(this);
        binding.tvNotificationSeeAll.setOnClickListener(this);

        binding.rvNotificationTicket.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        dataHolder = new ArrayList<>();

        dataHolder.add( new NotificationVenueModel("ALIBI ATLANTA"));
        dataHolder.add( new NotificationVenueModel("6 AM LOUNGE"));
        dataHolder.add( new NotificationVenueModel("ALIBI ATLANTA"));
        dataHolder.add( new NotificationVenueModel("6 AM LOUNGE"));
        dataHolder.add( new NotificationVenueModel("ALIBI ATLANTA"));
        dataHolder.add( new NotificationVenueModel("6 AM LOUNGE"));
        dataHolder.add( new NotificationVenueModel("ALIBI ATLANTA"));
        dataHolder.add( new NotificationVenueModel("6 AM LOUNGE"));



        binding.rvNotificationTicket.setAdapter(new NotificationVenueAdapter(dataHolder, getActivity()));

        return binding.getRoot();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_chat){
            Intent intent = new Intent(getActivity(), FragViewerActivity.class);
            intent.putExtra("FragmentViewer", "MessageFragment");
            startActivity(intent);
        }
        else if (v.getId() == R.id.tv_message_see_all)
        {
            Intent intent = new Intent(getActivity(), FragViewerActivity.class);
            intent.putExtra("FragmentViewer", "MessageFragment");
            startActivity(intent);
        }
        else if (v.getId() == R.id.tv_notification_see_all){
            Intent intent = new Intent(getActivity(), FragViewerActivity.class);
            intent.putExtra("FragmentViewer", "NotificationSeeAllFragment");
            startActivity(intent);
        }
        else if (v.getId() == R.id.tv_ticket_see_all){
            Intent intent = new Intent(getActivity(), FragViewerActivity.class);
            intent.putExtra("FragmentViewer","TicketSeeAllFragment");
            startActivity(intent);
        }

    }
}