package com.example.zoovienew.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zoovienew.Adapter.HomeHostsAdapter;
import com.example.zoovienew.Adapter.HomeVenueAdapter;
import com.example.zoovienew.Model.HostModel;
import com.example.zoovienew.Model.VenueModel;
import com.example.zoovienew.R;
import com.example.zoovienew.databinding.FragmentHomeHostsBinding;
import com.example.zoovienew.databinding.FragmentHomeVenueBinding;

import java.util.ArrayList;

public class HomeVenueFragment extends Fragment {
    private FragmentHomeVenueBinding binding;
    ArrayList<VenueModel> dataHolder;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeVenueBinding.inflate(getLayoutInflater());


        binding.rvVenues.setLayoutManager(new LinearLayoutManager(getContext()));

        dataHolder = new ArrayList<>();


        dataHolder.add( new VenueModel("ALIBI ATLANTA","Atlanta"));
        dataHolder.add( new VenueModel("6 AM LOUNGE","Atlanta"));
        dataHolder.add( new VenueModel("ALIBI ATLANTA","Atlanta"));
        dataHolder.add( new VenueModel("6 AM LOUNGE","Atlanta"));
        dataHolder.add( new VenueModel("ALIBI ATLANTA","Atlanta"));
        dataHolder.add( new VenueModel("6 AM LOUNGE","Atlanta"));
        dataHolder.add( new VenueModel("ALIBI ATLANTA","Atlanta"));
        dataHolder.add( new VenueModel("6 AM LOUNGE","Atlanta"));
        dataHolder.add( new VenueModel("ALIBI ATLANTA","Atlanta"));
        dataHolder.add( new VenueModel("6 AM LOUNGE","Atlanta"));
        dataHolder.add( new VenueModel("ALIBI ATLANTA","Atlanta"));
        dataHolder.add( new VenueModel("6 AM LOUNGE","Atlanta"));


        binding.rvVenues.setAdapter(new HomeVenueAdapter(dataHolder, getActivity()));

        return binding.getRoot();
    }
}