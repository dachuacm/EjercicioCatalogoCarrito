package com.example.ejerciciocatalogocarrito;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ejerciciocatalogocarrito.Modelo.Usuario;

public class Registro extends AppCompatActivity {
    public static final String USUARIO_KEY = "USER_KEY";
    EditText nombres;
    EditText apellidos;
    EditText domicilio;
    EditText municipio;
    EditText estado;

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        /**/
        Bundle datos = this.getIntent().getExtras();

        /*Verificar si jala los datos*/
        final Usuario usuario = (Usuario) datos.get(USUARIO_KEY);

        nombres = (EditText) findViewById(R.id.cajaNombre);
        apellidos = (EditText) findViewById(R.id.cajaApellidos);
        domicilio = (EditText) findViewById(R.id.cajaDomicilio);
        estado = (EditText) findViewById(R.id.cajaEstado);
        municipio = (EditText) findViewById(R.id.cajaMunicipio);

        button = (Button) findViewById(R.id.btnRegistrar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = nombres.getText().toString();
                String apellido = apellidos.getText().toString();
                String domi = domicilio.getText().toString();
                String esta = estado.getText().toString();
                String muni = municipio.getText().toString();

                /*Validad si estan los registros*/

                usuario.setNombre(nombre);
                usuario.setApellidos(apellido);
                usuario.setDomicilio(domi);
                usuario.setEstado(esta);
                usuario.setAlcaldia(muni);

                /*Enviar el objeto fire base*/

            }
        });

    }
}
