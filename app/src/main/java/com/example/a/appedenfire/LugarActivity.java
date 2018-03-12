package com.example.a.appedenfire;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.a.appedenfire.objetos.Habitacion;
import com.example.a.appedenfire.objetos.Lugar;
import com.example.a.appedenfire.objetos.LugarListAdapter;
import com.example.a.appedenfire.objetos.ReservaListAdapter;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class LugarActivity extends AppCompatActivity {
    private static final String TAGLOG ="Firebase -->" ;
    private List<Lugar> lugarList;
    private ReservaListAdapter lugarListAdapter;
    private FirebaseFirestore firebaseFirestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugar);
        Toolbar toolbar = findViewById(R.id.toolbarinfo);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Información");
        toolbar.setNavigationIcon(R.drawable.ic_flecha_izquierda);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lugarList = new ArrayList<>();
        final LugarListAdapter lugarListAdapter = new LugarListAdapter(getApplicationContext(), lugarList);

        RecyclerView recycler = (RecyclerView) findViewById(R.id.recyclerViewLugar);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(lugarListAdapter);
        firebaseFirestore= FirebaseFirestore.getInstance();
        firebaseFirestore.collection("Lugar").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                if(e!=null){
                    Log.d(TAGLOG,"Error: "+e.getMessage());
                }

                for (DocumentChange doc : documentSnapshots.getDocumentChanges()){

                    if(doc.getType()==DocumentChange.Type.ADDED){
                        String userId = doc.getDocument().getId();

                        Lugar hab = doc.getDocument().toObject(Lugar.class).widthId(userId);

                        lugarList.add(hab);
                        lugarListAdapter.notifyDataSetChanged();
                    }

                }


            }
        });

    }
}
