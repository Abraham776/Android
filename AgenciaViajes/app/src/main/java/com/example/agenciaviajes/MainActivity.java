package com.example.agenciaviajes;

import static java.lang.String.valueOf;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Layout principal
    private ScrollView vistaPrincipal;
    private Button btnConfirmar;
    private TextView lblFechaRegreso;
    private EditText txtNombre, txtFechaPartida, txtFechaRegreso, txtPrecio, txtEdad;
    private Spinner spnTipo, spnDestinos;
    private String tipo, destino;
    private Boleto boleto;
    //Layout secundario
    private TableLayout vistaSecundaria;
    private EditText txtNumero, txtFechaPartidaBoleto, txtNombreBoleto, txtFechaRegresoBoleto,
            txtDestinoBoleto, txtTipoViaje, txtPrecioBoleto, txtSubtotal, txtImpuesto, txtDescuento,
            txtTotal;
    private TextView lblFechaRegresoBoleto;
    private TableRow trFechaRegreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Layout principal
        txtEdad = findViewById(R.id.txtEdad);
        vistaPrincipal = findViewById(R.id.vistaPrincipal);
        btnConfirmar = findViewById(R.id.btnConfirmar);
        txtNombre = findViewById(R.id.txtNombre);
        txtFechaPartida = findViewById(R.id.datePartida);
        txtFechaRegreso = findViewById(R.id.dateRegreso);
        spnTipo = findViewById(R.id.spnTipo);
        spnDestinos = findViewById(R.id.spnDestinos);
        lblFechaRegreso = findViewById(R.id.lblFechaRegreso);
        txtPrecio = findViewById(R.id.txtPrecio);
        vistaSecundaria = findViewById(R.id.vistaSecundaria);

        //Layour Secundario
        txtNumero = findViewById(R.id.txtNumero);
        txtFechaPartidaBoleto = findViewById(R.id.txtFechaPartidaBoleto);
        txtNombreBoleto = findViewById(R.id.txtNombreBoleto);
        txtFechaRegresoBoleto = findViewById(R.id.txtFechaRegresoBoleto);
        txtDestinoBoleto = findViewById(R.id.txtDestinoBoleto);
        txtTipoViaje = findViewById(R.id.txtTipoViaje);
        txtPrecioBoleto = findViewById(R.id.txtPrecioBoleto);
        txtSubtotal = findViewById(R.id.txtSubtotal);
        txtImpuesto = findViewById(R.id.txtImpuesto);
        txtDescuento = findViewById(R.id.txtDescuento);
        txtTotal = findViewById(R.id.txtTotal);
        lblFechaRegresoBoleto = findViewById(R.id.lblFechaRegresoBoleto);
        trFechaRegreso = findViewById(R.id.trFechaRegreso);

        //Spinner selecter
        ArrayAdapter<String> adapterDestinos = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1,
                getResources().getStringArray(R.array.destinos));
        ArrayAdapter<String> adapterTipos = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1,
                getResources().getStringArray(R.array.tipos));

        spnDestinos.setAdapter(adapterDestinos);
        spnTipo.setAdapter(adapterTipos);

        spnDestinos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                destino = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spnTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tipo = parent.getItemAtPosition(position).toString();
                if(tipo.equals("Redondo")){
                    lblFechaRegreso.setVisibility(View.VISIBLE);
                    txtFechaRegreso.setVisibility(View.VISIBLE);
                    return;
                }
                lblFechaRegreso.setVisibility(View.GONE);
                txtFechaRegreso.setVisibility(View.GONE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Date picker
        txtFechaRegreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker(txtFechaRegreso);
            }
        });
        txtFechaPartida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker(txtFechaPartida);
            }
        });

        //Botón confirmar
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tipoEntero = 1;
                if(txtNombre.getText().toString().equals("") || txtFechaPartida.getText().toString().equals("") ||
                        tipo.equals("") || destino.equals("") || txtPrecio.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Por favor rellene todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(tipo.equals("Redondo") && txtFechaRegreso.equals("")){
                    Toast.makeText(MainActivity.this, "Por favor rellene todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(tipo.equals("Redondo")){
                    tipoEntero = 2;
                }
                boleto = new Boleto(1, tipoEntero, txtNombre.getText().toString(), destino, txtFechaPartida.getText().toString(),
                        txtFechaRegreso.getText().toString(), Float.parseFloat(txtPrecio.getText().toString()));

                vistaPrincipal.setVisibility(View.GONE);
                vistaSecundaria.setVisibility(View.VISIBLE);

                if(tipo.equals("Redondo")){
                    trFechaRegreso.setVisibility(View.VISIBLE);
                }

                txtNumero.setText(String.valueOf(boleto.getId()));
                txtFechaPartidaBoleto.setText(boleto.getFecha());
                txtNombreBoleto.setText(boleto.getNombre());
                txtFechaRegresoBoleto.setText(boleto.getFechaRegreso());
                txtDestinoBoleto.setText(boleto.getDestino());
                txtTipoViaje.setText("Redondo");

                if(boleto.getTipo() == 1) txtTipoViaje.setText("Sencillo");

                txtPrecioBoleto.setText(String.format("%.2f", boleto.getPrecio()));
                txtSubtotal.setText(String.format("%.2f", boleto.calcularPrecio()));
                txtImpuesto.setText(String.format("%.2f", boleto.calcularIVA()));
                txtDescuento.setText(String.format("%.2f", boleto.calcularDescuento(Integer.parseInt(txtEdad.getText().toString()))));
                txtTotal.setText(String.format("%.2f", boleto.calcularTotal(Integer.parseInt(txtEdad.getText().toString()))));


            }
        });
    }

    private void showDatePicker(EditText fecha){
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because January is zero
                final String selectedDate = day + " / " + (month+1) + " / " + year;
                fecha.setText(selectedDate);
            }
        });

        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}