package com.example.zoovienew.Customer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zoovienew.Customer.Model.SearchLocationModel;
import com.example.zoovienew.R;

import java.util.ArrayList;
import java.util.List;

public class SelectLocationAdapter extends RecyclerView.Adapter<SelectLocationAdapter.ViewHolder> implements Filterable {
    List<SearchLocationModel> dataHolder;
    List<SearchLocationModel> dataHolderFull;
    private Context mContext;
    int selectedPosition = -1;

    public SelectLocationAdapter(ArrayList<SearchLocationModel> dataHolder, Context mContext) {
        this.mContext = mContext;
        this.dataHolder = dataHolder;
        dataHolderFull = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_select_location, parent, false);
        return new SelectLocationAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txt_location_name.setText(dataHolder.get(position).getLoactionName());

        if (selectedPosition == position)
            holder.img_select.setVisibility(View.VISIBLE);
        else
            holder.img_select.setVisibility(View.GONE);

        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPosition=position;
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_location_name;
        ImageView img_select;
        LinearLayout root;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_location_name = itemView.findViewById(R.id.txt_location_name);
            img_select = itemView.findViewById(R.id.img_select);
            root = itemView.findViewById(R.id.root);
        }
    }

    @Override
    public Filter getFilter() {
        return locationFilter;
    }

    private Filter locationFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<SearchLocationModel> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(dataHolderFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                if (filterPattern.equalsIgnoreCase("")) {
                    filteredList.addAll(dataHolderFull);
                } else {
                    for (SearchLocationModel item : dataHolderFull) {
                        if (item.getLoactionName().toLowerCase().contains(filterPattern)) {
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
