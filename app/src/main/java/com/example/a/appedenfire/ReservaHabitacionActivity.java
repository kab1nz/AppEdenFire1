package com.example.a.appedenfire;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;


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

public class ReservaHabitacionActivity extends AppCompatActivity {
    private static final String TAG = "Firebase -->";
    EditText etnombre,ettel,etfentrada,etfsalida,etapellido,etnhab,etemail;
    RadioButton cbsuite,cbgeneral,cbestandar;
    FloatingActionButton fab;
    private FirebaseFirestore firebaseFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityreservahabitacion);
        etnombre=findViewById(R.id.etnombre);
        ettel=findViewById(R.id.ettele);
        etfentrada=findViewById(R.id.etfentrada);
        etfsalida=findViewById(R.id.etfsalida);
        etapellido=findViewById(R.id.etapellio);
        etnhab=findViewById(R.id.nhabitacio);
        cbsuite=findViewById(R.id.rbsuite);
        cbgeneral=findViewById(R.id.rbgeneral);
        cbestandar=findViewById(R.id.rbEstandar);
        etemail=findViewById(R.id.etemail);
        fab=findViewById(R.id.fab);
        Toolbar toolbar = findViewById(R.id.toolbarinfo6);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Información");
        toolbar.setNavigationIcon(R.drawable.ic_flecha_izquierda);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            submitPost();
            onBackPressed();

            }
        });

    }
    private void submitPost() {

        final String nombre = etnombre.getText().toString();
        final String apellido = etapellido.getText().toString();
        final String email = etemail.getText().toString();
        final String fechaentrada = etfentrada.getText().toString();
        final String fechasalida = etfsalida.getText().toString();
        final int nhabitaciones = Integer.valueOf(etnhab.getText().toString());
        int precio=0;
        String tipo="";

        if (cbestandar.isChecked()){
            precio=75*nhabitaciones;
            tipo="estandar";
        }
        if(cbgeneral.isChecked()){
            precio=50*nhabitaciones;
            tipo="general";

        }
        if(cbsuite.isChecked()){
            precio=150*nhabitaciones;
            tipo="suite";

        }

        firebaseFirestore = FirebaseFirestore.getInstance();
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

    }

}
