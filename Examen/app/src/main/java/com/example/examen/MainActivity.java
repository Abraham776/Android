package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private String nombre;
    private float base, altura;
    private EditText txtNombre, txtBase, txtAltura;
    private Button btnLimpiar, btnSiguiente, btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = findViewById(R.id.txtNombre);
        txtBase = findViewById(R.id.txtBase);
        txtAltura = findViewById(R.id.txtAltura);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnSiguiente = findViewById(R.id.btnSiguiente);
        btnSalir = findViewById(R.id.btnSalir);

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtAltura.setText("");
                txtNombre.setText("");
                txtBase.setText("");
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Cerrando Actividad")
                        .setMessage("¿Está seguro que desea cerrar esta actividad?")
                        .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtBase.getText().toString().equals("") || txtAltura.getText().toString().equals("")
                        || txtNombre.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,
                            "Por favor rellene los campos de manera correcta", Toast.LENGTH_SHORT).show();
                    return;
                }

                base = Float.parseFloat(txtBase.getText().toString());
                altura = Float.parseFloat(txtAltura.getText().toString());
                nombre = txtNombre.getText().toString();

                Intent intent = new Intent(MainActivity.this, RectanguloActivity.class);
                intent.putExtra("base", base);
                intent.putExtra("altura", altura);
                intent.putExtra("nombre", nombre);
                startActivity(intent);
            }
        });
    }
}