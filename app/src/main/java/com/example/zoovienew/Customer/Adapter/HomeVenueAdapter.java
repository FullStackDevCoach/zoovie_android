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
import com.example.zoovienew.Customer.Model.VenueModel;
import com.example.zoovienew.R;

import java.util.ArrayList;

public class HomeVenueAdapter extends RecyclerView.Adapter<HomeVenueAdapter.myViewHolder>{
    ArrayList<VenueModel> dataHolder;
    private Context mContext ;

    public HomeVenueAdapter(ArrayList<VenueModel> dataHolder, Context context) {
        this.dataHolder = dataHolder;
        mContext = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_venue_detail_home,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.venueName.setText(dataHolder.get(position).getVenueName());
        holder.venueLocation.setText(dataHolder.get(position).getVenueLocation());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        TextView venueName, venueLocation;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            venueName = itemView.findViewById(R.id.tv_venue_name);
            venueLocation = itemView.findViewById(R.id.tv_venue_location);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mContext.getApplicationContext().startActivity(new Intent(mContext, FragViewerActivity.class)
                            .putExtra("FragmentViewer","VenueItemDetailFragment")
                            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK));
                }
            });
        }

    }
}
