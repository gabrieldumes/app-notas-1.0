package com.gabriel.notas10.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.gabriel.notas10.R;
import com.gabriel.notas10.adapter.Adapter;
import com.gabriel.notas10.model.Nota;

import java.util.ArrayList;
import java.util.List;

public class VerNotasActivity extends AppCompatActivity {

    private RecyclerView recyclerVerNotas;
    private List<Nota> listaNotas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_notas);

        recyclerVerNotas = findViewById(R.id.recyclerVerNotas);

        Bundle dados = getIntent().getExtras();
        if (dados != null) {
            this.listaNotas = dados.getParcelableArrayList("listaNotas");
        }

        //adapter
        Adapter adapter = new Adapter(this.listaNotas);

        //configurar o RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerVerNotas.setLayoutManager(layoutManager);
        recyclerVerNotas.setAdapter(adapter);
    }

    public void recuperarNotas(){

        Bundle dados = getIntent().getExtras();

        Nota nota = (Nota) dados.getSerializable("nota");
        listaNotas.add(nota);
    }
}
