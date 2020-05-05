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

public class EliminarUsuario extends AppCompatActivity {
    UsuarioController c;
    EditText cedula;
    Button eliminar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_usuario);

        cedula = findViewById(R.id.txtCedulaEliminado);
        eliminar = findViewById(R.id.btnEliminar);
        c = new UsuarioController(getApplicationContext());

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!c.buscarU(cedula.getText().toString())){
                    Toast.makeText(getApplicationContext(),"No se encontro el Usuario con cedula: "+ cedula.getText().toString(), Toast.LENGTH_SHORT).show();
                }else{
                    boolean cur = c.eliminarUsuario(cedula.getText().toString());
                    if(cur == true){
                        Toast.makeText(getApplicationContext(),"Usuario Eliminado", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }else{
                        Toast.makeText(getApplicationContext(),"No se pudo eliminar el Usuario", Toast.LENGTH_SHORT).show();
                    }
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
