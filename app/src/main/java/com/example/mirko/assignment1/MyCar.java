package com.example.mirko.assignment1;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import android.net.Uri;
import android.widget.TextView;
import android.widget.Toast;


public class MyCar extends AppCompatActivity {

    private LocationManager locationManager;
    private LocationListener listener;
    private Button Store;
    private TextView textLocation;
    private String coordinates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_car);

        textLocation = (TextView) findViewById(R.id.txtLocation);
        Store = (Button) findViewById(R.id.btnStore);

        

        Store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri location = Uri.parse("geo:43.417010, -80.513441");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                startActivity(mapIntent);
            }
        });

    }
}
