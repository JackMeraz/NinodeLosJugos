package com.example.jacobomeraz.niodelosjugos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private Button btnA,btnB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnA=(Button)findViewById(R.id.btnregistrar);

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentreg = new Intent(MainActivity.this,Registro.class);
                MainActivity.this.startActivity(intentreg);

            }
        });

    }
}
