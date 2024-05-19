package com.example.f1racinglpg.Inicio;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.f1racinglpg.R;

import java.util.List;

public class InicioViewAdapter extends RecyclerView.Adapter<InicioViewHolder> {

    private List<CorredorData> race;
    private Activity activity;

    // Constructor que recibe la lista de datos y la actividad asociada.
    public InicioViewAdapter(List<CorredorData> dataSet, Activity activity) {
        this.race = dataSet;
        this.activity = activity;
    }

    @NonNull
    @Override
    // Método llamado para crear una nueva instancia de FilmViewHolder
    public InicioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inicioView = LayoutInflater.from(parent.getContext()).inflate(R.layout.inicio_recycler_cell, parent, false);
        return new InicioViewHolder(inicioView);
    }


    // Método llamado para actualizar el contenido de un FilmViewHolder específico.
    @Override
    public void onBindViewHolder(@NonNull InicioViewHolder holder, int position) {
        CorredorData dataForThisCell = race.get(position);
        holder.bind(dataForThisCell);


    }



    @Override
    public int getItemCount() {
        return race.size();
    }
}
