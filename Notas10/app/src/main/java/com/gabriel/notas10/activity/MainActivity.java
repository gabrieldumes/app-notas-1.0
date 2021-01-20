package com.gabriel.notas10.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gabriel.notas10.R;
import com.gabriel.notas10.model.Nota;

public class MainActivity extends AppCompatActivity {

    private Button buttonNovaNota, buttonVerNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonNovaNota = findViewById(R.id.buttonNovaNota);
        buttonVerNotas = findViewById(R.id.buttonVerNotas);

        buttonNovaNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), NovaNotaActivity.class);
                startActivity(intent);
            }
        });

        buttonVerNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), VerNotasActivity.class);
                intent.putExtra("telaInicial", true);
                startActivity(intent);
            }
        });
    }
}
