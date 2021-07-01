package com.example.zoovienew.Customer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zoovienew.Customer.Model.VenueReviewModel;
import com.example.zoovienew.R;
import com.example.zoovienew.customview.ratingbar.NiceRatingBar;
import com.example.zoovienew.customview.ratingbar.RatingStatus;

import java.util.ArrayList;

public class VenueReviewAdapter extends RecyclerView.Adapter<VenueReviewAdapter.MyViewHolder>{
    ArrayList<VenueReviewModel> dataHolder;
    private Context mContext ;

    public VenueReviewAdapter(ArrayList<VenueReviewModel> dataHolder, Context context) {
        this.dataHolder = dataHolder;
        mContext = context;
    }

    @NonNull
    @Override
    public VenueReviewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_venue_review,parent,false);
        return new VenueReviewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VenueReviewAdapter.MyViewHolder holder, int position) {
        holder.profileName.setText(dataHolder.get(position).getProfileName());
        holder.tv_review.setText(dataHolder.get(position).getProfileReview());
        holder. niceRatingBar.setRating(dataHolder.get(position).getProfileReting());
        holder.niceRatingBar.setRatingStatus(RatingStatus.Disable);
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView profileName,tv_review;
        ImageView iv_profile_image;
        NiceRatingBar niceRatingBar;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            profileName = itemView.findViewById(R.id.tv_profile_name);
            tv_review = itemView.findViewById(R.id.tv_review);
            iv_profile_image = itemView.findViewById(R.id.iv_profile_image);
            niceRatingBar = itemView.findViewById(R.id.niceRatingBar);
        }
    }
}

