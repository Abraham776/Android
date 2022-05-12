package com.example.app01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button btnSaludar, btnLimpiar, btnSalir;
    private TextView lblSaludo;
    private EditText txtNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSaludar = findViewById(R.id.btnSaludo);
        lblSaludo = findViewById(R.id.lblSaludo);
        txtNombre = findViewById(R.id.txtSaludo);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnSalir = findViewById(R.id.btnSalir);

        btnSaludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtNombre.getText().toString().matches("")) {
                    Toast.makeText(MainActivity.this,
                            "Pero que haya textos chidos",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                lblSaludo.setText("Hola " + txtNombre.getText().toString() + " ¿Cómo estás? <3");
            }
        });
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblSaludo.setText("");
                txtNombre.setText("");
            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });
    }
}
