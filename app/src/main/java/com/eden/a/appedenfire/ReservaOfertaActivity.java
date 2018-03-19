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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;


import com.eden.a.appedenfire.objetos.FireBaseReferences;
import com.eden.a.appedenfire.objetos.Habitacion;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReservaOfertaActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "Firebase -->";
    EditText etnombre,ettel,etapellido,etnhab,etemail;
   static int precio = 45;
    int dias;
    Date fechaInicial,fechaFinal;
    FloatingActionButton fab;
    Calendar dateEntrada ;
    Calendar dateSalida ;
    private int dia,mes,anio;
    private int dia1,mes1,anio1;
    EditText fentrada,fsalida;
    private FirebaseFirestore firebaseFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservaoferta);
        etnombre=findViewById(R.id.etnombre);
        ettel=findViewById(R.id.ettele);

        etapellido=findViewById(R.id.etapellio);
        etnhab=findViewById(R.id.nhabitacio);
        etemail=findViewById(R.id.etemail);
        fab=findViewById(R.id.fabicon);
        Toolbar toolbar = findViewById(R.id.toolbarinfo);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Reserva Oferta Habitación");
        toolbar.setNavigationIcon(R.drawable.ic_flecha_izquierda);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fentrada = (EditText) findViewById(R.id.etfentrada1);
        fsalida=   (EditText) findViewById(R.id.etfsalida1);

        fentrada.setOnClickListener(this);
        fsalida.setOnClickListener(this);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    submitPost();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                onBackPressed();

            }
        });

    }

    private void submitPost() throws ParseException {
        boolean bandera = true;

        final String nombre = etnombre.getText().toString();
        final String apellido = etapellido.getText().toString();
        final String email = etemail.getText().toString();
        final String fechaentrada = fentrada.getText().toString();
        final String fechasalida = fsalida.getText().toString();
        int nhabitaciones=0;
        try{

            nhabitaciones = Integer.valueOf(etnhab.getText().toString());
            if(nhabitaciones==0 || nhabitaciones <0 ){
                bandera=false;
                Toast.makeText(getApplicationContext(), "Nº Habitación invalido", Toast.LENGTH_LONG).show();
                etnombre.setText("");
                etapellido.setText("");
                etemail.setText("");
                fentrada.setText("");
                fsalida.setText("");
                etnhab.setText("");
                precio = 0;

            }
        }catch(NumberFormatException ex){ // handle your exception
        }
        String tipo = "estandar";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        fechaInicial=dateFormat.parse(fechaentrada);
        fechaFinal=dateFormat.parse(fechasalida);
        long diffTime = fechaFinal.getTime() - fechaInicial.getTime();
        long diffDays = diffTime / (1000 * 60 * 60 * 24);
        dias = (int) diffDays;
        precio=45*nhabitaciones*dias;
        Habitacion com = new Habitacion();
        bandera = com.comprobarCampos(nombre, apellido, email, fechaentrada, fechasalida, nhabitaciones, precio, tipo);
        if (bandera == true) {
            Toast.makeText(getApplicationContext(),"Reserva enviada correctamente",Toast.LENGTH_LONG).show();

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

        } else {
            Toast.makeText(getApplicationContext(), "Campos nulos", Toast.LENGTH_LONG).show();
            etnombre.setText("");
            etapellido.setText("");
            etemail.setText("");
            fentrada.setText("");
            fsalida.setText("");
            etnhab.setText("");
            precio = 0;
            bandera=false;
        }
    }

    @Override
    public void onClick(View v) {

        if(v==fentrada){
            dateEntrada = Calendar.getInstance();
            dia=dateEntrada.get(Calendar.DAY_OF_MONTH);
            mes=dateEntrada.get(Calendar.MONTH+1);
            anio=dateEntrada.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(ReservaOfertaActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    fentrada.setText(year +"/"+ (month+1)+"/" +dayOfMonth);
                    dia=dayOfMonth;
                    mes=month+1;
                    anio=year;
                }
            }
                    ,dia,mes,anio);
            datePickerDialog.show();
            datePickerDialog.updateDate(2018,3,17);



        }
        if(v==fsalida){
            dateSalida = Calendar.getInstance();
            dia1=dateSalida.get(Calendar.DAY_OF_MONTH);
            mes1=dateSalida.get(Calendar.MONTH+1);
            anio1=dateSalida.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(ReservaOfertaActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    dia1=dayOfMonth;
                    mes1=month+1;
                    anio1=year;
                    fsalida.setText(year +"/"+ (month+1)+"/" +dayOfMonth);
                }
            }
                    ,dia1,mes1,anio1);
            datePickerDialog.show();
            datePickerDialog.updateDate(2018,3,17);

        }

    }
}


