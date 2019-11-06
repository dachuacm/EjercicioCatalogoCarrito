package com.example.ejerciciocatalogocarrito;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ejerciciocatalogocarrito.Alertas.DialogoAlerta;
import com.example.ejerciciocatalogocarrito.Modelo.Usuario;

public class CrearCuenta extends AppCompatActivity {

    EditText email;
    EditText contrasena;
    EditText contrasena2;

    Button botonCrear;
    Button botonIngresar;
    Button botonGogle;

    public static final String USUARIO_KEY = "USER_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);

        email = (EditText) findViewById(R.id.cajaEmail2);
        contrasena = (EditText) findViewById(R.id.cajaPass4);
        contrasena2 = (EditText) findViewById(R.id.cajaPass5);

        botonCrear = (Button) findViewById(R.id.btnCreaCuenta);
        botonIngresar = (Button) findViewById(R.id.btnIniciaSecion);
        botonGogle = (Button) findViewById(R.id.btnGoogle);

        botonCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario = new Usuario();

                String pass = contrasena.getText().toString();
                String pass2= contrasena2.getText().toString();
                String emailU = email.getText().toString();

                if(pass!=pass2){
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    DialogoAlerta dialogo = new DialogoAlerta();
                    dialogo.show(fragmentManager, "tagAlerta");
                }/**
                 *faltan validar nas posibilidades
                 * q tenga un rango
                 * que no sea null
                 * tambien la privasidad
                 */
                else{
                    usuario.setEmail(emailU);
                    usuario.setContrasena(pass);
                    /*Pasar la informacion hacia la otra vista*/
                    Intent intent = new Intent(v.getContext() , Registro.class);
                    intent.putExtra(USUARIO_KEY,  usuario);
                    startActivity(intent);
                }
            }
        });

        botonIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext() , Login.class);
                startActivity(intent);
            }
        });

        botonGogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


}
