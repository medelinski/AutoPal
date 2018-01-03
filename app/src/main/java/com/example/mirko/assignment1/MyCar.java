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


    private Button Store;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_car);


        Store = (Button)findViewById(R.id.btnStore);


        Store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri location = Uri.parse("geo:43.417010, -80.513441");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                startActivity(mapIntent);
            }
        });
/*

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
*/


    }
}
