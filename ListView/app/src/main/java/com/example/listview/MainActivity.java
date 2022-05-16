package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView spnPaises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnPaises = findViewById(R.id.spnPaises);
        ArrayAdapter<String> Adaptor = new ArrayAdapter<String> (MainActivity.this, android.R.layout.simple_expandable_list_item_1, getResources().getStringArray(R.array.paises));
        spnPaises.setAdapter(Adaptor);

        spnPaises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Selecciono el país " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}