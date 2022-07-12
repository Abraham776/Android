package com.example.recycleview;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class AlumnoAlta extends AppCompatActivity {
    private Button btnGuardar, btnRegresar, btnImagen;
    private Alumno alumno;
    private EditText txtNombre, txtMatricula, txtGrado;
    private ImageView imgAlumno;
    private int posicion;
    private Uri imgURI;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_alumnos_alta);
        btnGuardar = (Button) findViewById(R.id.btnSalir);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);
        btnImagen = (Button) findViewById(R.id.btnCargar);
        txtGrado = findViewById(R.id.txtGrado);
        txtMatricula = findViewById(R.id.txtMatricula);
        txtNombre = findViewById(R.id.txtNombre);
        imgAlumno = findViewById(R.id.imgAlumno);

        Bundle bundle = getIntent().getExtras();
        alumno = (Alumno) bundle.getSerializable("alumno");
        posicion = bundle.getInt("posicion", posicion);

        if(posicion >= 0){
            txtMatricula.setText(alumno.getMatricula());
            txtNombre.setText(alumno.getNombre());
            txtGrado.setText(alumno.getCarrera());
            imgAlumno.setImageURI(Uri.parse(alumno.getImgURI()));
        }

        btnImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageChooser();
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(alumno == null){
                    alumno = new Alumno();
                    alumno.setCarrera(txtGrado.getText().toString());
                    alumno.setMatricula(txtMatricula.getText().toString());
                    alumno.setNombre(txtNombre.getText().toString());
                    alumno.setImgURI(imgURI.toString());

                    if(validar()){
                        Aplicacion.getAlumnos().add(alumno);
                        setResult(Activity.RESULT_OK);
                        finish();
                    } else {
                        Toast.makeText(AlumnoAlta.this, "Falto capturar datos", Toast.LENGTH_SHORT).show();
                        txtMatricula.requestFocus();
                    }
                }

                if(posicion >= 0){
                    alumno.setMatricula(txtMatricula.getText().toString());
                    alumno.setNombre(txtNombre.getText().toString());
                    alumno.setCarrera(txtGrado.getText().toString());
                    alumno.setImgURI(imgURI.toString());

                    Aplicacion.getAlumnos().get(posicion).setMatricula(alumno.getMatricula());
                    Aplicacion.getAlumnos().get(posicion).setNombre(alumno.getNombre());
                    Aplicacion.getAlumnos().get(posicion).setCarrera(alumno.getCarrera());
                    Aplicacion.getAlumnos().get(posicion).setImgURI(alumno.getImgURI());

                    Toast.makeText(AlumnoAlta.this, "Se modificó con exito", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });
    }

    private void imageChooser() {
        Intent i = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        i.setType("image/*");

        startActivityForResult(Intent.createChooser(i, "Seleccione una imagen"), 200);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == 200) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    imgAlumno.setImageURI(selectedImageUri);
                    imgURI = selectedImageUri;

                    ContentResolver cr = getApplicationContext().getContentResolver();
                    cr.takePersistableUriPermission(imgURI, Intent.FLAG_GRANT_READ_URI_PERMISSION);

                }
            }
        }
    }

    private boolean validar(){
        boolean exito = true;
        Log.d("nombre", "validar " + txtNombre.getText());

        if(txtNombre.getText().toString().equals("")) exito = false;
        if(txtMatricula.getText().toString().equals("")) exito = false;
        if(txtGrado.getText().toString().equals("")) exito = false;

        return exito;
    }
}
