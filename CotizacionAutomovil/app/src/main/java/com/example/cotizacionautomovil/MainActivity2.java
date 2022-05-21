package com.example.cotizacionautomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView txtNumero, txtDescripcion, txtPrecio,
        txtPorcentaje, txtPlazo, txtPagoInicial, txtTotal, txtPagoMensual;
    private Cotizacion cotizacion;
    private Button btnRegresar;
    private Intent oldIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtNumero = findViewById(R.id.txtNumero);
        txtDescripcion = findViewById(R.id.txtDescripcion);
        txtPrecio = findViewById(R.id.txtPrecio);
        txtPorcentaje = findViewById(R.id.txtPorcentaje);
        txtPlazo = findViewById(R.id.txtPlazo);
        txtPagoInicial = findViewById(R.id.txtPagoInicial);
        txtTotal = findViewById(R.id.txtTotal);
        txtPagoMensual = findViewById(R.id.txtPagoMensual);
        btnRegresar = findViewById(R.id.btnRegresar);

        oldIntent = getIntent();
        cotizacion = (Cotizacion) oldIntent.getSerializableExtra("cotizacion");

        txtNumero.setText(String.valueOf(cotizacion.getId()));
        txtDescripcion.setText(cotizacion.getDescripcion());
        txtPrecio.setText(String.valueOf(cotizacion.getPrecio()));
        txtPorcentaje.setText(String.valueOf(cotizacion.getPorcentaje_pago()));
        txtPlazo.setText(String.valueOf(cotizacion.getPlazo()));
        txtPagoInicial.setText(String.valueOf(cotizacion.calcularPagoInicial()));
        txtTotal.setText(String.valueOf(cotizacion.calcularTotal()));
        txtPagoMensual.setText(String.valueOf(cotizacion.calcularMensualidad()));

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}