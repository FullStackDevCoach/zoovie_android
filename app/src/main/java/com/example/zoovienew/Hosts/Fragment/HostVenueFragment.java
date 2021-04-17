package com.example.zoovienew.Hosts.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zoovienew.Customer.Adapter.ProfileViewConnectAdapter;
import com.example.zoovienew.Customer.Model.ProfileModel;
import com.example.zoovienew.Hosts.Adapter.VenueRemoveAdapter;
import com.example.zoovienew.R;
import com.example.zoovienew.databinding.FragmentHostVenueBinding;

import java.util.ArrayList;


public class HostVenueFragment extends Fragment {
    private FragmentHostVenueBinding binding;
    ArrayList<ProfileModel> dataHolder;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHostVenueBinding.inflate(getLayoutInflater());
        binding.rvRemoveProfile.setLayoutManager(new GridLayoutManager(getContext(),3));

        dataHolder = new ArrayList<>();
        dataHolder.add( new ProfileModel("Rufaro"));
        dataHolder.add( new ProfileModel("Rufaro"));
        dataHolder.add( new ProfileModel("Rufaro"));
        dataHolder.add( new ProfileModel("Rufaro"));
        dataHolder.add( new ProfileModel("Rufaro"));
        dataHolder.add( new ProfileModel("Rufaro"));
        dataHolder.add( new ProfileModel("Rufaro"));
        dataHolder.add( new ProfileModel("Rufaro"));

        binding.rvRemoveProfile.setAdapter(new VenueRemoveAdapter(dataHolder, getActivity()));


        return binding.getRoot();
    }
}