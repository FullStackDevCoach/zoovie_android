package com.example.zoovienew.Customer.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zoovienew.Customer.Activity.FragViewerActivity;
import com.example.zoovienew.Customer.Adapter.ProfileViewAdapter;
import com.example.zoovienew.Customer.Model.ProfileModel;
import com.example.zoovienew.R;
import com.example.zoovienew.databinding.FragmentProfileBinding;

import java.util.ArrayList;


public class ProfileFragment extends Fragment implements View.OnClickListener {
    private FragmentProfileBinding binding;
    ArrayList<ProfileModel> dataHolder;
    ArrayList<ProfileModel> dataHolderConnection;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding  = FragmentProfileBinding.inflate(getLayoutInflater());
        binding.ivSettings.setOnClickListener(this);

        binding.rvHighlightProfile.setLayoutManager(new GridLayoutManager(getContext(),4));

        dataHolder = new ArrayList<>();
        dataHolder.add( new ProfileModel("Rufaro"));
        dataHolder.add( new ProfileModel("Rufaro"));
        dataHolder.add( new ProfileModel("Rufaro"));
        dataHolder.add( new ProfileModel("Rufaro"));

        binding.rvHighlightProfile.setAdapter(new ProfileViewAdapter(dataHolder, getActivity()));

        binding.rvConnectionProfile.setLayoutManager(new GridLayoutManager(getContext(),4));
        dataHolderConnection = new ArrayList<>();
        dataHolderConnection.add(new ProfileModel("Rufaro"));
        dataHolderConnection.add(new ProfileModel("Rufaro"));
        dataHolderConnection.add(new ProfileModel("Rufaro"));
        dataHolderConnection.add(new ProfileModel("Rufaro"));
        dataHolderConnection.add(new ProfileModel("Rufaro"));
        dataHolderConnection.add(new ProfileModel("Rufaro"));
        dataHolderConnection.add(new ProfileModel("Rufaro"));
        dataHolderConnection.add(new ProfileModel("Rufaro"));
        dataHolderConnection.add(new ProfileModel("Rufaro"));
        dataHolderConnection.add(new ProfileModel("Rufaro"));
        dataHolderConnection.add(new ProfileModel("Rufaro"));
        dataHolderConnection.add(new ProfileModel("Rufaro"));
        dataHolderConnection.add(new ProfileModel("Rufaro"));
        dataHolderConnection.add(new ProfileModel("Rufaro"));
        dataHolderConnection.add(new ProfileModel("Rufaro"));
        dataHolderConnection.add(new ProfileModel("Rufaro"));
        binding.rvConnectionProfile.setAdapter(new ProfileViewAdapter(dataHolderConnection, getActivity()));
        return binding.getRoot();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_settings){
            Intent intent = new Intent(getActivity(), FragViewerActivity.class);
            intent.putExtra("FragmentViewer","SettingsFragment");
            startActivity(intent);
        }
    }
}