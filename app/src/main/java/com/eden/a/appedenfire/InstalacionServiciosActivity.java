package com.eden.a.appedenfire;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class InstalacionServiciosActivity extends AppCompatActivity {
    ImageView flecha3;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instalacionesservicios);
        Toolbar toolbar = findViewById(R.id.toolbarinfo);
        imageView=findViewById(R.id.imageView25);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Instalación y Servicios");
        toolbar.setNavigationIcon(R.drawable.ic_flecha_izquierda);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

