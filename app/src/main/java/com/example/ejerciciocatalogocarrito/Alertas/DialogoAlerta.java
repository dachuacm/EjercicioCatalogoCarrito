package com.example.ejerciciocatalogocarrito.Alertas;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class DialogoAlerta  extends DialogFragment {

    public Dialog onCreDialog(Bundle saveInstanceState){
        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());
        builder.setMessage("Error.")
                .setTitle("Las contraseñas no coinciden Verificar")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        return builder.create();
    }
}
