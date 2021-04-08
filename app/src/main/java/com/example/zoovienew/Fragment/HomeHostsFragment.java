package com.example.zoovienew.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zoovienew.Adapter.HomeHostsAdapter;
import com.example.zoovienew.Model.HostModel;
import com.example.zoovienew.R;
import com.example.zoovienew.databinding.FragmentHomeHostsBinding;

import java.util.ArrayList;

public class HomeHostsFragment extends Fragment {
    private FragmentHomeHostsBinding binding;
    ArrayList<HostModel> dataHolder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeHostsBinding.inflate(getLayoutInflater());


        binding.rvHost.setLayoutManager(new LinearLayoutManager(getContext()));

        dataHolder = new ArrayList<>();

        dataHolder.add( new HostModel("@Sumit Karil","OPIUM GOLDROOM, ATLANTA"));
        dataHolder.add( new HostModel("@Brain P. John","OPIUM GOLDROOM, ATLANTA"));
        dataHolder.add( new HostModel("@Sumit Karil","OPIUM GOLDROOM, ATLANTA"));
        dataHolder.add( new HostModel("@Brain P. John","OPIUM GOLDROOM, ATLANTA"));
        dataHolder.add( new HostModel("@Sumit Karil","OPIUM GOLDROOM, ATLANTA"));
        dataHolder.add( new HostModel("@Brain P. John","OPIUM GOLDROOM, ATLANTA"));
        dataHolder.add( new HostModel("@Sumit Karil","OPIUM GOLDROOM, ATLANTA"));
        dataHolder.add( new HostModel("@Brain P. John","OPIUM GOLDROOM, ATLANTA"));
        dataHolder.add( new HostModel("@Sumit Karil","OPIUM GOLDROOM, ATLANTA"));



        binding.rvHost.setAdapter(new HomeHostsAdapter(dataHolder, getActivity()));

        return binding.getRoot();
    }
}