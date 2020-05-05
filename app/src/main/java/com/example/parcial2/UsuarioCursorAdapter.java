package com.example.parcial2;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class UsuarioCursorAdapter extends CursorAdapter {
    public UsuarioCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.lista_usuario, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nombre = (TextView) view.findViewById(R.id.txtNombreU);
        TextView cedula = (TextView) view.findViewById(R.id.txtCedulaU);
        TextView estrato = (TextView) view.findViewById(R.id.txtEstratoU);
        TextView salario = (TextView) view.findViewById(R.id.txtSalarioU);
        TextView educacion = (TextView) view.findViewById(R.id.txtEducacionU);
        // Extract properties from cursor
        String nombreS = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
        String cedulaS = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
        String estratoS= cursor.getString(cursor.getColumnIndexOrThrow("estrato"));
        String salarioS= cursor.getString(cursor.getColumnIndexOrThrow("salario"));
        String educacionS= cursor.getString(cursor.getColumnIndexOrThrow("educacion"));
        // Populate fields with extracted properties
        nombre.setText(nombreS);
        cedula.setText(cedulaS);
        estrato.setText(estratoS);
        salario.setText(salarioS);
        educacion.setText(educacionS);

    }
}
