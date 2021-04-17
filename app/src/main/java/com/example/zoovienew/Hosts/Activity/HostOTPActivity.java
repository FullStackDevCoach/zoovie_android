package com.example.zoovienew.Hosts.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.zoovienew.R;
import com.example.zoovienew.databinding.ActivityHostOTPBinding;
import com.example.zoovienew.databinding.ActivitySignInBinding;

public class HostOTPActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityHostOTPBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHostOTPBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        binding.btnNext.setOnClickListener(this);
        binding.btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_next){
            Intent intent = new Intent(HostOTPActivity.this, HostHomePageActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            overridePendingTransition(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        }
        else if (v.getId() == R.id.btn_back){
            Intent intent = new Intent(HostOTPActivity.this, HostHomePageActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            overridePendingTransition(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        }



    }
}