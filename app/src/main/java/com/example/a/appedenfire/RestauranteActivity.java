package com.example.a.appedenfire;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class RestauranteActivity extends AppCompatActivity {
    ImageView flecha7 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante);
        Toolbar toolbar = findViewById(R.id.toolbarinfo7);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Información");
        toolbar.setNavigationIcon(R.drawable.ic_flecha_izquierda);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
