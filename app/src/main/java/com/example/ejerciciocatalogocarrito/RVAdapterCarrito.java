package com.example.ejerciciocatalogocarrito;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejerciciocatalogocarrito.Modelo.Producto;

import java.util.List;

public class RVAdapterCarrito extends RecyclerView.Adapter<RVAdapterCarrito.ViewHolder> {
    public List<Producto> productos;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagenProducto;
        private TextView nombreProducto;
        private TextView precioProducto;
        private EditText cantidadProducto;

        public ViewHolder(View itemView) {
            super(itemView);
            imagenProducto = itemView.findViewById(R.id.imagenProducto);
            nombreProducto = itemView.findViewById(R.id.nombreProducto);
            precioProducto = itemView.findViewById(R.id.precioProducto);
            cantidadProducto = itemView.findViewById(R.id.cantidadProducto);
        }
    }

    public RVAdapterCarrito(List<Producto> productos) {
        this.productos = productos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_carrito, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Producto producto = productos.get(i);
        viewHolder.imagenProducto.setImageResource(R.drawable.box);
        viewHolder.nombreProducto.setText(producto.getNombre());
        viewHolder.precioProducto.setText("$" + producto.getPrecio());
        viewHolder.cantidadProducto.setText("1");
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }
}