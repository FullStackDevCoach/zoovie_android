package com.example.zoovienew.Customer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zoovienew.Customer.Model.HostModel;
import com.example.zoovienew.Customer.Model.PlayTicketModel;
import com.example.zoovienew.R;
import com.example.zoovienew.databinding.ItemBookTicketDetailsBinding;

import java.util.ArrayList;

public class PlayTicketDetailAdapter extends RecyclerView.Adapter<PlayTicketDetailAdapter.MyViewHolder>{
    ArrayList<PlayTicketModel> dataHolder;
    private Context mContext ;
    private OnItemClickListener onItemClickListener;

    public PlayTicketDetailAdapter(ArrayList<PlayTicketModel> dataHolder, Context context, OnItemClickListener onItemClickListener) {
        this.dataHolder = dataHolder;
        mContext = context;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_ticket_details,parent,false);
        return new MyViewHolder(view);*/

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemBookTicketDetailsBinding itemCartBinding = ItemBookTicketDetailsBinding.inflate(layoutInflater, parent, false);
        return new MyViewHolder(itemCartBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(dataHolder.get(position), mContext, onItemClickListener);
       // holder.profileName.setText(dataHolder.get(position).getProfileName());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        private ItemBookTicketDetailsBinding binding;
        public MyViewHolder(ItemBookTicketDetailsBinding itemBookTicketDetailsBinding) {
            super(itemBookTicketDetailsBinding.getRoot());
            this.binding = itemBookTicketDetailsBinding;
        }



        public void bind(PlayTicketModel playTicketModel, Context mContext, OnItemClickListener onItemClickListener) {
            final int[] likeValue = {1};
            binding.tvProfileName.setText(playTicketModel.getProfileName());
            binding.btnTicketPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClickListener(getAdapterPosition());
                }
            });
            binding.llLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (likeValue[0] ==1){
                        binding.likePlay.setImageResource(R.drawable.ic_like_filled);
                        likeValue[0] =2;
                    }else {
                        binding.likePlay.setImageResource(R.drawable.ic_like);
                        likeValue[0]=1;
                    }
                    onItemClickListener.onLikeClickListener(getAdapterPosition());
                }
            });

            binding.llCommentPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onCommentClickListener(getAdapterPosition());
                }
            });

            binding.llSharePlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onShareClickListener(getAdapterPosition());
                }
            });

        }
    }

    public interface OnItemClickListener {
        void onItemClickListener(int position);

        void onLikeClickListener(int position);

        void onCommentClickListener(int position);

        void onShareClickListener(int position);
    }
}
