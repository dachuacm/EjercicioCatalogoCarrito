package com.example.ejerciciocatalogocarrito.Modelo;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuario implements Parcelable {

    private String email;
    private String contrasena;
    private String nombre;
    private String apellidos;
    private String domicilio;
    private String numero;
    private String codigoPostal;
    private String alcaldia;
    private String estado;

    public Usuario(){

    }

    public Usuario(String email, String contrasena, String nombre, String apellidos, String domicilio, String numero, String codigoPostal, String alcaldia, String estado) {
        this.email = email;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.domicilio = domicilio;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.alcaldia = alcaldia;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "email='" + email + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", numero='" + numero + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", alcaldia='" + alcaldia + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getAlcaldia() {
        return alcaldia;
    }

    public void setAlcaldia(String alcaldia) {
        this.alcaldia = alcaldia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
