package com.example.ejerciciocatalogocarrito.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private Long id;
    private double subtotal;
    private List<Producto> productos;

    public Carrito() {
        productos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSubtotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }

        return total;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void setProducto(Producto producto) {
        productos.add(producto);
    }
}
