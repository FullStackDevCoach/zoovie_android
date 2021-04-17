package com.example.zoovienew.Hosts.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zoovienew.Hosts.Activity.HostSignInActivity;
import com.example.zoovienew.R;
import com.example.zoovienew.databinding.FragmentHostForgotPasswordBinding;

import java.math.BigInteger;

public class HostForgotPasswordFragment extends Fragment {
    private FragmentHostForgotPasswordBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHostForgotPasswordBinding.inflate(getLayoutInflater());

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HostSignInActivity.class);
                startActivity(intent);
            }
        });


        return binding.getRoot();
    }
}