package com.example.a.appedenfire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HabitacionActivity extends AppCompatActivity {
    ImageView flecha2;
    Button btnhab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habitacion);
        flecha2=findViewById(R.id.flecha2);
        btnhab =  findViewById(R.id.btnreservahab);
        btnhab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HabitacionActivity.this,ReservaHabitacionActivity.class);
                startActivity(i);
            }
        });


        flecha2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
