package com.example.zoovienew.Customer.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zoovienew.Customer.Activity.HomePageActivity;
import com.example.zoovienew.R;
import com.example.zoovienew.databinding.FragmentNotificationSeeAllBinding;


public class NotificationSeeAllFragment extends Fragment {
    private FragmentNotificationSeeAllBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentNotificationSeeAllBinding.inflate(getLayoutInflater());
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HomePageActivity.class);
                startActivity(intent);
            }
        });

        return binding.getRoot();
    }
}