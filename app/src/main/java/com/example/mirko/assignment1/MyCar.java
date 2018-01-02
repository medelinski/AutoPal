package com.example.mirko.assignment1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import android.net.Uri;


public class MyCar extends AppCompatActivity {

    private Button Download;
    private Button Website;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_car);

        Download = (Button)findViewById(R.id.btnDownload);
        Website = (Button)findViewById(R.id.btnWebsite);

        Website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("https://developer.android.com/training/data-storage/files.html");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
            }
        });

        Download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String FILENAME = "car_pic.xml";
                try {
                    URL url = new URL("http://www.fram.com/find-retailers/");
                    InputStream input = url.openStream();

                    FileOutputStream output = openFileOutput(FILENAME, Context.MODE_PRIVATE);

                    byte[] buffer = new byte[1024];
                    int bytesRead = input.read(buffer);
                    while (bytesRead != 1) {
                        output.write(buffer, 0, bytesRead);
                        bytesRead = input.read(buffer);
                    }
                    output.close();


                }
                catch (IOException e){
                    Log.e("Car pic", e.toString());
                }
            }
        });


    }
}
