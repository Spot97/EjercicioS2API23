package com.example.ejercicios2api23;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityDetalles extends AppCompatActivity {
    EditText etNombre,etApellido;
    ListView lvProfesores;
    ArrayList profesores;
    Button btnGrabar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        btnGrabar = findViewById(R.id.btnGrabar);
        lvProfesores = findViewById(R.id.lvProfesores);
        profesores=new ArrayList<String>();


        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,profesores);
        lvProfesores.setAdapter(adapter);
        btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profesores.add(etNombre.getText().toString()+" "+etApellido.getText().toString());
                lvProfesores.deferNotifyDataSetChanged();
            }
        });

        lvProfesores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ActivityDetalles.this,profesores.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
