package com.eden.a.appedenfire;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;


import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.squareup.picasso.Picasso;


public class Main2Activity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {
        String arrayName[]= {
                "Información",
                "Habitaciones",
                "Lugar de Interés",
                "Ofertas",
                "Login"
        };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar123);
        setSupportActionBar(toolbar);








                /*
        btnInicio = findViewById(R.id.btninfo1);
        btnevento=findViewById(R.id.btnevento);
        btngeleria=findViewById(R.id.btngaleria);
        btnhabi=findViewById(R.id.btnhabi);
        btninstalaciones=findViewById(R.id.btninstalaciones);
        btnlugar=findViewById(R.id.btnlugar);
        btnoferta=findViewById(R.id.btnoferta);
        btnrestaurante=findViewById(R.id.btnrestaurante);
        btnlogin=findViewById(R.id.btnlogin);
        */

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        final CircleMenu circleMenu =(CircleMenu)findViewById(R.id.circle_menu);
        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"),R.drawable.ic_add_black_24dp,R.drawable.ic_clear)
                .addSubMenu(Color.parseColor("#250CFF"),R.drawable.ic_info)
                .addSubMenu(Color.parseColor("#6d4c41"),R.drawable.ic_cama_de_matrimonio)
                .addSubMenu(Color.parseColor("#250CFF"),R.drawable.ic_herramienta_de_punto_de_aguja_para_mapas)
                .addSubMenu(Color.parseColor("#FF0000"),R.drawable.ic_alerta_simbolo_dibujado_a_mano)
                .addSubMenu(Color.parseColor("#1a237e"),R.drawable.ic_user)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int i) {

                        switch (i){
                            case 0:
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent a = new Intent(Main2Activity.this,InicioActivity.class);
                                        startActivity(a);
                                    }
                                },960);

                                break;
                            case 1:

                                Handler handler1 = new Handler();
                                handler1.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent b = new Intent(Main2Activity.this,HabitacionActivity.class);
                                        startActivity(b);
                                    }
                                },960);

                                break;
                            case 2:

                                Handler handler2 = new Handler();
                                handler2.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent c = new Intent(Main2Activity.this,LugarActivity.class);
                                        startActivity(c);
                                    }
                                },960);

                                break;
                            case 3:

                                Handler handler3 = new Handler();
                                handler3.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent d = new Intent(Main2Activity.this,OfertaActivity.class);
                                        startActivity(d);
                                    }
                                },960);

                                break;
                            case 4:


                                Handler handler4 = new Handler();
                                handler4.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent e = new Intent(Main2Activity.this,LoginActivity.class);
                                        startActivity(e);
                                    }
                                },960);

                                break;

                        }
                    }
                });
        circleMenu.openMenu();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void displaySelectedScreen(int id){

    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id){
            case R.id.nav_info:
                Intent h = new Intent(Main2Activity.this,InicioActivity.class);
                startActivity(h);
                break;
            case R.id.nav_eventos:
                Intent a = new Intent(Main2Activity.this,EventosActivity.class);
                startActivity(a);
                break;
            case R.id.nav_habitacion:
                Intent ha = new Intent(Main2Activity.this,HabitacionActivity.class);
                startActivity(ha);
                break;
            case R.id.nav_instalaciones:
                Intent haa = new Intent(Main2Activity.this,InstalacionServiciosActivity.class);
                startActivity(haa);
                break;
            case R.id.nav_restaurante:
                Intent ee = new Intent(Main2Activity.this,RestauranteActivity.class);
                startActivity(ee);
                break;
            case R.id.nav_oferta:
                Intent he = new Intent(Main2Activity.this,OfertaActivity.class);
                startActivity(he);
                break;

            case R.id.nav_lugar:
                Intent haee = new Intent(Main2Activity.this,LugarActivity.class);
                startActivity(haee);
                break;


        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
