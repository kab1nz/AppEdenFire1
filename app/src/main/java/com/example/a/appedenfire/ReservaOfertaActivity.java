package com.example.a.appedenfire;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;


import com.example.a.appedenfire.objetos.FireBaseReferences;
import com.example.a.appedenfire.objetos.Habitacion;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ReservaOfertaActivity extends AppCompatActivity {
    ImageView flecha6;
    private static final String TAG = "NewPostActivity";
    private static final String REQUIRED = "Required";

    // [START declare_database_ref]
    private DatabaseReference mDatabase;
    // [END declare_database_ref]

    private EditText etnombre,etape,ettel,etmail,etfentrada,etfsalida,etnhabi;
    private FloatingActionButton mSubmitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservaoferta);
        flecha6=findViewById(R.id.flecha9);
        etnombre=findViewById(R.id.etnombre);
        etape=findViewById(R.id.etapellio);
        ettel=findViewById(R.id.ettele);
        etmail=findViewById(R.id.etemail);
        etfentrada=findViewById(R.id.etfentrada);
        etfsalida=findViewById(R.id.etfsalida);
        etnhabi=findViewById(R.id.nhabitacio);
        mSubmitButton=findViewById(R.id.faboferta);
        flecha6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitPost();
                onBackPressed();
            }
        });



    }

    private void submitPost() {

        final String nombre = etnombre.getText().toString();
        final String apellido = etape.getText().toString();
        final String email = etmail.getText().toString();
        final String fechaentrada = etfentrada.getText().toString();
        final String fechasalida = etfsalida.getText().toString();
        final int nhabitaciones = Integer.valueOf(etnhabi.getText().toString());
        final int precio = nhabitaciones*50;
        String tipo="estandar";
        int reserva=0;
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //seguir por aqui ******************************
        Habitacion habitacion = new Habitacion(nombre,apellido,email,fechaentrada,fechasalida,nhabitaciones,precio,tipo,reserva);
        DatabaseReference myRef = database.getReference(FireBaseReferences.NOMBRE_REFERENCIAR);
        myRef.child(FireBaseReferences.RESERVA_REFERENCIAR).push().setValue(habitacion);

    }
}
