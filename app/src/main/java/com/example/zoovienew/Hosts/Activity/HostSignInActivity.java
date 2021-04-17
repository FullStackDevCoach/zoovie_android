package com.example.zoovienew.Hosts.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zoovienew.Customer.Activity.HomePageActivity;
import com.example.zoovienew.Customer.Activity.SignInActivity;
import com.example.zoovienew.Hosts.Fragment.HostForgotPasswordFragment;
import com.example.zoovienew.R;

public class HostSignInActivity extends AppCompatActivity implements View.OnClickListener {
    Button login;
    LinearLayout signUp;
    ImageView btnBack;
    TextView forgotPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_sign_in);
        login = findViewById(R.id.btn_login);
        signUp = findViewById(R.id.ll_sign_up);
        btnBack = findViewById(R.id.btn_back);
        forgotPassword = findViewById(R.id.tv_forgot_password);
        forgotPassword.setOnClickListener(this);
        login.setOnClickListener(this);
        signUp.setOnClickListener(this);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_login){
            Intent intent = new Intent(HostSignInActivity.this, HostHomePageActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            overridePendingTransition(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        }
        else if (v.getId() == R.id.btn_back){
            Intent intent = new Intent(HostSignInActivity.this, HostHomePageActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            overridePendingTransition(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        }
        else if (v.getId() == R.id.ll_sign_up){
            Intent intent = new Intent(HostSignInActivity.this, HostSignUpActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            overridePendingTransition(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        }
        else if (v.getId() == R.id.tv_forgot_password){
            getSupportFragmentManager().beginTransaction().replace(R.id.host_sign_in_fragment_container, new HostForgotPasswordFragment()).commit();
        }

    }
}