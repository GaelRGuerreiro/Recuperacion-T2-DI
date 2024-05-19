package com.example.f1racinglpg.CamPilotos;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
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


    @Override
    public void onBindViewHolder(@NonNull CamPilotosViewHolder holder, int position) {
        CamPilotoData dataForThisCell = drivers.get(position);
        holder.bind(dataForThisCell);

        // Configurar el OnClickListener para iniciar la actividad de detalles al hacer clic en el elemento del RecyclerView
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, CamPilotosDetailActivity.class);
                intent.putExtra("points", dataForThisCell.getPoints());
                intent.putExtra("wins", dataForThisCell.getWins());
                intent.putExtra("name", dataForThisCell.getName());
                intent.putExtra("constructor", dataForThisCell.getConstructor());
                intent.putExtra("birth", dataForThisCell.getBirth());
                intent.putExtra("nationality", dataForThisCell.getNationality());
                intent.putExtra("permanentNumber", dataForThisCell.getPermanentNumber());
                context.startActivity(intent);
            }
        });
    }





    @Override
    public int getItemCount() {
        return drivers.size();
    }
}
