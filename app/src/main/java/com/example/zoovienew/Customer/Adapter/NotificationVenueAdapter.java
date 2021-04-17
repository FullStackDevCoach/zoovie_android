package com.example.zoovienew.Customer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zoovienew.Customer.Model.HostModel;
import com.example.zoovienew.Customer.Model.NotificationVenueModel;
import com.example.zoovienew.R;

import java.util.ArrayList;

public class NotificationVenueAdapter extends RecyclerView.Adapter<NotificationVenueAdapter.MyViewHolder>{

    ArrayList<NotificationVenueModel> dataHolder;
    private Context mContext ;

    public NotificationVenueAdapter(ArrayList<NotificationVenueModel> dataHolder, Context context) {
        this.dataHolder = dataHolder;
        mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ticket_notification,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.venueName.setText(dataHolder.get(position).getVenueName());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView venueName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            venueName = itemView.findViewById(R.id.tv_notification_venue);
        }
    }
}
