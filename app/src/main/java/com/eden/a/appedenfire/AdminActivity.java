package com.eden.a.appedenfire;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;


import com.eden.a.appedenfire.objetos.Habitacion;
import com.eden.a.appedenfire.objetos.PeticionesFirebase;
import com.eden.a.appedenfire.objetos.ReservaListAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import javax.mail.Session;

public class AdminActivity extends AppCompatActivity implements PeticionesFirebase{
    private static final String TAGLOG = "firebase-db ->";
    private List<Habitacion>reservaList;
    private ReservaListAdapter reservaListAdapter;
    private FirebaseFirestore firebaseFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainadmin);

        reservaList = new ArrayList<>();
        reservaListAdapter = new ReservaListAdapter(getApplicationContext(),reservaList,this);

        RecyclerView recycler = (RecyclerView) findViewById(R.id.listaReservas);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(reservaListAdapter);
        firebaseFirestore= FirebaseFirestore.getInstance();
        firebaseFirestore.collection("Eden").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                if(e!=null){
                    Log.d(TAGLOG,"Error: "+e.getMessage());
                }

                for (DocumentChange doc : documentSnapshots.getDocumentChanges()){

                    if(doc.getType()==DocumentChange.Type.ADDED){
                    String userId = doc.getDocument().getId();

                    Habitacion hab = doc.getDocument().toObject(Habitacion.class).widthId(userId);

                    reservaList.add(hab);
                    reservaListAdapter.notifyDataSetChanged();
                    }

                }


            }
        });

        /*
        mAdapter =
            new FirebaseRecyclerAdapter<Habitacion, ReservaHolder>(
                Habitacion.class, R.layout.activity_item, ReservaHolder.class, databaseReference) {

                @Override
                protected void populateViewHolder(ReservaHolder viewHolder, Habitacion model, int position) {
                    viewHolder.setNombre(model.getNombre());
                    viewHolder.setApellido(model.getApellido());
                    viewHolder.setEmail(model.getEmail());
                    viewHolder.setFechaEntrada(model.getFechaentrada());
                    viewHolder.setFechaSalida(model.getFechaentrada());
                    viewHolder.setNhab(String.valueOf(model.getNhabitaciones()));
                    viewHolder.setPrecio(String.valueOf(model.getPrecio()));
                    viewHolder.setTipo(String.valueOf(model.getTipo()));

                }


            };

        recycler.setAdapter(mAdapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdapter.cleanup();
    }
    */
    }


    @Override
    public void aceptarReserva(String id, final int pos) {
        Session session;
        DocumentReference washingtonRef = firebaseFirestore.collection("Eden").document(id);

        washingtonRef
                .update("reserva", 1)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("firebase-->", "DocumentSnapshot reserva 1 successfully updated!");
                        reservaList.get(pos).setReserva(1);
                        reservaListAdapter.notifyDataSetChanged();


                    }
                })

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("firebase-->", "Error updating document", e);
                    }
                });




            sendEmail(pos);
    }




    protected void sendEmail(final int pos) {
        String[] TO = {reservaList.get(pos).getEmail().toString()};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
// Esto podrás modificarlo si quieres, el asunto y el cuerpo del mensaje
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "RESERVA HOTEL EL EDEN ACEPTADA");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Bienvenido al hotel EL eden " +reservaList.get(pos).getNombre().toString()+" "+reservaList.get(pos).getApellido().toString()+" su reserva " +
                "ha sido aceptada, con un total de: "+reservaList.get(pos).getPrecio()+"€, "+"fecha entrada -->"+reservaList.get(pos).getFechaentrada() + " - " +"fecha salida -->" +reservaList.get(pos).getFechasalida());

        try {
            startActivity(Intent.createChooser(emailIntent, "Enviar email..."));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(AdminActivity.this,
                "No tienes clientes de email instalados.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void rechazarReserva(String id, final int pos) {


        DocumentReference washingtonRef = firebaseFirestore.collection("Eden").document(id);

        washingtonRef
                .update("reserva", 2)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("firebase-->", "DocumentSnapshot successfully updated!");
                        reservaList.get(pos).setReserva(2);

                        reservaListAdapter.notifyDataSetChanged();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("firebase-->", "Error updating document", e);
                    }
                });
    }

    @Override
    public void cancelarReserva(String id, final int pos) {
        DocumentReference washingtonRef = firebaseFirestore.collection("Eden").document(id);

        washingtonRef
                .update("reserva", 0)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("firebase-->", "DocumentSnapshot successfully updated!");
                        reservaList.get(pos).setReserva(0);

                        reservaListAdapter.notifyDataSetChanged();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("firebase-->", "Error updating document", e);
                    }
                });
    }
    }

