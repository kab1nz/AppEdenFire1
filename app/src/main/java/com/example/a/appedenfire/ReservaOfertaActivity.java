package com.example.a.appedenfire;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.a.appedenfire.objetos.FireBaseReferences;
import com.example.a.appedenfire.objetos.Habitacion;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

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
        Toolbar toolbar = findViewById(R.id.toolbarinfo);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Información");
        toolbar.setNavigationIcon(R.drawable.ic_flecha_izquierda);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
        int nhabitaciones=0;
        int precio=0;
        try{
            nhabitaciones = Integer.valueOf(etnhabi.getText().toString());
             precio=45*nhabitaciones;

        }catch(NumberFormatException ex){ // handle your exception
        }
        String tipo = "estandar";
        int reserva = 0;
        Habitacion com = new Habitacion();
        boolean bandera = true;
        bandera = com.comprobarCampos(nombre, apellido, email, fechaentrada, fechasalida, nhabitaciones, precio, tipo);
        if (bandera == true) {
            FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
            Map<String, Object> data = new HashMap<>();
            data.put("nombre", nombre);
            data.put("apellido", apellido);
            data.put("email", email);
            data.put("fechaentrada", fechaentrada);
            data.put("fechasalida", fechasalida);
            data.put("nhabitaciones", nhabitaciones);
            data.put("precio", precio);
            data.put("tipo", tipo);
            data.put("reserva", 0);

            firebaseFirestore.collection("Eden")
                    .add(data)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Log.d(TAG, "DocumentSnapshot written with ID: " + documentReference.getId());
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Error adding document", e);
                        }
                    });


        }else{
            Toast.makeText(getApplicationContext(),"Campos nulos",Toast.LENGTH_LONG).show();
            etnombre.setText("");
            etape.setText("");
            etmail.setText("");
            etfentrada.setText("");
            etfsalida.setText("");
            etnhabi.setText("");
            precio=0;
            bandera=false;
        }
    }
}
