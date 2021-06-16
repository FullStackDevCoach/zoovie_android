package com.example.zoovienew.Customer.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.zoovienew.Customer.Adapter.DayOfWeekAdapter;
import com.example.zoovienew.Customer.Adapter.EventLaterAdapter;
import com.example.zoovienew.Customer.Model.EventLaterModel;
import com.example.zoovienew.databinding.FragmentEventLaterBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class EventLaterFragment extends Fragment {
    private FragmentEventLaterBinding binding;
    ArrayList<EventLaterModel> dataHolderConnection;
    ArrayList<String> dayofweeklist = new ArrayList<String>();
    DayOfWeekAdapter dayofweekAdapter;
    EventLaterAdapter eventLaterAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentEventLaterBinding.inflate(getLayoutInflater());
        dayofweeklist.clear();
        dayofweekAdapter = new DayOfWeekAdapter(getActivity(), dayofweeklist);
        binding.spinnerDayofweek.setAdapter(dayofweekAdapter);

        addData_dayofweek();

        binding.rvEventLater.setLayoutManager(new GridLayoutManager(getContext(), 2));
        dataHolderConnection = new ArrayList<>();
        dataHolderConnection.add(new EventLaterModel("Event Name", "Monday"));
        dataHolderConnection.add(new EventLaterModel("Event Name", "Monday"));
        dataHolderConnection.add(new EventLaterModel("Event Name", "Monday"));
        dataHolderConnection.add(new EventLaterModel("Event Name", "Tuesday"));
        dataHolderConnection.add(new EventLaterModel("Event Name", "Tuesday"));
        dataHolderConnection.add(new EventLaterModel("Event Name", "Tuesday"));
        dataHolderConnection.add(new EventLaterModel("Event Name", "Wednesday"));
        dataHolderConnection.add(new EventLaterModel("Event Name", "Wednesday"));
        dataHolderConnection.add(new EventLaterModel("Event Name", "Wednesday"));
        dataHolderConnection.add(new EventLaterModel("Event Name", "Thursday"));
        dataHolderConnection.add(new EventLaterModel("Event Name", "Thursday"));
        dataHolderConnection.add(new EventLaterModel("Event Name", "Friday"));
        dataHolderConnection.add(new EventLaterModel("Event Name", "Friday"));
        dataHolderConnection.add(new EventLaterModel("Event Name", "Saturday"));
        dataHolderConnection.add(new EventLaterModel("Event Name", "Sunday"));
        dataHolderConnection.add(new EventLaterModel("Event Name", "Sunday"));

        eventLaterAdapter=new EventLaterAdapter(dataHolderConnection, getActivity());
        binding.rvEventLater.setAdapter(eventLaterAdapter);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Listener();
    }

    public void Listener() {
        binding.spinnerDayofweek.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),
                        "Select : " + dayofweeklist.get(position),
                        Toast.LENGTH_SHORT).show();
                eventLaterAdapter.getFilter().filter(dayofweeklist.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
    }

    private void addData_dayofweek() {

        dayofweeklist.add("All");
        dayofweeklist.add("Monday");
        dayofweeklist.add("Tuesday");
        dayofweeklist.add("Wednesday");
        dayofweeklist.add("Thursday");
        dayofweeklist.add("Friday");
        dayofweeklist.add("Saturday");
        dayofweeklist.add("Sunday");

        dayofweekAdapter.notifyDataSetChanged();
    }
}