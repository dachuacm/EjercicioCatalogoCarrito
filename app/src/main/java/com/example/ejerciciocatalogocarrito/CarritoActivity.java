package com.example.ejerciciocatalogocarrito;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ejerciciocatalogocarrito.Modelo.Carrito;
import com.example.ejerciciocatalogocarrito.Modelo.Mail;
import com.example.ejerciciocatalogocarrito.Modelo.Producto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

public class CarritoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RVAdapterCarrito rVAdapterCarrito;
    private EditText eTEmail;
    private TextView tVtolal;
    private Carrito carrito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        recyclerView = findViewById(R.id.recycler_view_carrito);
        eTEmail = findViewById(R.id.txt_email);
        tVtolal = findViewById(R.id.total);

        carrito = new Carrito();
        getProductos(3);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        rVAdapterCarrito = new RVAdapterCarrito(carrito);
        recyclerView.setAdapter(rVAdapterCarrito);
        actualizarTotal();

        OnChangeCarrito onChangeCarrito = new OnChangeCarrito() {
            @Override
            public void inCantidad(int posicion, int cantidad) {
                carrito.setCantidad(posicion, cantidad);

                actualizarTotal();
            }

            @Override
            public void deleteItem(int posicion) {
                carrito.borrarProducto(posicion);
                rVAdapterCarrito.notifyDataSetChanged();
                actualizarTotal();
            }
        };

        rVAdapterCarrito.setOnChangeCarrito(onChangeCarrito);
    }

    public void getProductos(int numItems) {
        for (int i = 0; i < numItems; i++) {
            int rnd = random(1, 100);
            Producto producto = new Producto();
            producto.setNombre("Producto " + rnd);
            producto.setPrecio(rnd);
            carrito.setProducto(producto, random(1, 5));
        }
    }

    public int random(int min, int max) {
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }

    public void addItem(View view) {
        getProductos(1);
        rVAdapterCarrito.notifyDataSetChanged();
        actualizarTotal();
    }

    public void enviarFactura(View view) {
        String msjEnviado = "Se envió la factura a su correo";
        Mail mail = new Mail(getResources(), eTEmail.getText().toString(), "Factura", getHtmlFactura());

        try {
            mail.enviarMensaje(getResources(), carrito);

        } catch (MessagingException | IOException e) {
            msjEnviado = "Error al enviar la factura a su correo";
            Log.e("Error enviarFactura(): ", e.getMessage(), e);

        } finally {
            Toast toast = Toast.makeText(this, msjEnviado, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
        }
    }

    public String getHtmlFactura() {
        String msj = "<h1>Confirmación de pedido</h1>" +
                "<h4>Detalles del pedido</h4>" +
                "<table cellspacing=\"15\"><tbody>" +
                "<tr>" +
                "<td><strong>&nbsp;</strong></td>" +
                "<td><strong>Producto</strong></td>" +
                "<td><strong>Precio unitario</strong></td>" +
                "<td><strong>Cantidad</strong></td>" +
                "<td><strong>Subtotal</strong></td>" +
                "</tr>";

        //for (Producto producto : carrito.getProductos()) {
        for (int i = 0; i < carrito.getProductos().size(); i++) {
            Producto producto = carrito.getProductos().get(i);
            double precio = producto.getPrecio();
            int cantidad = carrito.getCantidades().get(i);

            msj += "<tr>" +
                    "<td><img width=\"100\" src=\"cid:image\"></td>" +
                    "<td>" + producto.getNombre() + "</td>" +
                    "<td>$" + precio + "</td>" +
                    "<td>" + cantidad + "</td>" +
                    "<td>$" + precio * cantidad + "</td>" +
                    "</tr>";
        }

        msj += "<tr>" +
                "<td colspan=\"3\"></td>" +
                "<td>Total:</td>" +
                "<td>$" + carrito.getSubtotal() + "</td>" +
                "</tr>" +
                "</tbody></table>";

        return msj;
    }

    public void actualizarTotal() {
        tVtolal.setText("$" + carrito.getSubtotal());
    }
}
