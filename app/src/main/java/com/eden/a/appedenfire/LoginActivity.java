package com.eden.a.appedenfire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    String usuario="admin";
    String password="admin";
    EditText email_edittext,password_edittext;
    Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




        Toolbar toolbar = findViewById(R.id.toolbar123);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Login");
        toolbar.setNavigationIcon(R.drawable.ic_flecha_izquierda);
        email_edittext=findViewById(R.id.email_edittext);
        password_edittext=findViewById(R.id.password_edittext);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnlogin=findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(usuario.equals(email_edittext.getText().toString())&& password.equals(password_edittext.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Ha entrado",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this,Admin.class);
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(),"Contraseña incorrecta",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
