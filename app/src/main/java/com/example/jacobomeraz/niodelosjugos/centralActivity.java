package com.example.jacobomeraz.niodelosjugos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;

public class centralActivity extends AppCompatActivity {
    TextView tvnombre, tvapellidopat, tvapellidomat, tvusuario, tvcontraseña, tvtelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central);


        tvnombre= (TextView) findViewById(R.id.tv_nombre);
        tvapellidopat= (TextView) findViewById(R.id.tv_apellidopat);
        tvapellidomat= (TextView) findViewById(R.id.tv_apellidomat);
        tvusuario= (TextView) findViewById(R.id.tv_usuario);
        tvcontraseña= (TextView) findViewById(R.id.tv_contraseña);
        tvtelefono= (TextView) findViewById(R.id.tv_telefono);

        Intent intent= getIntent();
        String nombre= intent.getStringExtra("nombre");
        String ape_pat= intent.getStringExtra("ape_pat");
        String ape_mat= intent.getStringExtra("ape_mat");
        String user= intent.getStringExtra("user");
        String pass= intent.getStringExtra("pass");
        String telefono= intent.getStringExtra("telefono");


        tvnombre.setText(nombre);
        tvapellidopat.setText(ape_pat);
        tvapellidomat.setText(ape_mat);
        tvusuario.setText(user);
        tvcontraseña.setText(pass);
        tvtelefono.setText(telefono);

    }
}
