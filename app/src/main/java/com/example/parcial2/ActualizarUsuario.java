package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class ActualizarUsuario extends AppCompatActivity {

    EditText cedula;
    UsuarioController c;
    Button actualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_usuario);


        cedula = findViewById(R.id.txtCedulaActualizar);
        actualizar = findViewById(R.id.btnActualizar);
        c = new UsuarioController(getApplicationContext());

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!c.buscarU(cedula.getText().toString())){
                    Toast.makeText(getApplicationContext(),"No se encontro el Usuario "+ cedula.getText().toString(), Toast.LENGTH_SHORT).show();
                }else{
                    Intent i = new Intent(getApplicationContext(), UsuarioActualizado.class );
                    i.putExtra("cedula",cedula.getText().toString());
                    startActivity(i);
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
