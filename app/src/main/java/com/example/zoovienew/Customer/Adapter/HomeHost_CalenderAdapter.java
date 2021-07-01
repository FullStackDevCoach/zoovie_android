package com.example.zoovienew.Customer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zoovienew.Customer.Model.HostCalenderModel;
import com.example.zoovienew.R;

import java.util.ArrayList;

public class HomeHost_CalenderAdapter extends RecyclerView.Adapter<HomeHost_CalenderAdapter.myViewHolder> {
    ArrayList<HostCalenderModel> dataHolder;
    private Context mContext;
    private ItemSelectDateListener clickListener;

    public HomeHost_CalenderAdapter(ItemSelectDateListener clickListener, ArrayList<HostCalenderModel> dataHolder, Context context) {
        this.clickListener = clickListener;
        this.dataHolder = dataHolder;
        mContext = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_availability_calender, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.txt_month_name.setText(dataHolder.get(position).getMonth());
        holder.txt_date.setText(dataHolder.get(position).getDate());
        holder.root_calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener != null) clickListener.onDateSelect(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        TextView txt_month_name, txt_date;
        RelativeLayout root_calender;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_month_name = itemView.findViewById(R.id.txt_month_name);
            txt_date = itemView.findViewById(R.id.txt_date);
            root_calender = itemView.findViewById(R.id.root_calender);


        }

    }

    public interface ItemSelectDateListener {
        void onDateSelect(int position);
    }
}
