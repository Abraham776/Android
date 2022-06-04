package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText txtUser, txtPass;
    private Button btnIngresar;
    private Usuario user = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setup();

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtPass.getText().toString().equals(user.getContraseña()) && txtUser.getText().toString().equals(user.getUser())){
                    Intent intent = new Intent(LoginActivity.this,ListActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("user", user);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    return;
                }

                Toast.makeText(LoginActivity.this, "Credenciales no encontradas",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setup(){
        txtPass = findViewById(R.id.txtPass);
        txtUser = findViewById(R.id.txtUser);
        btnIngresar = findViewById(R.id.btnIngresar);

        user.setUser(getResources().getString(R.string.userName));
        user.setContraseña(getResources().getString(R.string.contraseña));
        user.setNombreCompleto(getResources().getString(R.string.nombre));
        user.setEmail(getResources().getString(R.string.email));
    }
}