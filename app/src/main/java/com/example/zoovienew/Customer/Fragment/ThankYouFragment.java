package com.example.zoovienew.Customer.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zoovienew.Customer.Activity.HomePageActivity;
import com.example.zoovienew.R;
import com.example.zoovienew.databinding.FragmentThankYouBinding;

public class ThankYouFragment extends Fragment implements View.OnClickListener{
    private FragmentThankYouBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentThankYouBinding.inflate(getLayoutInflater());
        binding.btnGoToHomePage.setOnClickListener(this);
        binding.tvCancel.setOnClickListener(this);

        return binding.getRoot();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_go_to_home_page){
            Intent intent = new Intent(getActivity(), HomePageActivity.class);
            startActivity(intent);
        }
        else if (view.getId() == R.id.tv_cancel){
            Intent intent = new Intent(getActivity(), HomePageActivity.class);
            startActivity(intent);
        }
    }
}