package com.eden.a.appedenfire;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.widget.ImageView;
import android.support.v7.widget.Toolbar;

import com.squareup.picasso.Picasso;

public class EventosActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);
        toolbar = findViewById(R.id.toolbarinfo3);
        setSupportActionBar(toolbar);
        imageView=findViewById(R.id.imageView3);
        getSupportActionBar().setTitle("Eventos");
        toolbar.setNavigationIcon(R.drawable.ic_flecha_izquierda);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;

        Picasso.get()
                .load("http://hoteleleden.es/imagenes/cabecera_eventos.jpg")
                .resize(width, 300)
                .centerCrop()
                .into(imageView);
    }
    }

