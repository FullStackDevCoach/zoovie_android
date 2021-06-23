package com.example.zoovienew.Customer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zoovienew.Customer.Model.UpcomingEventModel;
import com.example.zoovienew.R;

import java.util.ArrayList;

public class UpcomingEventAdapter extends RecyclerView.Adapter<UpcomingEventAdapter.MyViewHolder> {

    ArrayList<UpcomingEventModel> dataHolder;
    Context mContext;

    public UpcomingEventAdapter(ArrayList<UpcomingEventModel> dataHolder, Context mContext) {
        this.dataHolder = dataHolder;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_upcoming_events,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_event_name.setText(dataHolder.get(position).getLoungeName());
        holder.tv_event_time.setText(dataHolder.get(position).getLoungeTime());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_event_name, tv_event_time;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_event_name = itemView.findViewById(R.id.tv_event_name);
            tv_event_time = itemView.findViewById(R.id.tv_event_time);
        }
    }
}
