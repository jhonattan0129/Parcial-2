package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

public class MostrarUsuarioEncontrado extends AppCompatActivity {
    UsuarioController c;
    ListView listado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_usuario_encontrado);


        String cedula = getIntent().getStringExtra("cedula");
        listado = findViewById(R.id.lstUsuarioEncontrado);
        c = new UsuarioController(getApplicationContext());


        Cursor cur = c.buscarUsuario(cedula);
        UsuarioCursorAdapter eca = new UsuarioCursorAdapter(this,cur,0);
        listado.setAdapter(eca);
        eca.notifyDataSetChanged();

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
