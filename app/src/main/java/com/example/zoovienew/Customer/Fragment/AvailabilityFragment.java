package com.example.zoovienew.Customer.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zoovienew.Customer.Adapter.HostsItemLoungeAvailabilityAdapter;
import com.example.zoovienew.Customer.Model.LoungeTimeModel;
import com.example.zoovienew.R;
import com.example.zoovienew.databinding.FragmentAvailabilityBinding;

import java.util.ArrayList;


public class AvailabilityFragment extends Fragment implements View.OnClickListener{
    private FragmentAvailabilityBinding binding;
    ArrayList<LoungeTimeModel> dataHolder;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAvailabilityBinding.inflate(getLayoutInflater());
        binding.tvViewAll.setOnClickListener(this);
        binding.rvLoungeTime.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        dataHolder = new ArrayList<>();

        dataHolder.add( new LoungeTimeModel("ALIBI ATLANTA","2-4 PM"));
        dataHolder.add( new LoungeTimeModel("6 AM LOUNGE","4:30-6 PM"));
        dataHolder.add( new LoungeTimeModel("ALIBI ATLANTA","2-4 PM"));
        dataHolder.add( new LoungeTimeModel("6 AM LOUNGE","4:30-6 PM"));

        binding.rvLoungeTime.setAdapter(new HostsItemLoungeAvailabilityAdapter(dataHolder, getActivity()));

        return binding.getRoot();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_view_all){
            Fragment fragment = new AvailabilityViewAllFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container_in_Activity, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}