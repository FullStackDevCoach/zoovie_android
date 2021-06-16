package com.example.zoovienew.Customer.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zoovienew.Customer.Activity.FragViewerActivity;
import com.example.zoovienew.Customer.Model.EventLaterModel;
import com.example.zoovienew.R;
import com.example.zoovienew.customview.emojislider.EmojiSlider;

import java.util.ArrayList;
import java.util.List;

import kotlin.Unit;

public class EventLaterAdapter extends RecyclerView.Adapter<EventLaterAdapter.ViewHolder> implements Filterable {
     List<EventLaterModel> dataHolder;
     List<EventLaterModel> dataHolderFull;
    private Context mContext;

    public EventLaterAdapter(ArrayList<EventLaterModel> dataHolder, Context mContext) {
        this.mContext = mContext;
        this.dataHolder = dataHolder;
        dataHolderFull = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event_now_and_later, parent, false);
        return new EventLaterAdapter.ViewHolder(view);
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

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView profileName;
        EmojiSlider slider_seekbar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profileName = itemView.findViewById(R.id.tv_event_name_now_later);
            slider_seekbar = itemView.findViewById(R.id.slider_seekbar);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContext.getApplicationContext().startActivity(new Intent(mContext, FragViewerActivity.class)
                            .putExtra("FragmentViewer", "VenueItemDetailFragment")
                            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK));
                }
            });
        }
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<EventLaterModel> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(dataHolderFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                if(filterPattern.equalsIgnoreCase("All"))
                {
                    filteredList.addAll(dataHolderFull);
                }else {
                    for (EventLaterModel item : dataHolderFull) {
                        if (item.getDayofweek().toLowerCase().contains(filterPattern)) {
                            filteredList.add(item);
                        }
                    }
                }

            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            dataHolder.clear();
            dataHolder.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}
