package com.example.agenciaviajes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnConfirmar;
    EditText txtNombre, txtFechaPartida, txtFechaRegreso;
    DatePicker fechaPartida, fechaRegreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Boleto boleto = new Boleto(1, );

    }
}