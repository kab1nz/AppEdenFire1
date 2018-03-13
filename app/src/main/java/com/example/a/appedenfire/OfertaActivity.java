package com.example.a.appedenfire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class OfertaActivity extends AppCompatActivity {
    Button btnreserva;
    ImageView flecha5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oferta);
        btnreserva = (Button)findViewById(R.id.btnreserva);
        Toolbar toolbar = findViewById(R.id.toolbarinfo5);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Oferta");
        toolbar.setNavigationIcon(R.drawable.ic_flecha_izquierda);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnreserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OfertaActivity.this,ReservaOfertaActivity.class);
                startActivity(i);
            }
        });
    }
}
