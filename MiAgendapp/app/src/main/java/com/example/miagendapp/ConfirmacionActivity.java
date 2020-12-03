package com.example.miagendapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmacionActivity extends AppCompatActivity {

    TextView txtNombre, txtFechaNacimiento, txtTelefono, txtEmail, txtDescripcion;
    Button btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        txtNombre = findViewById(R.id.txtNombre);
        txtFechaNacimiento = findViewById(R.id.txtFechaNacimiento);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtEmail = findViewById(R.id.txtMail);
        txtDescripcion = findViewById(R.id.txtDescrip);
        btnEditar = findViewById(R.id.btnEditar);

        Bundle parametros = getIntent().getExtras();
        txtNombre.setText(parametros.getString("txtNombre"));
        txtFechaNacimiento.setText(parametros.getString("txtFechaNacimiento"));
        txtTelefono.setText(parametros.getString("txtTelefono"));
        txtEmail.setText(parametros.getString("txtEmail"));
        txtDescripcion.setText(parametros.getString("txtDescripcion"));

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}