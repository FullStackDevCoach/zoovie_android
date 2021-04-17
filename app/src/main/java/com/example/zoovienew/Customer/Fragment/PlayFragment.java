package com.example.zoovienew.Customer.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.zoovienew.Customer.Activity.FragViewerActivity;
import com.example.zoovienew.Customer.Adapter.PlayTicketDetailAdapter;
import com.example.zoovienew.Customer.Model.PlayTicketModel;
import com.example.zoovienew.R;
import com.example.zoovienew.databinding.FragmentPlayBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;


public class PlayFragment extends Fragment implements View.OnClickListener {
    private FragmentPlayBinding binding;
    ArrayList<PlayTicketModel> dataHolder;
    BottomSheetDialog bottomSheerDialog;
    Button btn;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPlayBinding.inflate(getLayoutInflater());
        binding.ivChat.setOnClickListener(this);

        binding.rvPlay.setLayoutManager(new LinearLayoutManager(getContext()));

        dataHolder = new ArrayList<>();
        dataHolder.add( new PlayTicketModel("Rufaro"));
        dataHolder.add( new PlayTicketModel("Rufaro"));
        dataHolder.add( new PlayTicketModel("Rufaro"));
        dataHolder.add( new PlayTicketModel("Rufaro"));
        dataHolder.add( new PlayTicketModel("Rufaro"));
        dataHolder.add( new PlayTicketModel("Rufaro"));
        binding.rvPlay.setAdapter(new PlayTicketDetailAdapter(dataHolder, getActivity(), new PlayTicketDetailAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(int position) {
                bottomSheerDialog = new BottomSheetDialog(getContext());
                View parentView = getLayoutInflater().inflate(R.layout.dialog_bottom_buy_ticket,null);
                bottomSheerDialog.setContentView(parentView);
                bottomSheerDialog.show();

                btn = parentView.findViewById(R.id.btn_dialog_bottom_order_now);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(),"button clicked",Toast.LENGTH_LONG).show();
                        bottomSheerDialog.dismiss();
                    }
                });

            }

            @Override
            public void onLikeClickListener(int position) {
               /* binding.ivLikeVenueDetail1.setImageResource(R.drawable.ic_like_filled);
                binding.ivLikeVenueDetail1.setColorFilter(getResources().getColor(R.color.bn_color_red));*/
            }

            @Override
            public void onCommentClickListener(int position) {
                Intent intent = new Intent(getActivity(), FragViewerActivity.class);
                intent.putExtra("FragmentViewer","CommentsFragment");
                startActivity(intent);
            }

            @Override
            public void onShareClickListener(int position) {
                Toast.makeText(getContext(), "Share Clicked", Toast.LENGTH_LONG).show();
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Your body here";
                String shareSub = "Your subject here";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
            }
        }));

        return binding.getRoot();
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_chat){
            Intent intent = new Intent(getActivity(), FragViewerActivity.class);
            intent.putExtra("FragmentViewer", "MessageFragment");
            startActivity(intent);

        }
    }
}