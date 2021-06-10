package com.example.zoovienew.Customer.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zoovienew.Customer.Adapter.EventNowOrLaterAdapter;
import com.example.zoovienew.Customer.Model.ProfileModel;
import com.example.zoovienew.R;
import com.example.zoovienew.databinding.FragmentEventLaterBinding;

import java.util.ArrayList;


public class EventLaterFragment extends Fragment {
    private FragmentEventLaterBinding binding;
    ArrayList<ProfileModel> dataHolderConnection;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentEventLaterBinding.inflate(getLayoutInflater());

        binding.rvEventLater.setLayoutManager(new GridLayoutManager(getContext(),2));
        dataHolderConnection = new ArrayList<>();
        dataHolderConnection.add(new ProfileModel("Event Name"));
        dataHolderConnection.add(new ProfileModel("Event Name"));
        dataHolderConnection.add(new ProfileModel("Event Name"));
        dataHolderConnection.add(new ProfileModel("Event Name"));
        dataHolderConnection.add(new ProfileModel("Event Name"));
        dataHolderConnection.add(new ProfileModel("Event Name"));
        dataHolderConnection.add(new ProfileModel("Event Name"));
        dataHolderConnection.add(new ProfileModel("Event Name"));
        dataHolderConnection.add(new ProfileModel("Event Name"));
        dataHolderConnection.add(new ProfileModel("Event Name"));
        dataHolderConnection.add(new ProfileModel("Event Name"));
        dataHolderConnection.add(new ProfileModel("Event Name"));
        dataHolderConnection.add(new ProfileModel("Event Name"));
        dataHolderConnection.add(new ProfileModel("Event Name"));
        dataHolderConnection.add(new ProfileModel("Event Name"));
        dataHolderConnection.add(new ProfileModel("Event Name"));
        binding.rvEventLater.setAdapter(new EventNowOrLaterAdapter(dataHolderConnection, getActivity()));

        return binding.getRoot();
    }
}