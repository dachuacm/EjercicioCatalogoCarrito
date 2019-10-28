package com.example.ejerciciocatalogocarrito;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejerciciocatalogocarrito.Modelo.Carrito;
import com.example.ejerciciocatalogocarrito.Modelo.Producto;

import java.util.List;

public class RVAdapterCarrito extends RecyclerView.Adapter<RVAdapterCarrito.ViewHolder> {
    private Carrito carrito;
    private OnChangeCarrito onChangeCarrito;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagenProducto;
        private TextView nombreProducto;
        private TextView precioProducto;
        private TextView subtotal;
        private EditText cantidadProducto;
        private ImageView btnBorrar;

        public ViewHolder(View itemView, final OnChangeCarrito onChangeCarrito) {
            super(itemView);
            imagenProducto = itemView.findViewById(R.id.imagenProducto);
            nombreProducto = itemView.findViewById(R.id.nombreProducto);
            precioProducto = itemView.findViewById(R.id.precioProducto);
            cantidadProducto = itemView.findViewById(R.id.cantidadProducto);
            subtotal = itemView.findViewById(R.id.subtotal);
            btnBorrar = itemView.findViewById(R.id.btn_delete);

            cantidadProducto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int cantidad = Integer.parseInt(cantidadProducto.getText().toString());
                    double sub = Double.parseDouble(precioProducto.getText().toString().substring(1));
                    onChangeCarrito.inCantidad(getAdapterPosition(), cantidad);
                    subtotal.setText("$" + sub * cantidad);
                }
            });

            btnBorrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onChangeCarrito.deleteItem(getAdapterPosition());
                }
            });
        }
    }

    public RVAdapterCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_carrito, viewGroup, false);
        return new ViewHolder(view, onChangeCarrito);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Producto producto = carrito.getProductos().get(i);
        int cantidad = carrito.getCantidades().get(i);
        viewHolder.imagenProducto.setImageResource(R.drawable.box);
        viewHolder.nombreProducto.setText(producto.getNombre());
        viewHolder.precioProducto.setText("$" + producto.getPrecio());
        viewHolder.cantidadProducto.setText("" + cantidad);
        viewHolder.subtotal.setText("$" + producto.getPrecio() * cantidad);
    }

    @Override
    public int getItemCount() {
        return carrito.getProductos().size();
    }

    public void setOnChangeCarrito(OnChangeCarrito onChangeCarrito) {
        this.onChangeCarrito = onChangeCarrito;
    }
}