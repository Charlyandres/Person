package co.edu.unisangil.person.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import co.edu.unisangil.person.R;

public class MainActivity extends AppCompatActivity {

    private EditText edCorreoLg, edContraseñaLg;

    private Button btnRegistro, btnInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edCorreoLg = findViewById(R.id.edCorreoLg);
        edContraseñaLg = findViewById(R.id.edContraseñaLg);
        btnRegistro = findViewById(R.id.btnRegistro);
        btnInicio = findViewById(R.id.bntInicio);
        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickIniciarSesion();
            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickRegistrar();
            }
        });
    }


    private void onClickIniciarSesion(){
        String email = edCorreoLg.getText().toString();
        String password = edContraseñaLg.getText().toString();
        if(!email.isEmpty()) {
            if(!password.isEmpty()) {
                Intent intent = new Intent(this, PersonActivity.class);
                startActivity(intent);
            }else{edContraseñaLg.setError("Contraseña obligatoria");}
        }else{edCorreoLg.setError("Correo obligatorio");}
    }
    private void onClickRegistrar(){}
}