package com.example.ejerciciocatalogocarrito.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private Long id;
    private List<Producto> productos;
    private List<Integer> cantidades;

    public Carrito() {
        productos = new ArrayList<>();
        cantidades = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSubtotal() {
        double total = 0;
        for (int i = 0; i < productos.size(); i++) {
            total += productos.get(i).getPrecio() * cantidades.get(i);
        }

        return total;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Integer> getCantidades() {
        return cantidades;
    }

    public void setCantidades(List<Integer> cantidades) {
        this.cantidades = cantidades;
    }

    public void setCantidad(int cantidad) {
        cantidades.add(cantidad);
    }

    public void setCantidad(int posicion, int cantidad) {
        cantidades.set(posicion, cantidad);
    }

    public void setProducto(Producto producto, int cantidad) {
        productos.add(producto);
        cantidades.add(cantidad);
    }

    public void borrarProducto(int posicion) {
        productos.remove(posicion);
        cantidades.remove(posicion);
    }
}
