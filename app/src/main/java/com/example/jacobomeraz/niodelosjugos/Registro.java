package com.example.jacobomeraz.niodelosjugos;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Registro extends AppCompatActivity implements View.OnClickListener {
   EditText etnombre, etapellidop, etapellidom, etusuario, etcontraseña, ettelefono;
    Button btnregistrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etnombre= (EditText) findViewById(R.id.editT_nombre);
        etapellidop= (EditText) findViewById(R.id.editT_apellidop);
        etapellidom= (EditText) findViewById(R.id.editT_apellidom);
        etusuario= (EditText) findViewById(R.id.editT_usuario);
        etcontraseña= (EditText) findViewById(R.id.editT_contraseña);
        ettelefono= (EditText) findViewById(R.id.editT_telefono);

        btnregistrar= (Button) findViewById(R.id.btn_registrar);

        btnregistrar.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        final String nombre= etnombre.getText().toString();
        final String ape_pat= etapellidop.getText().toString();
        final String ape_mat= etapellidom.getText().toString();
        final String user= etusuario.getText().toString();
        final String pass= etcontraseña.getText().toString();
        final String telefono= ettelefono.getText().toString();

        Response.Listener<String> respoListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse= new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success) {
                        Intent intent= new Intent(Registro.this, MainActivity.class);
                        Registro.this.startActivity(intent);

                    }else {
                        AlertDialog.Builder builder= new  AlertDialog.Builder(Registro.this);
                        builder.setMessage("error al registrar").setNegativeButton("Retry",null)
                                .create().show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };

        RegisterRequest registerRequest= new RegisterRequest(nombre, ape_pat, ape_mat, user, pass, telefono,respoListener);
        RequestQueue queue= Volley.newRequestQueue(Registro.this);
        queue.add(registerRequest);


    }
}
