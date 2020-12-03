package com.example.miagendapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    String txtNombre, txtFechaNacimiento, txtTelefono, txtEmail, txtDescripcion;
    EditText etNombre, etTelefono, etEmail, etDescripcion;
    DatePicker dpFechaNacimiento;
    int fechaNacimientoDia, fechaNacimientoMes, fechaNacimientoAño;
    Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre);
        dpFechaNacimiento = findViewById(R.id.dpFechaNacimiento);
        etTelefono = findViewById(R.id.etTelefono);
        etEmail = findViewById(R.id.etEmail);
        etDescripcion = findViewById(R.id.etDescripcion);
        btnSiguiente = findViewById(R.id.btnSiguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                txtNombre = etNombre.getText().toString();
                txtTelefono = etTelefono.getText().toString();
                txtEmail = etEmail.getText().toString();
                txtDescripcion = etDescripcion.getText().toString();
                fechaNacimientoDia = dpFechaNacimiento.getDayOfMonth();
                fechaNacimientoMes = dpFechaNacimiento.getMonth();
                fechaNacimientoAño = dpFechaNacimiento.getYear();
                txtFechaNacimiento = String.valueOf(fechaNacimientoDia) + "/" + String.valueOf(fechaNacimientoMes) + "/" + String.valueOf(fechaNacimientoAño);

                if (txtNombre.equals("") || txtTelefono.equals("")){
                    msjAlerta();

                }else{
                //Contacto contacto = new Contacto();

                Intent intent = new Intent(MainActivity.this, ConfirmacionActivity.class);
                intent.putExtra("txtNombre",txtNombre);
                intent.putExtra("txtFechaNacimiento", txtFechaNacimiento);
                intent.putExtra("txtTelefono", txtTelefono);
                intent.putExtra("txtEmail", txtEmail);
                intent.putExtra("txtDescripcion", txtDescripcion);
                startActivity(intent);

                }

                }catch (Exception e){

                }
            }
        });

    }

    public void msjAlerta(){
        
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(R.string.msgError);
        alert.create();
        alert.show();
    }
}