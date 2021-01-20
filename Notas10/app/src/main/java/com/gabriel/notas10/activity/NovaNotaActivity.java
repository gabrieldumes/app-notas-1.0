package com.gabriel.notas10.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gabriel.notas10.R;
import com.gabriel.notas10.model.Nota;

import java.util.ArrayList;
import java.util.List;

public class NovaNotaActivity extends AppCompatActivity {

    private EditText editTitulo, editNota;
    private Button buttonSalvar, buttonDescartar;
    private List<Nota> listaNotas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_nota);

        editTitulo = findViewById(R.id.editTitulo);
        editNota = findViewById(R.id.editNota);

        buttonSalvar = findViewById(R.id.buttonSalvar);
        buttonDescartar = findViewById(R.id.buttonDescartar);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textoTitulo = editTitulo.getText().toString();
                String textoNota = editNota.getText().toString();

                Nota nota = new Nota(textoTitulo, textoNota);
                listaNotas.add(nota);

                Intent intent = new Intent(getApplicationContext(), VerNotasActivity.class);
                Bundle bundle = new Bundle();

                bundle.putParcelableArrayList("listaNotas", (ArrayList<Nota>) listaNotas);
                intent.putExtra("dados", bundle);

                Toast.makeText(getApplicationContext(), "Nota salva com sucesso!", Toast.LENGTH_LONG).show();

                finish();

            }
        });

        buttonDescartar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }
}
