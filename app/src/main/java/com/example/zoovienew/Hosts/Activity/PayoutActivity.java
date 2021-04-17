package com.example.zoovienew.Hosts.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.zoovienew.R;

public class PayoutActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView btnBack;
    Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payout);
        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);
        btnContinue = findViewById(R.id.btn_continue);
        btnContinue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_back){
            Intent intent = new Intent(PayoutActivity.this, HostHomePageActivity.class);
            startActivity(intent);
        }
        else if (v.getId() == R.id.btn_continue){
            Intent intent = new Intent(PayoutActivity.this, HostHomePageActivity.class);
            startActivity(intent);
        }

    }
}