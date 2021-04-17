package com.example.zoovienew.Hosts.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.zoovienew.Customer.Adapter.NotificationVenueAdapter;
import com.example.zoovienew.Customer.Model.NotificationVenueModel;
import com.example.zoovienew.Hosts.Activity.HostHomePageActivity;
import com.example.zoovienew.Hosts.Adapter.TransactionDetailsAdapter;
import com.example.zoovienew.Hosts.Model.TransactionModel;
import com.example.zoovienew.R;
import com.example.zoovienew.databinding.FragmentHostTransactionHistoryBinding;

import java.util.ArrayList;


public class HostTransactionHistoryFragment extends Fragment implements View.OnClickListener {
    private FragmentHostTransactionHistoryBinding binding;
    ArrayList<TransactionModel> dataHolder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       binding = FragmentHostTransactionHistoryBinding.inflate(getLayoutInflater());
       binding.btnBack.setOnClickListener(this);
        binding.rvTransactionBrief.setLayoutManager(new LinearLayoutManager(getContext()));

        dataHolder = new ArrayList<>();

        dataHolder.add( new TransactionModel("$2000.32"));
        dataHolder.add( new TransactionModel("$500.78"));
        dataHolder.add( new TransactionModel("$1000.00"));
        dataHolder.add( new TransactionModel("$2230.32"));

        binding.rvTransactionBrief.setAdapter(new TransactionDetailsAdapter(dataHolder, getActivity()));


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