package com.eden.a.appedenfire;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


import com.eden.a.appedenfire.objetos.Habitacion;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class ReservaHabitacionActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "Firebase -->";
    EditText etnombre,ettel,etapellido,etnhab,etemail;
    RadioButton cbsuite,cbgeneral,cbestandar;
    FloatingActionButton fab;
    Calendar dateEntrada ;
    Calendar dateSalida ;
    int precio = 0;
    Long milisSalida,milisEntrada;
    private int dia,mes,anio;
    EditText fentrada,fsalida;
    private FirebaseFirestore firebaseFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityreservahabitacion);
        etnombre=findViewById(R.id.etnombre);
        ettel=findViewById(R.id.ettele);

        etapellido=findViewById(R.id.etapellio);
        etnhab=findViewById(R.id.nhabitacio);
        cbsuite=findViewById(R.id.rbsuite);
        cbgeneral=findViewById(R.id.rbgeneral);
        cbestandar=findViewById(R.id.rbEstandar);
        etemail=findViewById(R.id.etemail);
        fab=findViewById(R.id.fab);
        Toolbar toolbar = findViewById(R.id.toolbarinfo6);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Reserva Habitación");
        toolbar.setNavigationIcon(R.drawable.ic_flecha_izquierda);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fentrada = (EditText) findViewById(R.id.etfentrada);
        fsalida=   (EditText) findViewById(R.id.etfsalida1);
        fentrada.setOnClickListener(this);
        fsalida.setOnClickListener(this);



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            submitPost();
            onBackPressed();

            }
        });

    }

    private void submitPost() {
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
        String tipo = "";
        int diass =0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

        if (cbestandar.isChecked()) {
            precio = 75 * nhabitaciones*diass;
            tipo = "estandar";


        }
        if (cbgeneral.isChecked()) {
            precio = 90 * nhabitaciones*diass;
            tipo = "general";

        }
        if (cbsuite.isChecked()) {
            precio = 150 * nhabitaciones*diass;
            tipo = "suite";

        }
        Habitacion com = new Habitacion();
        bandera = com.comprobarCampos(nombre, apellido, email, fechaentrada, fechasalida, nhabitaciones, precio, tipo);
        if (bandera == true) {

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
            Log.d(TAG,"Numero de dias: "+diass);
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

            DatePickerDialog datePickerDialog = new DatePickerDialog(ReservaHabitacionActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    fentrada.setText(dayOfMonth +"/"+ (month+1)+" /" +year);
                }
            }
            ,dia,mes,anio);
            System.currentTimeMillis();
            datePickerDialog.show();
            Calendar calendar = new GregorianCalendar(anio,mes,dia);
             milisEntrada = calendar.getTimeInMillis();
        }
        if(v==fsalida){
             dateSalida = Calendar.getInstance();
            dia=dateSalida.get(Calendar.DAY_OF_MONTH);
            mes=dateSalida.get(Calendar.MONTH+1);
            anio=dateSalida.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(ReservaHabitacionActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    fsalida.setText(dayOfMonth +"/"+ (month+1)+" /" +year);
                }
            }
                ,dia,mes,anio);
            datePickerDialog.show();
            Calendar calendar = new GregorianCalendar(anio,mes,dia);
             milisSalida = calendar.getTimeInMillis();
        }
    }

    public long getDiferencia(Date fechaInicial, Date fechaFinal){

        long diferencia = fechaFinal.getTime() - fechaInicial.getTime();

        Log.i("MainActivity", "fechaInicial : " + fechaInicial);
        Log.i("MainActivity", "fechaFinal : " + fechaFinal);

        long segsMilli = 1000;
        long minsMilli = segsMilli * 60;
        long horasMilli = minsMilli * 60;
        long diasMilli = horasMilli * 24;

        long diasTranscurridos = diferencia / diasMilli;
        diferencia = diferencia % diasMilli;



        return diasTranscurridos;


    }
}
