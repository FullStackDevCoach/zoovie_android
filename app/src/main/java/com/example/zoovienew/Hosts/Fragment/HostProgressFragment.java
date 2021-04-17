package com.example.zoovienew.Hosts.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zoovienew.Hosts.Activity.HostFragViewerActivity;
import com.example.zoovienew.Hosts.Activity.PayoutActivity;
import com.example.zoovienew.R;
import com.example.zoovienew.databinding.FragmentHostProgressBinding;

public class HostProgressFragment extends Fragment implements View.OnClickListener{
    private FragmentHostProgressBinding binding;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHostProgressBinding.inflate(getLayoutInflater());
        binding.tvHostPayout.setOnClickListener(this);
        binding.tvViewTransactionHistory.setOnClickListener(this);


        return binding.getRoot();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_host_payout){
            Intent intent = new Intent(getActivity(), PayoutActivity.class);
            //intent.putExtra("FragmentViewer","PayoutFragment");
            startActivity(intent);
        }
        else if (v.getId() == R.id.tv_view_transaction_history){
            Intent intent = new Intent(getActivity(), HostFragViewerActivity.class);
            intent.putExtra("FragmentViewer", "HostTransactionHistoryFragment");
            startActivity(intent);
        }

    }
}