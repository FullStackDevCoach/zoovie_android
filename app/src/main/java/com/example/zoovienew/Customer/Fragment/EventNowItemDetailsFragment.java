package com.example.zoovienew.Customer.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.zoovienew.Customer.Activity.FragViewerActivity;
import com.example.zoovienew.Customer.Activity.HomePageActivity;
import com.example.zoovienew.Customer.Adapter.ProfileViewConnectAdapter;
import com.example.zoovienew.Customer.Model.ProfileModel;
import com.example.zoovienew.R;
import com.example.zoovienew.databinding.FragmentEventnowItemDetailsBinding;
import com.example.zoovienew.databinding.FragmentVenueItemDetailsBinding;

import java.util.ArrayList;

public class EventNowItemDetailsFragment extends Fragment implements View.OnClickListener{
    private FragmentEventnowItemDetailsBinding binding;
    ArrayList<ProfileModel> dataHolder;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentEventnowItemDetailsBinding.inflate(getLayoutInflater());
        binding.btnBack.setOnClickListener(this);
        binding.llLike1.setOnClickListener(this);
        binding.llLike2.setOnClickListener(this);
        binding.llComment1.setOnClickListener(this);
        binding.llComment2.setOnClickListener(this);
        binding.llShare.setOnClickListener(this);
        binding.rvProfileConnect.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        dataHolder = new ArrayList<>();
        dataHolder.add( new ProfileModel("Rufaro"));
        dataHolder.add( new ProfileModel("Rufaro"));
        dataHolder.add( new ProfileModel("Rufaro"));
        dataHolder.add( new ProfileModel("Rufaro"));

        binding.rvProfileConnect.setAdapter(new ProfileViewConnectAdapter(dataHolder, getActivity()));
        return binding.getRoot();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_ticket_play) {
            Intent intent = new Intent(getContext(), FragViewerActivity.class);
            intent.putExtra("FragmentViewer","VenueItemDetailsTicketFragment");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        else if (v.getId() == R.id.btn_back){
            Intent n1 = new Intent(getActivity(), HomePageActivity.class);
            startActivity(n1);
        }
        else if (v.getId() == R.id.ll_like_1){
            if (binding.ivLikeVenueDetail1.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.ic_like).getConstantState()){
                binding.ivLikeVenueDetail1.setImageResource(R.drawable.ic_like_filled);
            }else {
                binding.ivLikeVenueDetail1.setImageResource(R.drawable.ic_like);
            }
        }
        else if (v.getId() == R.id.ll_like_2){
            if (binding.ivLikeVenueDetail2.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.ic_like).getConstantState()){
                binding.ivLikeVenueDetail2.setImageResource(R.drawable.ic_like_filled);
            }else {
                binding.ivLikeVenueDetail2.setImageResource(R.drawable.ic_like);
            }
        }
        else if (v.getId() == R.id.ll_comment1){
            Intent intent = new Intent(getActivity(), FragViewerActivity.class);
            intent.putExtra("FragmentViewer","CommentsFragment");
            startActivity(intent);
        }
        else if (v.getId() == R.id.ll_comment2){
            Intent intent = new Intent(getActivity(), FragViewerActivity.class);
            intent.putExtra("FragmentViewer","CommentsFragment");
            startActivity(intent);
        }
        else if (v.getId() == R.id.img_share){
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Your body here";
            String shareSub = "Your subject here";
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share using"));
        }
    }
}