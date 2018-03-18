package com.eden.a.appedenfire;

import android.app.DatePickerDialog;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.Patterns;
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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class ReservaOfertaActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView flecha6, imageView;
    private static final String TAG = "NewPostActivity";
    private static final String REQUIRED = "Required";
    boolean bandera = true;
    Calendar dateEntrada ;
    Calendar dateSalida ;
    int precio = 0;
    Long milisSalida,milisEntrada;
    private int dia,mes,anio;
    private int dia1,mes1,anio1;
    // [START declare_database_ref]
    private DatabaseReference mDatabase;
    // [END declare_database_ref]
    EditText fentrada,fsalida;

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
                try {
                    submitPost();
                    etnombre.setText("");
                    etape.setText("");
                    etmail.setText("");
                    fentrada.setText("");
                    fsalida.setText("");
                    etnhabi.setText("");
                    ettel.setText("");
                    precio = 0;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    private void submitPost() throws ParseException {

        final String nombre = etnombre.getText().toString();
        final String apellido = etape.getText().toString();
        final String email = etmail.getText().toString();
        final String fechaentrada = fentrada.getText().toString();
        final String fechasalida = fsalida.getText().toString();
        final String telenofo = ettel.getText().toString();
        final String numerohabi=etnhabi.getText().toString();
        if(telenofo.isEmpty()){
            bandera=false;
        }
        int nhabitaciones ;
        int precio = 0;

        try {
            nhabitaciones = Integer.valueOf(etnhabi.getText().toString());

        } catch (NumberFormatException ex) { // handle your exception
        }
        String tipo = "estandar";
        validarCampos(etnombre);
        validarCampos(etape);
        validarCampos(etmail);
        validarCampos(fentrada);
        validarCampos(fsalida);
        validarCampos(ettel);
        validarCampos(etnhabi);
        int reserva = 0;
        if (validarEmail(email)){
            bandera=false;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date fechaInicial=dateFormat.parse(fechaentrada);
        Date fechaFinal=dateFormat.parse(fechasalida);


        long diffTime = fechaFinal.getTime() - fechaInicial.getTime();
        long diffDays = diffTime / (1000 * 60 * 60 * 24);
        int dias = (int) diffDays;
        Habitacion com = new Habitacion();
        int precio1=59*dias;

        bandera = com.comprobarCampos(nombre, apellido, email, fechaentrada, fechasalida, numerohabi, precio, tipo,telenofo);
        if (bandera == true) {
            FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
            Map<String, Object> data = new HashMap<>();
            data.put("nombre", nombre);
            data.put("apellido", apellido);
            data.put("email", email);
            data.put("telefono", telenofo);
            data.put("fechaentrada", fechaentrada);
            data.put("fechasalida", fechasalida);
            data.put("nhabitaciones", numerohabi);
            data.put("precio", precio1);
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
            ettel.setText("");
            precio = 0;
            bandera = false;
        }
    }

    @Override
    public void onClick(View v) {
        Calendar calendar = new GregorianCalendar(anio,mes,dia);
        Calendar calendar1 = new GregorianCalendar(anio,mes,dia);
        if(v==fentrada){
            dateEntrada = Calendar.getInstance();
            String current = DateFormat.getDateInstance(DateFormat.FULL).format(dateEntrada.getTime());
            fentrada.setText(current);
            dia=dateEntrada.get(Calendar.DAY_OF_MONTH);
            mes=dateEntrada.get(Calendar.MONTH+1);
            anio=dateEntrada.get(Calendar.YEAR);
            fentrada.getMinHeight();
            DatePickerDialog datePickerDialog = new DatePickerDialog(ReservaOfertaActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    fentrada.setText(year +"-"+ (month+1)+"-" +dayOfMonth);
                    dia=dayOfMonth;
                    mes=month+1;
                    anio=year;
                }
            }
                    ,dia,mes,anio);
            datePickerDialog.show();
           datePickerDialog.updateDate(2018,3,17);
            milisEntrada = calendar.getTimeInMillis();


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
                    fsalida.setText(year +"-"+ (month+1)+"-" +dayOfMonth);
                }
            }
                    ,dia1,mes1,anio1);
            datePickerDialog.show();
            datePickerDialog.updateDate(2018,3,17);

            milisSalida = calendar1.getTimeInMillis();
        }

    }

    private boolean validarEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }
    private void validarCampos(EditText et){
        if(et.getText().toString().isEmpty()) {
            et.setError(getString(R.string.error_campo_obligatorio));
            et.requestFocus();
        }
        return;

    }


}
