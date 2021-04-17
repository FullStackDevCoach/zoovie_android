package com.example.zoovienew.Hosts.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zoovienew.Customer.Adapter.ProfileViewConnectAdapter;
import com.example.zoovienew.Customer.Model.ProfileModel;
import com.example.zoovienew.Hosts.Adapter.HostSendRequestAdapter;
import com.example.zoovienew.R;
import com.example.zoovienew.databinding.FragmentHostSendRequestBinding;

import java.util.ArrayList;


public class HostSendRequestFragment extends Fragment {
    private FragmentHostSendRequestBinding binding;
    ArrayList<ProfileModel> dataHolder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHostSendRequestBinding.inflate(getLayoutInflater());

        binding.rvConnectHost.setLayoutManager(new GridLayoutManager(getContext(),3));

        dataHolder = new ArrayList<>();
        dataHolder.add( new ProfileModel("Alibi Atlanta"));
        dataHolder.add( new ProfileModel("Alibi Atlanta"));
        dataHolder.add( new ProfileModel("Alibi Atlanta"));
        dataHolder.add( new ProfileModel("Alibi Atlanta"));
        dataHolder.add( new ProfileModel("Alibi Atlanta"));
        dataHolder.add( new ProfileModel("Alibi Atlanta"));
        dataHolder.add( new ProfileModel("Alibi Atlanta"));
        dataHolder.add( new ProfileModel("Alibi Atlanta"));

        binding.rvConnectHost.setAdapter(new HostSendRequestAdapter(dataHolder, getActivity()));


        return binding.getRoot();
    }
}