package com.example.f1racinglpg.CamConstructores;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.f1racinglpg.R;

import java.util.List;

public class CamConsViewAdapter extends RecyclerView.Adapter<CamConsViewHolder> {

    private List<CamConsData> constructors;
    private Activity activity;

    // Constructor que recibe la lista de datos y la actividad asociada.
    public CamConsViewAdapter(List<CamConsData> dataSet, Activity activity) {
        this.constructors = dataSet;
        this.activity = activity;
    }

    @NonNull
    @Override
    // Método llamado para crear una nueva instancia de FilmViewHolder
    public CamConsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View camPilotoView = LayoutInflater.from(parent.getContext()).inflate(R.layout.camcons_recycler_cell, parent, false);
        return new CamConsViewHolder(camPilotoView);
    }


    // Método llamado para actualizar el contenido de un FilmViewHolder específico.
    @Override
    public void onBindViewHolder(@NonNull CamConsViewHolder holder, int position) {
        CamConsData dataForThisCell = constructors.get(position);
        holder.bind(dataForThisCell);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, CamConsDetail.class);
                intent.putExtra("points",dataForThisCell.getPoints());
                intent.putExtra("wins",dataForThisCell.getWins());
                intent.putExtra("name",dataForThisCell.getName());
                intent.putExtra("nationality",dataForThisCell.getNationality());

                context.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return constructors.size();
    }
}
