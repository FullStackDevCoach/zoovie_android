package com.example.zoovienew.Customer.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.zoovienew.Customer.Adapter.EventNowAdapter;
import com.example.zoovienew.Customer.Adapter.UpcomingEventAdapter;
import com.example.zoovienew.Customer.Model.EventNowModel;
import com.example.zoovienew.Customer.Model.LoungeTimeModel;
import com.example.zoovienew.Customer.Model.UpcomingEventModel;
import com.example.zoovienew.R;
import com.example.zoovienew.databinding.FragmentEventNowBinding;
import com.example.zoovienew.databinding.FragmentEventUpcomingBinding;
import com.example.zoovienew.utils.PowerMenuUtils;
import com.skydoves.powermenu.OnDismissedListener;
import com.skydoves.powermenu.OnMenuItemClickListener;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class UpcomingEventsFragment extends Fragment {

    private FragmentEventUpcomingBinding binding;
    ArrayList<UpcomingEventModel> dataHolderConnection;
    UpcomingEventAdapter eventNowAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEventUpcomingBinding.inflate(getLayoutInflater());

        binding.rvEventUpcoming.setLayoutManager(new GridLayoutManager(getContext(),2));
        dataHolderConnection = new ArrayList<>();
        dataHolderConnection.add( new UpcomingEventModel("ALIBI ATLANTA","2-4 PM"));
        dataHolderConnection.add( new UpcomingEventModel("6 AM LOUNGE","4:30-6 PM"));
        dataHolderConnection.add( new UpcomingEventModel("ALIBI ATLANTA","2-4 PM"));
        dataHolderConnection.add( new UpcomingEventModel("6 AM LOUNGE","4:30-6 PM"));
        dataHolderConnection.add( new UpcomingEventModel("ALIBI ATLANTA","2-4 PM"));
        dataHolderConnection.add( new UpcomingEventModel("6 AM LOUNGE","4:30-6 PM"));

        eventNowAdapter=new UpcomingEventAdapter(dataHolderConnection, getActivity());
        binding.rvEventUpcoming.setAdapter(eventNowAdapter);

        return binding.getRoot();
    }
}