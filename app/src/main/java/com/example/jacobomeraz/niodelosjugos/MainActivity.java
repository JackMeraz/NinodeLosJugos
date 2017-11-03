package com.example.jacobomeraz.niodelosjugos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.support.v7.app.AlertDialog;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private Button btnA,btnB;
    EditText etnombre, etapellidop, etapellidom, etusuario, etpass, ettelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnB=(Button)findViewById(R.id.btningresar);
        btnA=(Button)findViewById(R.id.btnregistrar);
        etusuario = (EditText) findViewById (R.id.txtusuario);
        etpass = (EditText) findViewById(R.id.txtpass);
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentreg = new Intent(MainActivity.this,Registro.class);
                MainActivity.this.startActivity(intentreg);

            }
        });




        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String user= etusuario.getText().toString();
                final String pass= etpass.getText().toString();
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                String nombre = jsonResponse.getString("nombre");
                                String ape_pat= jsonResponse.getString("ape_pat");
                                String ape_mat= jsonResponse.getString("ape_mat");
                                String telefono= jsonResponse.getString("telefono");

                                Intent intent= new Intent(MainActivity.this, centralActivity.class);
                                intent.putExtra("nombre",nombre);
                                intent.putExtra("ape_pat",ape_pat);
                                intent.putExtra("ape_mat",ape_mat);
                                intent.putExtra("user",user);
                                intent.putExtra("pass",pass);
                                intent.putExtra("telefono",telefono);



                                MainActivity.this.startActivity(intent);

                            }else {
                                AlertDialog.Builder builder= new  AlertDialog.Builder(MainActivity.this);
                                builder.setMessage("error de login").setNegativeButton("Retry",null)
                                        .create().show();
                            }





                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        catch(Exception ex)
                                {
                                        // Procesar una excepción de sistema distinta de WebException
                                }


                    }
                };

                LoginRequest loginRequest = new LoginRequest(user, pass, responseListener);
                RequestQueue queue= Volley.newRequestQueue(MainActivity.this);
                queue.add(loginRequest);

            }
        });

    }
}
