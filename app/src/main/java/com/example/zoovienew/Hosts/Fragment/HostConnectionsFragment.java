package com.example.zoovienew.Hosts.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.zoovienew.Customer.Adapter.ProfileViewAdapter;
import com.example.zoovienew.Customer.Model.ProfileModel;
import com.example.zoovienew.Hosts.Activity.HostFragViewerActivity;
import com.example.zoovienew.R;
import com.example.zoovienew.databinding.FragmentHostConnectionsBinding;

import java.util.ArrayList;


public class HostConnectionsFragment extends Fragment implements View.OnClickListener{
    private FragmentHostConnectionsBinding binding;
    ArrayList<ProfileModel> dataHolder;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHostConnectionsBinding.inflate(getLayoutInflater());
        binding.tvHostConnectViewAll.setOnClickListener(this);
        binding.rvConnectProfile.setLayoutManager(new GridLayoutManager(getContext(),4));

        dataHolder = new ArrayList<>();
        dataHolder.add( new ProfileModel("Rufaro"));
        dataHolder.add( new ProfileModel("Rufaro"));
        dataHolder.add( new ProfileModel("Rufaro"));
        dataHolder.add( new ProfileModel("Rufaro"));

        binding.rvConnectProfile.setAdapter(new ProfileViewAdapter(dataHolder, getActivity()));


        return binding.getRoot();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_host_connect_view_all){
            Intent intent= new Intent(getActivity(), HostFragViewerActivity.class);
            intent.putExtra("FragmentViewer", "HostConnectToVenueFragment");
            startActivity(intent);
        }
        
    }
}