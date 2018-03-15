package com.eden.a.appedenfire;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class HabitacionActivity extends AppCompatActivity {
    ImageView flecha2,imageView;
    Button btnhab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habitacion);
        imageView=findViewById(R.id.imageView6);
        flecha2=findViewById(R.id.flecha2);
        btnhab =  findViewById(R.id.btnreservahab);
        btnhab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HabitacionActivity.this,ReservaHabitacionActivity.class);
                startActivity(i);
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbarinfo4);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Habitacion");
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
