package com.example.mirko.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import java.net.URL;
import android.net.Uri;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import android.content.Context;

public class OilResults extends AppCompatActivity {

    private Button Shop;
    private Button Image;
    ImageView imageView;
    String url = "https://s-media-cache-ak0.pinimg.com/originals/a5/ae/5e/a5ae5e908c619ddf8f29cc227cf12e5c.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oil_results);

        Shop = (Button)findViewById(R.id.btnStore);
        Image = (Button)findViewById(R.id.btnImage);

        Shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("http://www.fram.com/");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(webIntent);
            }
        });

        Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imageView = (ImageView)findViewById(R.id.imageView);
               Picasso.with(getBaseContext()).load(url).into(imageView);

            }
        });
    }


}
