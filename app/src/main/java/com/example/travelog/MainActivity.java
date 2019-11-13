package com.example.travelog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {

    private FusedLocationProviderClient locationProviderClient;
    private Location currentLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        locationProviderClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location!=null)
                        {
                            currentLocation = location;
                        }
                        else
                        {
                            new AlertDialog.Builder(MainActivity.this)
                                    .setTitle("Location Issues")
                                    .setMessage(getString(R.string.locationProblem))
                                    .setPositiveButton(getString(R.string.okString), null)
                                    .setIcon(android.R.drawable.ic_dialog_info)
                                    .show();
                        }
                    }
                });
    }
}
