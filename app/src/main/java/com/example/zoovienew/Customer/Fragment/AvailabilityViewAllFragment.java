package com.example.zoovienew.Customer.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zoovienew.R;
import com.example.zoovienew.databinding.FragmentAvailabilityViewAllBinding;

public class AvailabilityViewAllFragment extends Fragment implements View.OnClickListener {
    private FragmentAvailabilityViewAllBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      binding = FragmentAvailabilityViewAllBinding.inflate(getLayoutInflater());
      binding.btnBack.setOnClickListener(this);


      return binding.getRoot();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_back){
            Fragment fragment = new HostItemDetailsFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container_in_Activity, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}