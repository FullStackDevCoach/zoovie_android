package com.example.zoovienew.Customer.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zoovienew.R;
import com.example.zoovienew.databinding.FragmentVenueItemDetailsTicketBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;


public class VenueItemDetailsTicketFragment extends Fragment implements View.OnClickListener{
    private FragmentVenueItemDetailsTicketBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentVenueItemDetailsTicketBinding.inflate(getLayoutInflater());
        binding.rlTableService.setOnClickListener(this);
        binding.rlGeneralTickets.setOnClickListener(this);
        binding.rlVipTickets.setOnClickListener(this);
        binding.btnBack.setOnClickListener(this);

        return binding.getRoot();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.rl_table_service) {
            BottomSheetDialog bottomSheerDialog = new BottomSheetDialog(getContext());
            View parentView = getLayoutInflater().inflate(R.layout.dialog_bottom_table_service,null);
            bottomSheerDialog.setContentView(parentView);
            bottomSheerDialog.show();

            Button orderNow = parentView.findViewById(R.id.btn_dialog_bottom_order_now);
            orderNow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(getContext(),"button clicked",Toast.LENGTH_LONG).show();
                    Fragment fragment = new ThankYouFragment();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container_in_Activity, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    bottomSheerDialog.dismiss();
                }
            });
        }
        else if (view.getId() == R.id.rl_vip_tickets){
            BottomSheetDialog bottomSheerDialog = new BottomSheetDialog(getContext());
            View parentView = getLayoutInflater().inflate(R.layout.dialog_bottom_buy_ticket,null);
            bottomSheerDialog.setContentView(parentView);

            TextView headerName = parentView.findViewById(R.id.tv_dialog_header);
            headerName.setText("VIP Tickets");

            TextView itemName = parentView.findViewById(R.id.tv_dialog_item_name);
            itemName.setText("No. of Tickets");

            bottomSheerDialog.show();

            Button orderNow = parentView.findViewById(R.id.btn_dialog_bottom_order_now);
            orderNow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(getContext(),"button clicked",Toast.LENGTH_LONG).show();
                    Fragment fragment = new ThankYouFragment();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container_in_Activity, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    bottomSheerDialog.dismiss();
                }
            });
        }
        else if (view.getId() == R.id.rl_general_tickets){
            BottomSheetDialog bottomSheerDialog = new BottomSheetDialog(getContext());
            View parentView = getLayoutInflater().inflate(R.layout.dialog_bottom_buy_ticket,null);
            bottomSheerDialog.setContentView(parentView);

            TextView headerName = parentView.findViewById(R.id.tv_dialog_header);
            headerName.setText("General Tickets");

            TextView itemName = parentView.findViewById(R.id.tv_dialog_item_name);
            itemName.setText("No. of Tickets");

            bottomSheerDialog.show();

            Button orderNow = parentView.findViewById(R.id.btn_dialog_bottom_order_now);
            orderNow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(getContext(),"button clicked",Toast.LENGTH_LONG).show();
                    Fragment fragment = new ThankYouFragment();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container_in_Activity, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    bottomSheerDialog.dismiss();
                }
            });
        }
        else if (view.getId() == R.id.btn_back){
            Fragment fragment = new VenueItemDetailsFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container_in_Activity, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}