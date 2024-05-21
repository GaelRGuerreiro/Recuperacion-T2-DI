package com.example.f1racinglpg.CamConstructores;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.f1racinglpg.R;

public class CamConsViewHolder extends RecyclerView.ViewHolder {

    private TextView positionTextView;
    private TextView ConstructorTextView;
    private TextView pointsTextView;



    public CamConsViewHolder(@NonNull View itemView) {
        super(itemView);

        positionTextView = itemView.findViewById(R.id.positionTextView);
        ConstructorTextView = itemView.findViewById(R.id.ConstructorTextView);
        pointsTextView = itemView.findViewById(R.id.pointsTextView);
    }

    public void bind(CamConsData camConsData) {

        positionTextView.setText(camConsData.getPosition());
        ConstructorTextView.setText(camConsData.getName());
        pointsTextView.setText(camConsData.getPoints());
    }

    public static CamConsViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.camcons_recycler_cell, parent, false);
        return new CamConsViewHolder(view);
    }
}
