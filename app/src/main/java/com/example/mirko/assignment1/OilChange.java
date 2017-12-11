package com.example.mirko.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.view.Menu;
import android.widget.Button;



public class OilChange extends AppCompatActivity {

    private Button Save;
    private Button Search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oil_change);

        Save = (Button)findViewById(R.id.btnSave2);
        Search = (Button)findViewById(R.id.btnSearchOil);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (OilChange.this,MyCar.class);
                startActivity(intent);
            }
        });
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (OilChange.this,OilResults.class);
                startActivity(intent);
            }
        });



    }

}
