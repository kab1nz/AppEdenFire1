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

public class OfertaActivity extends AppCompatActivity {
    Button btnreserva;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oferta);
        btnreserva = (Button)findViewById(R.id.btnreserva);
        Toolbar toolbar = findViewById(R.id.toolbarinfo5);
        imageView=findViewById(R.id.imageView4);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Oferta");
        toolbar.setNavigationIcon(R.drawable.ic_flecha_izquierda);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;

        Picasso.get()
                .load("http://hoteleleden.es/imagenes/cabecera_habitacion.jpg")
                .resize(width, 300)
                .centerCrop()
                .into(imageView);

        btnreserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OfertaActivity.this,ReservaOfertaActivity.class);
                startActivity(i);
            }
        });
    }
}
