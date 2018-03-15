package com.eden.a.appedenfire;


import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.Display;
import android.widget.ImageView;
import android.support.v7.widget.Toolbar;

import com.squareup.picasso.Picasso;

public class InicioActivity extends AppCompatActivity {
    ImageView flechainfo;
    Toolbar toolbar;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        toolbar = findViewById(R.id.toolbarinfo2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Información");
        toolbar.setNavigationIcon(R.drawable.ic_flecha_izquierda);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imageView=findViewById(R.id.imageView2);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;

        Picasso.get()
                .load("http://hoteleleden.es/imagenes/cabecera_banos.jpg")
                .resize(width, 300)
                .centerCrop()
                .into(imageView);


    }
}


