package com.example.a.appedenfire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        flecha5=findViewById(R.id.flecha5);
        flecha5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btnreserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OfertaActivity.this,ReservaOfertaActivity.class);
                startActivity(i);
            }
        });
    }
}
