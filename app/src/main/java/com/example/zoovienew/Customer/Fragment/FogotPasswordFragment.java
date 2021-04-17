package com.example.zoovienew.Customer.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zoovienew.Customer.Activity.SignInActivity;
import com.example.zoovienew.R;
import com.example.zoovienew.databinding.FragmentFogotPasswordBinding;

public class FogotPasswordFragment extends Fragment implements View.OnClickListener{

    private FragmentFogotPasswordBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFogotPasswordBinding.inflate(getLayoutInflater());
        binding.btnBack.setOnClickListener(this);


        return binding.getRoot();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_back){
            Intent intent = new Intent(getActivity(), SignInActivity.class);
            startActivity(intent);
        }
    }
}