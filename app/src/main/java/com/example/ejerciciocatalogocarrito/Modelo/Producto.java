package com.example.ejerciciocatalogocarrito.Modelo;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Producto implements Serializable {

    @NonNull
    private int id;
    @NonNull
    private String nombre;
    @NonNull
    private String descripcion;
    @NonNull
    private double precio;
    @NonNull
    private String marca;
    @NonNull
    private  String proveedor;
    @NonNull
    private String sucursal;
    @NonNull
    private int stock;



    public Producto() {
    }

    public Producto(int id, @NonNull String nombre, @NonNull String descripcion, double precio, @NonNull String marca, @NonNull String proveedor, @NonNull String sucursal, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.marca = marca;
        this.proveedor = proveedor;
        this.sucursal = sucursal;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", marca='" + marca + '\'' +
                ", proveedor='" + proveedor + '\'' +
                ", sucursal='" + sucursal + '\'' +
                ", stock=" + stock +
                '}';
    }
}
