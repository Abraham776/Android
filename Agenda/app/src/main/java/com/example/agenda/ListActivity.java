package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {
    private TextView lblUser;
    private ListView lstAlumnos;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lblUser = findViewById(R.id.lblUsuario);
        lstAlumnos = findViewById(R.id.lstAlumnos);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, getResources().getStringArray(R.array.alumnos));
        lstAlumnos.setAdapter(adapter);

        Bundle data = getIntent().getExtras();
        lblUser.setText(data.getString("user"));
        Usuario user = (Usuario) data.getSerializable("user");

        lblUser.setText(user.getNombreCompleto());
    }
}