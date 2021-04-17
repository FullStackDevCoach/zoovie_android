package com.example.zoovienew.Hosts.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zoovienew.Customer.Adapter.HomeHostsAdapter;
import com.example.zoovienew.Customer.Model.HostModel;
import com.example.zoovienew.Hosts.Model.TransactionModel;
import com.example.zoovienew.R;

import java.util.ArrayList;

public class TransactionDetailsAdapter extends RecyclerView.Adapter<TransactionDetailsAdapter.MyViewHolder>{
    ArrayList<TransactionModel> dataHolder;
    private Context mContext ;

    public TransactionDetailsAdapter(ArrayList<TransactionModel> dataHolder, Context mContext) {
        this.dataHolder = dataHolder;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_transaction_brief,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       holder.transactionAmount.setText(dataHolder.get(position).getTransactionAmount());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView transactionAmount;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            transactionAmount = itemView.findViewById(R.id.tv_transaction_amount);
        }
    }
}
