package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class UsuarioActualizado extends AppCompatActivity {

    EditText nombre, cedula, salario;
    Spinner estrato, educacion;
    String estratoA [];
    String educacionA [];
    ArrayAdapter adapterEstrato, adapterEstudio;
    Button actualizar;
    UsuarioController usuario;
    String estratoSa = "", educacionSa ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_actualizado);

        String cedulaS = getIntent().getStringExtra("cedula");
        usuario = new UsuarioController(getApplicationContext());

        estrato = findViewById(R.id.spnEstratoA);
        educacion = findViewById(R.id.spnEducacionA);
        cedula = findViewById(R.id.txtCedulaA);
        nombre = findViewById(R.id.txtNombreA);
        salario = findViewById(R.id.txtSalarioA);
        actualizar = findViewById(R.id.btnActualizaA);

        Cursor cursor = usuario.buscarUsuario(cedulaS);

        String nombreS = "", estratoS = "", salarioS = "", educacionS = "";
        while (cursor.moveToNext()) {
            nombreS = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
            estratoS = cursor.getString(cursor.getColumnIndexOrThrow("estrato"));
            salarioS = cursor.getString(cursor.getColumnIndexOrThrow("salario"));
            educacionS = cursor.getString(cursor.getColumnIndexOrThrow("educacion"));
        }
        cedula.setText(cedulaS);
        nombre.setText(nombreS);
        salario.setText(salarioS);

        estratoA = new String[]{estratoS, "1", "2", "3", "4", "5", "6"};
        educacionA = new String[]{educacionS, "Bachillerato", "Pregrado", "Maestría", "Doctorado"};

        adapterEstrato = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, estratoA);
        adapterEstudio = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, educacionA);

        educacion.setAdapter(adapterEstudio);
        estrato.setAdapter(adapterEstrato);

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cedula.getText().toString().isEmpty() && !nombre.getText().toString().isEmpty() && !salario.getText().toString().isEmpty() && !estrato.getSelectedItem().toString().isEmpty() && !educacion.getSelectedItem().toString().isEmpty()) {
                    estratoSa = (String) estrato.getSelectedItem();
                    educacionSa = (String) educacion.getSelectedItem();
                    long id = usuario.actualizarUsuario(new Usuario(nombre.getText().toString(), cedula.getText().toString(), estratoSa, salario.getText().toString(), educacionSa));
                    Toast.makeText(getApplicationContext(), "Usuario Actualizado.", Toast.LENGTH_SHORT).show();
                    System.out.println(id);
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "Campos imcompletos.", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mnHome) {
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.mnGuardar) {
            Intent i = new Intent(getApplicationContext(),GuardarUsuario.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.mnBuscar) {
            Intent i = new Intent(getApplicationContext(), BuscarUsuario.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.mnActualizar) {
            Intent i = new Intent(getApplicationContext(), ActualizarUsuario.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.mnEliminar) {
            Intent i = new Intent(getApplicationContext(), EliminarUsuario.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.mnListar) {
            Intent i = new Intent(getApplicationContext(), MostrarUsuario.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
