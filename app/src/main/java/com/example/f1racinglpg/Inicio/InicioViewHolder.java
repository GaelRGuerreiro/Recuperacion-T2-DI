package com.example.f1racinglpg.Inicio;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.f1racinglpg.R;

public class InicioViewHolder extends RecyclerView.ViewHolder {

    private TextView circuitNameTextView;
    private TextView driverNameTextView;
    private TextView positionTextView;
    private TextView timeTextView;
    private TextView pointsTextView;

    public InicioViewHolder(@NonNull View itemView) {
        super(itemView);

        driverNameTextView = itemView.findViewById(R.id.driverNameTextView);
        positionTextView = itemView.findViewById(R.id.positionTextView);
        timeTextView = itemView.findViewById(R.id.timeTextView);
        pointsTextView = itemView.findViewById(R.id.pointsTextView);
    }

    public void bind(CorredorData corredorData) {
        driverNameTextView.setText(corredorData.getDriverName());
        positionTextView.setText(corredorData.getPosition());
        timeTextView.setText(corredorData.getTime());
        pointsTextView.setText(corredorData.getPoints());
    }

    public static InicioViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.inicio_recycler_cell, parent, false);
        return new InicioViewHolder(view);
    }
}
