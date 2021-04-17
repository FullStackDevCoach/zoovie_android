package com.example.zoovienew.Hosts.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.zoovienew.R;
import com.example.zoovienew.databinding.ActivityHostSignUpBinding;
import com.example.zoovienew.databinding.ActivitySignInBinding;

public class HostSignUpActivity extends AppCompatActivity implements View.OnClickListener{
    private ActivityHostSignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHostSignUpBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        binding.btnBack.setOnClickListener(this);
        binding.btnSignUp.setOnClickListener(this);
        binding.llLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_sign_up){
            Intent intent = new Intent(HostSignUpActivity.this, HostOTPActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            overridePendingTransition(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        }
        else if (v.getId() == R.id.btn_back){
            Intent intent = new Intent(HostSignUpActivity.this, HostSignInActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            overridePendingTransition(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        }
        else if (v.getId() == R.id.ll_login){
            Intent intent = new Intent(HostSignUpActivity.this, HostSignInActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            overridePendingTransition(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        }


    }
}