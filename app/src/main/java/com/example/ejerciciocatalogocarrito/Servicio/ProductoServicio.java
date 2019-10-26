package com.example.ejerciciocatalogocarrito.Servicio;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProductoServicio {

  public ProductoServicio(){
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
    }

    public void  agregarProducto(){

    }

    public void mostrarProducto(){

    }

    public void editarPoducto(){


    }

    public void eliminarProducto(){


    }
}
