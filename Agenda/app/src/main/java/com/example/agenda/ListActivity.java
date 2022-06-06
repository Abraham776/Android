package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ListActivity extends AppCompatActivity{
    private TextView lblUser;
    private ListView lstAlumnos;
    private ArrayAdapter<String> adapter;
    private androidx.appcompat.widget.SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lblUser = findViewById(R.id.lblUsuario);
        lstAlumnos = findViewById(R.id.lstAlumnos);
        searchView = findViewById(R.id.searchBar);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, getResources().getStringArray(R.array.alumnos));
        lstAlumnos.setAdapter(adapter);

        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                ListActivity.this.adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ListActivity.this.adapter.getFilter().filter(newText);
                return false;
            }
        });

        Bundle data = getIntent().getExtras();
        lblUser.setText(data.getString("user"));
        Usuario user = (Usuario) data.getSerializable("user");

        lblUser.setText(user.getNombreCompleto());
    }

}