package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class GuardarUsuario extends AppCompatActivity {

    EditText nombre, cedula, salario;
    Spinner estrato, educacion;
    String estratoA [];
    String educacionA [];
    ArrayAdapter adapterEstrato, adapterEstudio;
    Button registrar;
    UsuarioController usuario;
    String estratoS, educacionS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardar_usuario);

        usuario = new UsuarioController(getApplicationContext());
        //c = (String) cap.getSelectedItem(); para capturar los items

        estratoA = new String[] {"","1","2","3","4","5","6"};
        educacionA = new String[] {"","Bachillerato","Pregrado","Maestría","Doctorado"};

        estrato = findViewById(R.id.spnEstrato);
        educacion = findViewById(R.id.spnEstudios);
        cedula = findViewById(R.id.txtCedula);
        nombre = findViewById(R.id.txtNombre);
        salario = findViewById(R.id.txtSalario);
        registrar = findViewById(R.id.btnGuardar);

        adapterEstrato = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, estratoA);
        adapterEstudio = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, educacionA);

        educacion.setAdapter(adapterEstudio);
        estrato.setAdapter(adapterEstrato);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usuario.buscarU(cedula.getText().toString())){
                    Toast.makeText(getApplicationContext(),"La cedula ingresada ya existe.", Toast.LENGTH_SHORT).show();
                }else{
                    if(!cedula.getText().toString().isEmpty() && !nombre.getText().toString().isEmpty() && !salario.getText().toString().isEmpty() && !estrato.getSelectedItem().toString().isEmpty() && !educacion.getSelectedItem().toString().isEmpty()){
                        estratoS = (String) estrato.getSelectedItem();
                        educacionS = (String) educacion.getSelectedItem();
                        usuario.agregarUsuario(new Usuario(nombre.getText().toString(), cedula.getText().toString(),estratoS, salario.getText().toString(),educacionS));
                        Toast.makeText(getApplicationContext(),"Usuario Guardado.", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }else{
                        Toast.makeText(getApplicationContext(),"Campos imcompletos.", Toast.LENGTH_SHORT).show();
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
