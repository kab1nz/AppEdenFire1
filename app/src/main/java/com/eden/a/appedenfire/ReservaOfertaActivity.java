package com.eden.a.appedenfire;

import android.app.DatePickerDialog;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.eden.a.appedenfire.objetos.Habitacion;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class ReservaOfertaActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView flecha6, imageView;
    private static final String TAG = "NewPostActivity";
    private static final String REQUIRED = "Required";
    EditText fentrada, fsalida;
    private int dia, mes, anio;

    // [START declare_database_ref]
    private DatabaseReference mDatabase;
    // [END declare_database_ref]

    private EditText etnombre, etape, ettel, etmail,  etnhabi;
    private FloatingActionButton mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservaoferta);
        flecha6 = findViewById(R.id.flecha9);
        etnombre = findViewById(R.id.etnombre);
        etape = findViewById(R.id.etapellio);
        ettel = findViewById(R.id.ettele);
        etmail = findViewById(R.id.etemail);

        etnhabi = findViewById(R.id.nhabitacio);
        mSubmitButton = findViewById(R.id.faboferta);
        Toolbar toolbar = findViewById(R.id.toolbarinfo);
        setSupportActionBar(toolbar);
        imageView = findViewById(R.id.imageView5);
        getSupportActionBar().setTitle("Reserva Oferta");
        toolbar.setNavigationIcon(R.drawable.ic_flecha_izquierda);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fentrada = (EditText) findViewById(R.id.etfentradaofer);
        fsalida = (EditText) findViewById(R.id.etfsalidaoferta);
        fentrada.setOnClickListener(this);
        fsalida.setOnClickListener(this);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;

        Picasso.get()
            .load("http://hoteleleden.es/imagenes/cabecera_entrada.jpg")
            .resize(width, 300)
            .centerCrop()
            .into(imageView);


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
        final String fechaentrada = fentrada.getText().toString();
        final String fechasalida = fsalida.getText().toString();
        int nhabitaciones = 0;
        int precio = 0;
        try {
            nhabitaciones = Integer.valueOf(etnhabi.getText().toString());
            precio = 59 * nhabitaciones;

        } catch (NumberFormatException ex) { // handle your exception
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


        } else {
            Toast.makeText(getApplicationContext(), "Campos nulos", Toast.LENGTH_LONG).show();
            etnombre.setText("");
            etape.setText("");
            etmail.setText("");
            fentrada.setText("");
            fsalida.setText("");
            etnhabi.setText("");
            precio = 0;
            bandera = false;
        }
    }

    @Override
    public void onClick(View v) {
        if (v == fentrada) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            anio = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(ReservaOfertaActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    fentrada.setText(dayOfMonth + "/" + (month + 1) + " /" + year);
                }
            }
                , dia, mes, anio);
            datePickerDialog.show();
        }
        if (v == fsalida) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            anio = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(ReservaOfertaActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    fsalida.setText(dayOfMonth + "/" + (month + 1) + " /" + year);
                }
            }
                , dia, mes, anio);
            datePickerDialog.show();
        }
    }
}

