package com.example.zoovienew.Customer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zoovienew.Customer.Model.LoungeTimeModel;
import com.example.zoovienew.Customer.Model.NotificationVenueModel;
import com.example.zoovienew.R;

import java.util.ArrayList;

public class HostsItemLoungeAvailabilityAdapter extends RecyclerView.Adapter<HostsItemLoungeAvailabilityAdapter.MyViewHolder>{

    ArrayList<LoungeTimeModel> dataHolder;
    private Context mContext ;

    public HostsItemLoungeAvailabilityAdapter(ArrayList<LoungeTimeModel> dataHolder, Context mContext) {
        this.dataHolder = dataHolder;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lounge_availability,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.loungeName.setText(dataHolder.get(position).getLoungeName());
        holder.loungeTime.setText(dataHolder.get(position).getLoungeTime());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView loungeName, loungeTime;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            loungeName = itemView.findViewById(R.id.tv_lounge_availability_name);
            loungeTime = itemView.findViewById(R.id.tv_lounge_availability_time);
        }
    }
}
