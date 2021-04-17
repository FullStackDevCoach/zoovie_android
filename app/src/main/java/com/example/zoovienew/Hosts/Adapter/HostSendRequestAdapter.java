package com.example.zoovienew.Hosts.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zoovienew.Customer.Adapter.ProfileViewConnectAdapter;
import com.example.zoovienew.Customer.Model.ProfileModel;
import com.example.zoovienew.R;

import java.util.ArrayList;

public class HostSendRequestAdapter extends RecyclerView.Adapter<HostSendRequestAdapter.MyViewHolder>{
    ArrayList<ProfileModel> dataHolder;
    private Context mContext ;

    public HostSendRequestAdapter(ArrayList<ProfileModel> dataHolder, Context context) {
        this.dataHolder = dataHolder;
        mContext = context;
    }

    @NonNull
    @Override
    public HostSendRequestAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_host_connect,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HostSendRequestAdapter.MyViewHolder holder, int position) {
        holder.profileName.setText(dataHolder.get(position).getProfileName());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView profileName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            profileName = itemView.findViewById(R.id.tv_profile_name_send_request);
        }
    }
}

