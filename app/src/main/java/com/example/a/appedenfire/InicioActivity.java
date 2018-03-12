package com.example.a.appedenfire;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.ImageView;
import android.support.v7.widget.Toolbar;

public class InicioActivity extends AppCompatActivity {
    ImageView flechainfo;
    Toolbar toolbar;

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


    }
}


