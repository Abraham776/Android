package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class RectanguloActivity extends AppCompatActivity {
    private TextView lblAltura, lblBase, lblResultado, lblNombre;
    private Button btnCalcular, btnRegresar;
    private Intent oldIntent;
    private Rectangulo rectangulo = new Rectangulo();
    private String calcular = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);

        lblAltura = findViewById(R.id.lblAltura);
        lblBase = findViewById(R.id.lblBase);
        lblResultado = findViewById(R.id.lblResultado);
        lblNombre = findViewById(R.id.lblNombre);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnRegresar = findViewById(R.id.btnRegresar);

        oldIntent = getIntent();
        lblAltura.setText("Altura: " + String.valueOf(oldIntent.getFloatExtra("altura", -1)));
        lblBase.setText("Base: " + String.valueOf(oldIntent.getFloatExtra("base", -1)));
        lblNombre.setText(oldIntent.getStringExtra("nombre"));

        rectangulo.setAltura(oldIntent.getFloatExtra("altura", -1));
        rectangulo.setBase(oldIntent.getFloatExtra("base", -1));


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (calcular){
                    case "Area":
                        lblResultado.setText("El área es: " + String.valueOf(rectangulo.calcularArea()));
                        break;

                    case "Perimetro":
                        lblResultado.setText("El área es: " + String.valueOf(rectangulo.calcularPerimetro()));
                        break;

                    default:
                        Toast.makeText(RectanguloActivity.this,
                                "Por favor seleccione la operación a realizar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(RectanguloActivity.this, MainActivity.class);
                //startActivity(intent);
                RectanguloActivity.this.finish();
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.btnArea:
                if(checked) calcular = "Area";
                break;

            case R.id.btnPerimetro:
                if(checked) calcular = "Perimetro";
                break;
        }
    }
}
