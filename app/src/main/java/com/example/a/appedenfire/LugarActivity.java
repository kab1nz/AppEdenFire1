package com.example.a.appedenfire;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.a.appedenfire.objetos.Lugar;
import com.example.a.appedenfire.objetos.LugarAdapter;
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
    private LugarAdapter lugarListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugar);
        Toolbar toolbar = findViewById(R.id.toolbarinfo);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Lugares");
        toolbar.setNavigationIcon(R.drawable.ic_flecha_izquierda);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recycler = (RecyclerView) findViewById(R.id.recyclerViewLugar);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        lugarList = new ArrayList<>();
        lugarList.add(
                new Lugar(
                        1,
                        "Las Negras",
                        "Buen sitio",
                        4.3,
                        "https://www.parquenatural.com/static/fotos/pueblos/lasnegras/800/san-pedro-las-negras-parque-natural-cabo-de-gata.jpg"));
        lugarList.add(
                new Lugar(
                        2,
                        "Arrecife de las sirenas)",
                        "Buen sitio",
                        4.3,
                        "https://photo620x400.mnstatic.com/a6bc332e330bdee6e3b668f22512c07b/arrecife-de-las-sirenas.jpg"));
        lugarList.add(
                new Lugar(
                        3,
                        "Cala San pedro",
                        "Cala San Pedro siempre fué una recóndita cala de gran belleza pero de acceso difícil, pues había que caminar un largo trecho, en el que aún se disfruta de la grandiosidad y rudeza de este territorio. Si bien ya no es tan tranquila y recóndita pues el acceso que antes era un largo paseo desde Las Negras, hoy se puede hacer en barca, que constantemente transporta gente desde las Negras a esta Cala. Presenta unas condiciones ambientales excelentes, es de aguas tranquilas y posee unos fondos marinos de gran interés para los submarinistas. En la cala existe un manantial de agua dulce y una defensa costera del XVIII. La cala está permanentemente habitada por una comunidad de personas amantes de la naturaleza, la práctica del nudismo y los lugares solitarios, si bien en Semana santa y Agosto es un destino de gente jóven que hace acampada libre, por lo que la paz y el sosiego se transforma en camping sin servicios y marchita juvenil.",
                        4.3,
                        "https://www.parquenatural.com/static/fotos/playas/calasanpedro/800/1.jpg"));
        lugarList.add(
                new Lugar(
                        4,
                        "Cala Rajá)",
                        "Buen sitio",
                        4.3,
                        "https://www.cabogataalmeria.com/img/playas/sub_calaRaja.jpg"));
        lugarList.add(
                new Lugar(
                        5,
                        "Isleta del moro)",
                        "Buen sitio",
                        4.3,
                        "http://www.weeky.es/wp-content/uploads/2014/05/IMG_6919-702x336.jpg"));
        lugarListAdapter = new LugarAdapter(this,lugarList);
        recycler.setAdapter(lugarListAdapter);


    }


    }











