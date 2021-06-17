package com.example.zoovienew.Customer.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zoovienew.Customer.Adapter.EventLaterAdapter;
import com.example.zoovienew.Customer.Adapter.EventNowAdapter;
import com.example.zoovienew.Customer.Adapter.EventNowOrLaterAdapter;
import com.example.zoovienew.Customer.Adapter.ProfileViewAdapter;
import com.example.zoovienew.Customer.Model.EventLaterModel;
import com.example.zoovienew.Customer.Model.EventNowModel;
import com.example.zoovienew.Customer.Model.ProfileModel;
import com.example.zoovienew.R;
import com.example.zoovienew.databinding.FragmentEventNowBinding;

import java.util.ArrayList;


public class EventNowFragment extends Fragment
{
    private FragmentEventNowBinding binding;
    ArrayList<EventNowModel> dataHolderConnection;
    EventNowAdapter eventNowAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      binding = FragmentEventNowBinding.inflate(getLayoutInflater());

        binding.rvEventNow.setLayoutManager(new GridLayoutManager(getContext(),2));
        dataHolderConnection = new ArrayList<>();
        dataHolderConnection.add(new EventNowModel("Event Name", "Monday"));
        dataHolderConnection.add(new EventNowModel("Event Name", "Monday"));
        dataHolderConnection.add(new EventNowModel("Event Name", "Monday"));
        dataHolderConnection.add(new EventNowModel("Event Name", "Tuesday"));
        dataHolderConnection.add(new EventNowModel("Event Name", "Tuesday"));
        dataHolderConnection.add(new EventNowModel("Event Name", "Tuesday"));
        dataHolderConnection.add(new EventNowModel("Event Name", "Wednesday"));
        dataHolderConnection.add(new EventNowModel("Event Name", "Wednesday"));
        dataHolderConnection.add(new EventNowModel("Event Name", "Wednesday"));
        dataHolderConnection.add(new EventNowModel("Event Name", "Thursday"));
        dataHolderConnection.add(new EventNowModel("Event Name", "Thursday"));
        dataHolderConnection.add(new EventNowModel("Event Name", "Friday"));
        dataHolderConnection.add(new EventNowModel("Event Name", "Friday"));
        dataHolderConnection.add(new EventNowModel("Event Name", "Saturday"));
        dataHolderConnection.add(new EventNowModel("Event Name", "Sunday"));
        dataHolderConnection.add(new EventNowModel("Event Name", "Sunday"));

        eventNowAdapter=new EventNowAdapter(dataHolderConnection, getActivity());
        binding.rvEventNow.setAdapter(eventNowAdapter);
      
      return binding.getRoot();
    }

    public void filterEventNow(String value)
    {
        eventNowAdapter.getFilter().filter(value);
    }
}