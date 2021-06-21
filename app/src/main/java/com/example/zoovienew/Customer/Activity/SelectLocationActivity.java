package com.example.zoovienew.Customer.Activity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.zoovienew.Customer.Adapter.SelectLocationAdapter;
import com.example.zoovienew.Customer.Model.SearchLocationModel;
import com.example.zoovienew.databinding.ActivitySelectLocationBinding;
import com.example.zoovienew.utils.LocationGetter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SelectLocationActivity extends AppCompatActivity {
    private ActivitySelectLocationBinding binding;
    ArrayList<SearchLocationModel> dataHolderLocation;
    SelectLocationAdapter selectLocationAdapter;

    private static final int REQUEST_LOCATION = 45;
    LocationManager locationManager ;
    LocationGetter locationGetter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_home_page);
        binding = ActivitySelectLocationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationGetter = new LocationGetter(this, REQUEST_LOCATION, locationManager);


        dataHolderLocation = new ArrayList<>();

        dataHolderLocation.add(new SearchLocationModel("New York", false));
        dataHolderLocation.add(new SearchLocationModel("California", false));
        dataHolderLocation.add(new SearchLocationModel("Illinois", false));
        dataHolderLocation.add(new SearchLocationModel("Texas", false));
        dataHolderLocation.add(new SearchLocationModel("Arizona", false));
        dataHolderLocation.add(new SearchLocationModel("Pennsylvania", false));
        dataHolderLocation.add(new SearchLocationModel("California", false));
        dataHolderLocation.add(new SearchLocationModel("North Carolina", false));
        dataHolderLocation.add(new SearchLocationModel("Florida", false));
        dataHolderLocation.add(new SearchLocationModel("Indiana", false));
        dataHolderLocation.add(new SearchLocationModel("Washington", false));
        dataHolderLocation.add(new SearchLocationModel("Colorado", false));
        dataHolderLocation.add(new SearchLocationModel("Michigan", false));
        dataHolderLocation.add(new SearchLocationModel("Nevada", false));
        dataHolderLocation.add(new SearchLocationModel("Virginia", false));
        dataHolderLocation.add(new SearchLocationModel("South Dakota", false));
        dataHolderLocation.add(new SearchLocationModel("Alabama", false));

        selectLocationAdapter = new SelectLocationAdapter(dataHolderLocation, this);
        binding.recyclerLocation.setAdapter(selectLocationAdapter);

        binding.searchviewLocation.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                selectLocationAdapter.getFilter().filter(newText);
                return false;
            }
        });

        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.imgDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        getTheUserPermission();

    }


    private void getTheUserPermission() {
        ActivityCompat.requestPermissions(this, new String[]
                {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            locationGetter.OnGPS();
        } else {
          binding.txtCurrentLocation.setText(locationGetter.getLocation());
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case REQUEST_LOCATION:
                {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // location-related task you need to do.
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED)
                    {

                        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                            locationGetter.OnGPS();
                        } else {
                            binding.txtCurrentLocation.setText(locationGetter.getLocation());
                        }
                    }

                }
                return;
            }
        }
    }


}



