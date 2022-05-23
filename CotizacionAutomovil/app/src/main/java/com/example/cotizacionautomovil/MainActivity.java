package com.example.cotizacionautomovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spnPlazo;
    private EditText txtDescripcion, txtPrecio, txtPorcentajePago;
    private Button btnConfirmar;
    private String plazo;
    private Cotizacion cotizacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnPlazo = findViewById(R.id.spnPlazo);
        txtDescripcion = findViewById(R.id.txtDescripcion);
        txtPrecio = findViewById(R.id.txtPrecio);
        txtPorcentajePago = findViewById(R.id.txtPorcentajePago);
        btnConfirmar = findViewById(R.id.btnConfirmar);

        ArrayAdapter<String> adapterPlazos = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1,
                                                getResources().getStringArray(R.array.plazos));

        spnPlazo.setAdapter(adapterPlazos);
        spnPlazo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                plazo = parent.getItemAtPosition(position).toString().replace(" meses", "");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(plazo.equals("") || txtDescripcion.equals("") || txtPrecio.equals("") || txtPorcentajePago.equals("")){
                    Toast.makeText(MainActivity.this, "Por favor rellene todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                cotizacion = new Cotizacion(1, Integer.parseInt(plazo), txtDescripcion.getText().toString(), Float.parseFloat(txtPrecio.getText().toString()), Float.parseFloat(txtPorcentajePago.getText().toString()));
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("cotizacion", cotizacion);
                startActivity(intent);
            }
        });

    }
}