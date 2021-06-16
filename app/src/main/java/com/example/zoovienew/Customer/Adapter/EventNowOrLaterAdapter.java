package com.example.zoovienew.Customer.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zoovienew.customview.emojislider.EmojiSlider;
import com.example.zoovienew.Customer.Activity.FragViewerActivity;
import com.example.zoovienew.Customer.Model.ProfileModel;
import com.example.zoovienew.R;

import java.util.ArrayList;

import kotlin.Unit;

public class EventNowOrLaterAdapter extends RecyclerView.Adapter<EventNowOrLaterAdapter.ViewHolder>{
    ArrayList<ProfileModel> dataHolder;
    private Context mContext ;

    public EventNowOrLaterAdapter(ArrayList<ProfileModel> dataHolder, Context mContext) {
        this.dataHolder = dataHolder;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event_now_and_later,parent,false);
        return new EventNowOrLaterAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.profileName.setText(dataHolder.get(position).getProfileName());
        holder.slider_seekbar.setPositionListener(pos ->
        {
            if(pos<0.33f)
            {
                holder.slider_seekbar.setEmoji("❄");
            }else if(pos<0.66f )
            {
                holder.slider_seekbar.setEmoji("🔥");
            }else if(pos>0.66f || pos==1.0f)
            {
                holder.slider_seekbar.setEmoji("🔥🔥");
            }
            return Unit.INSTANCE;
        });
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView profileName;
        EmojiSlider slider_seekbar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profileName= itemView.findViewById(R.id.tv_event_name_now_later);
            slider_seekbar = itemView.findViewById(R.id.slider_seekbar);
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
