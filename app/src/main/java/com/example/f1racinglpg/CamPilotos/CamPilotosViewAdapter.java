package com.example.f1racinglpg.CamPilotos;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.f1racinglpg.R;

import java.util.List;

public class CamPilotosViewAdapter extends RecyclerView.Adapter<CamPilotosViewHolder> {

    private List<CamPilotoData> drivers;
    private Activity activity;

    // Constructor que recibe la lista de datos y la actividad asociada.
    public CamPilotosViewAdapter(List<CamPilotoData> dataSet, Activity activity) {
        this.drivers = dataSet;
        this.activity = activity;
    }

    @NonNull
    @Override
    // Método llamado para crear una nueva instancia de FilmViewHolder
    public CamPilotosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View camPilotoView = LayoutInflater.from(parent.getContext()).inflate(R.layout.campilotos_recycler_cell, parent, false);
        return new CamPilotosViewHolder(camPilotoView);
    }


    // Método llamado para actualizar el contenido de un FilmViewHolder específico.
    @Override
    public void onBindViewHolder(@NonNull CamPilotosViewHolder holder, int position) {
        CamPilotoData dataForThisCell = drivers.get(position);
        holder.bind(dataForThisCell);
    }



    @Override
    public int getItemCount() {
        return drivers.size();
    }
}
