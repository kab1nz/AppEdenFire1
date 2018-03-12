package com.example.a.appedenfire;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

import com.example.a.appedenfire.Fragments.EventosFragment;
import com.example.a.appedenfire.Fragments.HabitacionFragment;
import com.example.a.appedenfire.Fragments.InforFragment;
import com.example.a.appedenfire.Fragments.InicioFragment;
import com.example.a.appedenfire.Fragments.InstalacionesFragment;
import com.example.a.appedenfire.Fragments.LugarFragment;
import com.example.a.appedenfire.Fragments.OfertaFragment;
import com.example.a.appedenfire.Fragments.RestauranteFragment;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btnInicio, btnevento, btngeleria, btnhabi, btninstalaciones, btnlugar, btnoferta, btnrestaurante;
        ImageView btnlogin;
        CircleMenu circleMenu =(CircleMenu)findViewById(R.id.circle_menu);
        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"),R.drawable.ic_add_black_24dp,R.drawable.ic_clear)
            .addSubMenu(Color.parseColor("#250CFF"),R.drawable.ic_info)
                .addSubMenu(Color.parseColor("#6d4c41"),R.drawable.ic_cama_de_matrimonio)
                .addSubMenu(Color.parseColor("#250CFF"),R.drawable.ic_herramienta_de_punto_de_aguja_para_mapas)
                .addSubMenu(Color.parseColor("#FF0000"),R.drawable.ic_alerta_simbolo_dibujado_a_mano)
                .addSubMenu(Color.parseColor("#03a9f4"),R.drawable.ic_info)
                .addSubMenu(Color.parseColor("#1a237e"),R.drawable.ic_user)
        .setOnMenuSelectedListener(new OnMenuSelectedListener() {
            @Override
            public void onMenuSelected(int i) {

            }
        });




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
        /*
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e = new Intent(Main2Activity.this,Admin.class);
                startActivity(e);
            }
        });
        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e = new Intent(Main2Activity.this,InicioActivity.class);
                startActivity(e);
            }
        });
        btnevento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e = new Intent(Main2Activity.this,EventosActivity.class);
                startActivity(e);
            }
        });
        btngeleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e = new Intent(Main2Activity.this,InicioActivity.class);
                startActivity(e);
            }
        });
        btnhabi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e = new Intent(Main2Activity.this,HabitacionActivity.class);
                startActivity(e);
            }
        });
        btninstalaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e = new Intent(Main2Activity.this,InstalacionServiciosActivity.class);
                startActivity(e);
            }
        });
        btnlugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e = new Intent(Main2Activity.this,LugarActivity.class);
                startActivity(e);
            }
        });
        btnoferta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e = new Intent(Main2Activity.this,OfertaActivity.class);
                startActivity(e);
            }
        });
        btnrestaurante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e = new Intent(Main2Activity.this,RestauranteActivity.class);
                startActivity(e);
            }
        });
    }
*/
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmen = getFragmentManager();
        if (id == R.id.nav_info) {
            fragmen.beginTransaction()
                    .replace(R.id.content_fragment
                            ,new InforFragment())
                    .commit();


        } else if (id == R.id.nav_eventos) {
            fragmen.beginTransaction()
                    .replace(R.id.content_fragment
                            ,new EventosFragment())
                    .commit();

        } else if (id == R.id.nav_restaurante) {
            fragmen.beginTransaction()
                    .replace(R.id.content_fragment
                            ,new RestauranteFragment())
                    .commit();


        } else if (id == R.id.nav_galeria) {
            fragmen.beginTransaction()
                    .replace(R.id.content_fragment
                            ,new InstalacionesFragment())
                    .commit();
        }else if (id == R.id.nav_lugar) {
            fragmen.beginTransaction()
                    .replace(R.id.content_fragment
                            ,new LugarFragment())
                    .commit();
        }
        else if (id == R.id.nav_habitacion) {
            fragmen.beginTransaction()
                    .replace(R.id.content_fragment
                            ,new HabitacionFragment())
                    .commit();
        }
        else if (id == R.id.nav_oferta) {
            fragmen.beginTransaction()
                    .replace(R.id.content_fragment
                            , new OfertaFragment())
                    .commit();
        }


            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
