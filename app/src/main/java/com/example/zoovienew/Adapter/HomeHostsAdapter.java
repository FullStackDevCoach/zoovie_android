package com.example.zoovienew.Adapter;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zoovienew.Model.HostModel;
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
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hostName = itemView.findViewById(R.id.tv_host_username);
            hostAddress = itemView.findViewById(R.id.tv_host_address);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                  Intent n1 = new Intent(getActivity())
//                    mContext.getApplicationContext().startActivity(new Intent(mContext, AppointmentDetailsActivity.class).putExtra("FragmentViewer","0").setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK));

                }
            });
        }
    }
}
