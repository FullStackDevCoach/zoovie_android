package com.example.zoovienew.Hosts.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zoovienew.Customer.Fragment.VenueItemDetailsFragment;
import com.example.zoovienew.Hosts.Activity.HostHomePageActivity;
import com.example.zoovienew.R;
import com.example.zoovienew.databinding.FragmentHostConnectionViewAllBinding;


public class HostConnectionViewAllFragment extends Fragment implements View.OnClickListener {
    private FragmentHostConnectionViewAllBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHostConnectionViewAllBinding.inflate(getLayoutInflater());
        binding.btnBack.setOnClickListener(this);
        return binding.getRoot();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_back){
            Intent intent = new Intent(getActivity(), HostHomePageActivity.class);
            startActivity(intent);
        }
    }
}