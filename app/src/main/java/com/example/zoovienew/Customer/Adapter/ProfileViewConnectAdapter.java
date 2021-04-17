package com.example.zoovienew.Customer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zoovienew.Customer.Model.ProfileModel;
import com.example.zoovienew.R;

import java.util.ArrayList;

public class ProfileViewConnectAdapter extends RecyclerView.Adapter<ProfileViewConnectAdapter.MyViewHolder>{
    ArrayList<ProfileModel> dataHolder;
    private Context mContext ;

    public ProfileViewConnectAdapter(ArrayList<ProfileModel> dataHolder, Context context) {
        this.dataHolder = dataHolder;
        mContext = context;
    }

    @NonNull
    @Override
    public ProfileViewConnectAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_profile_connect,parent,false);
        return new ProfileViewConnectAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewConnectAdapter.MyViewHolder holder, int position) {
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
            profileName = itemView.findViewById(R.id.tv_profile_name_connect);
        }
    }
}

