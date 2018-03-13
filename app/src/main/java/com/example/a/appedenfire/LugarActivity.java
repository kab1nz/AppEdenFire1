package com.example.a.appedenfire;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.a.appedenfire.objetos.Lugar;
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

        RecyclerView recycler = (RecyclerView) findViewById(R.id.recyclerViewLugar);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        lugarList = new ArrayList<>();
        lugarList.add(
                new Lugar(
                        1,
                        "Las Negras)",
                        "Buen sitio",
                        4.3,
                        R.drawable.lasnegras));
        lugarList.add(
                new Lugar(
                        1,
                        "Las Negras)",
                        "Buen sitio",
                        4.3,
                        R.drawable.lasnegras));
        lugarList.add(
                new Lugar(
                        1,
                        "Las Negras)",
                        "Buen sitio",
                        4.3,
                        R.drawable.lasnegras));
        lugarList.add(
                new Lugar(
                        1,
                        "Las Negras)",
                        "Buen sitio",
                        4.3,
                        R.drawable.lasnegras));
        lugarList.add(
                new Lugar(
                        1,
                        "Las Negras)",
                        "Buen sitio",
                        4.3,
                        R.drawable.lasnegras));
        recycler.setAdapter(lugarListAdapter);


    }


    }











