package com.eden.a.appedenfire;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.eden.a.appedenfire.objetos.Lugar;
import com.eden.a.appedenfire.objetos.LugarAdapter;
import com.eden.a.appedenfire.objetos.ReservaListAdapter;
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
                        "La playa de Las Negras está situada en el núcleo urbano del mismo nombre. Esta playa es muy característica por la gran cantidad de piedras de color oscuro diseminadas por la arena. La playa tiene una longitud de 850 metros, y a estar en el centro del pueblo consta con toda clase de servicios como, vigilancia costera, restauración, alojamientos, actividades turísticas. La playa es de fácil acceso, podemos aparcar el coche en una explanada del pueblo y el acceso está habilitado para personas con movilidad reducida.",
                        4.3,
                        "https://www.parquenatural.com/static/fotos/pueblos/lasnegras/800/san-pedro-las-negras-parque-natural-cabo-de-gata.jpg"));
        lugarList.add(
                new Lugar(
                        2,
                        "Arrecife de las sirenas",
                        "Este arrecife que se puede observar desde el mirador de las sirenas, junto al faro de Cabo de Gata, es una de las vistas más emblemáticas y fotografiadas del Parque. Está situado en el punto geográfico exacto del cabo de Gata, por tanto es la parte más oriental del sur de España. Seguramente el lugar debe su nombre a la presencia de focas monje que habitaban este arrecife y que los antiguos navegantes podían confundir con sirenas, actualmente ya no hay presencia de estos mamíferos en la costa de Cabo de Gata.",
                        4.2,
                        "https://photo620x400.mnstatic.com/a6bc332e330bdee6e3b668f22512c07b/arrecife-de-las-sirenas.jpg"));
        lugarList.add(
                new Lugar(
                        3,
                        "Cala San pedro",
                        "Cala San Pedro siempre fué una recóndita cala de gran belleza pero de acceso difícil, pues había que caminar un largo trecho, en el que aún se disfruta de la grandiosidad y rudeza de este territorio. Si bien ya no es tan tranquila y recóndita pues el acceso que antes era un largo paseo desde Las Negras, hoy se puede hacer en barca, que constantemente transporta gente desde las Negras a esta Cala. Presenta unas condiciones ambientales excelentes, es de aguas tranquilas y posee unos fondos marinos de gran interés para los submarinistas. En la cala existe un manantial de agua dulce y una defensa costera del XVIII. La cala está permanentemente habitada por una comunidad de personas amantes de la naturaleza, la práctica del nudismo y los lugares solitarios, si bien en Semana santa y Agosto es un destino de gente jóven que hace acampada libre, por lo que la paz y el sosiego se transforma en camping sin servicios y marchita juvenil.",
                        5.0,
                        "https://www.parquenatural.com/static/fotos/playas/calasanpedro/800/1.jpg"));
        lugarList.add(
                new Lugar(
                        4,
                        "Cala Raj)",
                        "La ubicación de esta pequeña cala, de poco mas de 120 metros de longitud, es privilegiada pues se encuentra entre la zona de especial protección marina de la Punta de Cabo de Gata y el Cerro del Vela Blanca, zona de especial protección terrestre, muy destacable es la vegetación de alrededor de esta cala, donde podemos observar la flora típica de Cabo de Gata.",
                        3.3,
                        "https://www.cabogataalmeria.com/img/playas/sub_calaRaja.jpg"));
        lugarList.add(
                new Lugar(
                        5,
                        "Isleta del moro",
                        "La Isleta del Moro es un pequeño núcleo urbano que está prácticamente rodeado por el mar por lo que en casi cualquier punto podemos encontrar una cala donde tomar un baño, la playa más grande se llama Playa del Peñón Blanco. Es una playa de 400 metros de longitud formada por arena fina y una gran calidad de agua para el baño. Recibe el nombre de una roca de color blanco que se sitúa en medio de la arena y que algunos bañistas aprovechan para resguardarse del sol.",
                        4.0,
                        "http://almeria360.com/estaticos/2015/07/Isleta-del-moro.jpg"));
        lugarListAdapter = new LugarAdapter(this,lugarList);
        recycler.setAdapter(lugarListAdapter);


    }


    }











