package com.example.f1racinglpg.Circuitos;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.f1racinglpg.R;
import com.example.f1racinglpg.Util;

public class CircuitoViewHolder extends RecyclerView.ViewHolder {

    private TextView circuitNameTextView;
    private ImageView circuitImageView;

    public CircuitoViewHolder(@NonNull View itemView) {
        super(itemView);
        circuitImageView =itemView.findViewById(R.id.imagenRecycler);
        circuitNameTextView = itemView.findViewById(R.id.circuitNameTextView);
    }

    public void bind(CircuitoData circuitoData) {
        circuitNameTextView.setText(circuitoData.getCircuitName());
        Util.downloadBitmapToImageView(circuitoData.getCircuitUrl(), this.circuitImageView);


    }

    public static CircuitoViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.circuito_recycler_cell, parent, false);
        return new CircuitoViewHolder(view);
    }
}
