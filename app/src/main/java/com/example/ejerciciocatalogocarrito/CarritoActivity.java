package com.example.ejerciciocatalogocarrito;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.ejerciciocatalogocarrito.Modelo.Carrito;
import com.example.ejerciciocatalogocarrito.Modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class CarritoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RVAdapterCarrito rVAdapterCarrito;
    private TextView tVtolal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        recyclerView = findViewById(R.id.recycler_view_carrito);
        tVtolal = findViewById(R.id.total);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Carrito carrito = new Carrito();
        carrito.setProductos(getProductos());

        rVAdapterCarrito = new RVAdapterCarrito(carrito.getProductos());
        tVtolal.setText("$" + carrito.getSubtotal());
        recyclerView.setAdapter(rVAdapterCarrito);
    }

    public List<Producto> getProductos() {
        List<Producto> productos = new ArrayList<>();

        Producto producto = new Producto();
        producto.setNombre("Producto 1");
        producto.setPrecio(100);
        productos.add(producto);

        producto = new Producto();
        producto.setNombre("Producto 2");
        producto.setPrecio(50);
        productos.add(producto);

        producto = new Producto();
        producto.setNombre("Producto 3");
        producto.setPrecio(60);
        productos.add(producto);

        return productos;
    }
}
