package com.example.a.appedenfire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnInicio, btnevento, btngeleria, btnhabi, btninstalaciones, btnlugar, btnoferta, btnrestaurante;
    ImageView btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        btnInicio = findViewById(R.id.btninfo1);
        btnInicio.setOnClickListener(this);
        btnevento=findViewById(R.id.btnevento);
        btngeleria=findViewById(R.id.btngaleria);
        btnhabi=findViewById(R.id.btnhabi);
        btninstalaciones=findViewById(R.id.btninstalaciones);
        btnlugar=findViewById(R.id.btnlugar);
        btnoferta=findViewById(R.id.btnoferta);
        btnrestaurante=findViewById(R.id.btnrestaurante);
        btnlogin=findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent e = new Intent(MainActivity.this,Admin.class);
            startActivity(e);
            }
        });
        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e = new Intent(MainActivity.this,InicioActivity.class);
                startActivity(e);
            }
        });
        btnevento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e = new Intent(MainActivity.this,EventosActivity.class);
                startActivity(e);
            }
        });
        btngeleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e = new Intent(MainActivity.this,InicioActivity.class);
                startActivity(e);
            }
        });
        btnhabi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e = new Intent(MainActivity.this,HabitacionActivity.class);
                startActivity(e);
            }
        });
        btninstalaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e = new Intent(MainActivity.this,InstalacionServiciosActivity.class);
                startActivity(e);
            }
        });
        btnlugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e = new Intent(MainActivity.this,LugarActivity.class);
                startActivity(e);
            }
        });
        btnoferta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e = new Intent(MainActivity.this,OfertaActivity.class);
                startActivity(e);
            }
        });
        btnrestaurante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e = new Intent(MainActivity.this,RestauranteActivity.class);
                startActivity(e);
            }
        });
    }
*/

/*
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btninfo1:
                Intent i = new Intent(MainActivity.this,InicioActivity.class);
                startActivity(i);
                break;
            case R.id.btnevento:
                Intent e = new Intent(MainActivity.this,EventosActivity.class);
                startActivity(e);
                break;
            case R.id.btngaleria:
                Intent g = new Intent(MainActivity.this,InicioActivity.class);
                startActivity(g);
                break;
            case R.id.btnhabi:
                Intent h = new Intent(MainActivity.this,HabitacionActivity.class);
                startActivity(h);
                break;
            case R.id.btninstalaciones:
                Intent info = new Intent(MainActivity.this,InstalacionServiciosActivity.class);
                startActivity(info);
                break;
            case R.id.btnlugar:
                Intent lu = new Intent(MainActivity.this,LugarActivity.class);
                startActivity(lu);
                break;
            case R.id.btnoferta:
                Intent ofe = new Intent(MainActivity.this,OfertaActivity.class);
                startActivity(ofe);
                break;

            case R.id.btnrestaurante:
                Intent res = new Intent(MainActivity.this,RestauranteActivity.class);
                startActivity(res);
                break;
        }

    }
     */
    }

    @Override
    public void onClick(View view) {

    }
}