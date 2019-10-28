package com.example.ejerciciocatalogocarrito;

public interface OnChangeCarrito {
    void inCantidad(int posicion, int cantidad);
    void deleteItem(int posicion);
}
