package com.example.zoovienew.Customer.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zoovienew.Customer.Activity.FragViewerActivity;
import com.example.zoovienew.Customer.Model.ProfileModel;
import com.example.zoovienew.R;

import java.util.ArrayList;

public class ProfileViewAdapter extends RecyclerView.Adapter<ProfileViewAdapter.MyViewHolder>{
        ArrayList<ProfileModel> dataHolder;
private Context mContext ;

    public ProfileViewAdapter(ArrayList<ProfileModel> dataHolder, Context context) {
        this.dataHolder = dataHolder;
        mContext = context;
    }



@NonNull
@Override
public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_profile_picture_view,parent,false);
        return new MyViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
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
        profileName= itemView.findViewById(R.id.tv_profile_name);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.getApplicationContext().startActivity(new Intent(mContext, FragViewerActivity.class)
                        .putExtra("FragmentViewer","ProfileDetailsFragment")
                        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK));
            }
        });
    }
}
}
