package com.example.mirko.assignment1;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.net.Uri;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MyCar extends AppCompatActivity implements LocationListener {

    private LocationManager locationManager;
    private LocationListener listener;
    private Button Store;
    private TextView textLocation;
    private String coordinates;
    private String [] pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_car);

        textLocation = (TextView) findViewById(R.id.txtLocation);
        Store = (Button) findViewById(R.id.btnStore);

        final ListView lv = (ListView) findViewById(R.id.myList1);
        pages = new String[]{"Canadian tire","Walmart", "Part source"};
        final List<String> MyList1 = new ArrayList<String>(Arrays.asList(pages));
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MyList1);
        lv.setAdapter(arrayAdapter);

        Store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri location = Uri.parse("geo:43.417010, -80.513441");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                startActivity(mapIntent);

            }
        });
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                2000,
                10, this);


    }

    @Override
    public void onLocationChanged(Location location) {
        String locMsg = "New Latitude: " + location.getLatitude()
                + "New Longitude: " + location.getLongitude();
        textLocation = (TextView) findViewById(R.id.txtLocation);
        Toast.makeText(getBaseContext(), locMsg, Toast.LENGTH_LONG).show();
        textLocation.setText(locMsg);
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {
        Toast.makeText(getBaseContext(), "Gps is turned on ",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderDisabled(String s) {
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        startActivity(intent);
        Toast.makeText(getBaseContext(), "Gps is turned off ",
                Toast.LENGTH_SHORT).show();
    }
}
