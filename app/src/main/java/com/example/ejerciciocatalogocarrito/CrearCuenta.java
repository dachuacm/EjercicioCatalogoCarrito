package com.example.ejerciciocatalogocarrito;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CrearCuenta extends AppCompatActivity {

    EditText email;
    EditText contrasena;
    EditText contrasena2;

    Button botonCrear;
    Button botonIngresar;
    Button bontonGogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);

        email = (EditText) findViewById(R.id.cajaEmail2);
        contrasena = (EditText) findViewById(R.id.cajaPass4);
        contrasena2 = (EditText) findViewById(R.id.cajaPass5);

        botonCrear = (Button) findViewById(R.id.btnCreaCuenta);
        botonIngresar = (Button) findViewById(R.id.btnIniciaSecion);
        bontonGogle = (Button) findViewById(R.id.btnGoogle);

        botonCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        botonIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        botonIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


}
