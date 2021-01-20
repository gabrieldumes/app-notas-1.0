package com.gabriel.notas10.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gabriel.notas10.R;
import com.gabriel.notas10.activity.MainActivity;
import com.gabriel.notas10.model.Nota;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Nota> listaNotas;

    public Adapter(List<Nota> listaNotas){

        this.listaNotas = listaNotas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_recycler_ver_notas, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Nota nota = this.listaNotas.get(position);

        holder.textTitulo.setText(nota.getTitulo());
        holder.textNota.setText(nota.getNota());
    }

    @Override
    public int getItemCount() {
        return this.listaNotas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView textTitulo, textNota;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textTitulo = itemView.findViewById(R.id.textTitulo);
            textNota = itemView.findViewById(R.id.textNota);
        }
    }
}
