package com.example.f1racinglpg;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CircuitoViewAdapter extends RecyclerView.Adapter<CircuitoViewHolder> {

    private List<CircuitoData> circuit;
    private Activity activity;

    // Constructor que recibe la lista de datos y la actividad asociada.
    public CircuitoViewAdapter(List<CircuitoData> dataSet, Activity activity) {
        this.circuit = dataSet;
        this.activity = activity;
    }

    @NonNull
    @Override
    // Método llamado para crear una nueva instancia de FilmViewHolder
    public CircuitoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View circuitoView = LayoutInflater.from(parent.getContext()).inflate(R.layout.circuito_recycler_cell, parent, false);
        return new CircuitoViewHolder(circuitoView);
    }


    @Override
    public void onBindViewHolder(@NonNull CircuitoViewHolder holder, int position) {
       CircuitoData dataForThisCell = circuit.get(position);
        holder.bind(dataForThisCell);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, CircuitDetailActivity.class);
                intent.putExtra("circuitUrl",dataForThisCell.getCircuitUrl());
                intent.putExtra("circuitName",dataForThisCell.getCircuitName());
                intent.putExtra("locality",dataForThisCell.getLocality());
                intent.putExtra("country",dataForThisCell.getCountry());
                intent.putExtra("lat",dataForThisCell.getLatitud());
                intent.putExtra("long",dataForThisCell.getLongitud());



                context.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return circuit.size();
    }
}
