package co.edu.unisangil.person.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import co.edu.unisangil.person.R;

public class VistaActivity extends AppCompatActivity {

    TextView textNombre, textEdad, textDireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista);
        textNombre = findViewById(R.id.txtNombre);
        textEdad = findViewById(R.id.txtEdad);
        textDireccion = findViewById(R.id.txtDireccion);

        Intent intent = getIntent();
        String Nombre = intent.getStringExtra("nombre");
        byte Edad = intent.getByteExtra("edad", (byte) 0);
        String Direccion = intent.getStringExtra("Direccion");

        textNombre.setText(Nombre);
        textEdad.setText(Edad);
        textDireccion.setText(Direccion);
    }
}