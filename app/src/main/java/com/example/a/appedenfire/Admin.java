package com.example.a.appedenfire;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.a.appedenfire.objetos.Habitacion;
import com.example.a.appedenfire.objetos.PeticionesFirebase;
import com.example.a.appedenfire.objetos.ReservaListAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Admin extends AppCompatActivity implements PeticionesFirebase{
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

        //Email
        //Resol

        String correousuario = reservaList.get(pos).getEmail();
        String nombreusuario = reservaList.get(pos).getNombre();

        Properties properties = new Properties();
        properties.put("mail.smtp.host","smtp.googlemail.com");
        properties.put("mail.smtp.socketFactory.port","465");
        properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLocketFactory");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.port","465");
        final String correo="kabinfor@gmail.com";
        final String contra="colorin69";
        final String mensaje ="Buenas : "+nombreusuario + "su reserva ha sido aceptada.";
        try{
            session=Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(correo,contra);
                }
            });
            if(session!=null){
                javax.mail.Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(correo));
                message.setSubject("Reserva Hotel EL EDEN");
                message.setRecipients(javax.mail.Message.RecipientType.TO,InternetAddress.parse(correousuario));
                message.setContent(mensaje,"text/html; charset=utf-8");
                Transport.send(message);
            }
        }catch (Exception e){

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
}
