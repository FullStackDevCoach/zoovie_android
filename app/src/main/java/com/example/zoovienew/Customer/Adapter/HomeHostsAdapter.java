package com.example.zoovienew.Customer.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zoovienew.Customer.Activity.FragViewerActivity;
import com.example.zoovienew.Customer.Model.HostModel;
import com.example.zoovienew.R;

import java.util.ArrayList;

public class HomeHostsAdapter extends RecyclerView.Adapter<HomeHostsAdapter.ViewHolder> {

    ArrayList<HostModel> dataHolder;
    private Context mContext ;

    public HomeHostsAdapter(ArrayList<HostModel> dataHolder, Context context) {
        this.dataHolder = dataHolder;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hosts_details_home,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.hostName.setText(dataHolder.get(position).getHostName());
        holder.hostAddress.setText(dataHolder.get(position).getHostAddress());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView hostName, hostAddress;
        Button connect;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hostName = itemView.findViewById(R.id.tv_host_username);
            hostAddress = itemView.findViewById(R.id.tv_host_address);
            connect = itemView.findViewById(R.id.btn_host_connect);
            connect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContext.getApplicationContext().startActivity(new Intent(mContext, FragViewerActivity.class)
                            .putExtra("FragmentViewer","HostItemDetailFragment")
                            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK));
                }
            });
        }
    }
}
