package com.example.f1racinglpg.CamPilotos;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.f1racinglpg.R;

public class CamPilotosViewHolder extends RecyclerView.ViewHolder {

    private TextView driverNameTextView;
    private TextView positionTextView;
    private TextView ConstructorTextView;
    private TextView pointsTextView;
    private TextView winsTextView;
    private ImageView driverImageView;



    public CamPilotosViewHolder(@NonNull View itemView) {
        super(itemView);

        driverNameTextView = itemView.findViewById(R.id.driverNameTextView);
        positionTextView = itemView.findViewById(R.id.positionTextView);
        ConstructorTextView = itemView.findViewById(R.id.ConstructorTextView);
        pointsTextView = itemView.findViewById(R.id.pointsTextView);
        winsTextView=itemView.findViewById(R.id.winsTextView);
        driverImageView=itemView.findViewById(R.id.imageViewPiloto);
    }

    public void bind(CamPilotoData camPilotoData) {
        driverNameTextView.setText(camPilotoData.getCode());
        positionTextView.setText(camPilotoData.getPosition());
        ConstructorTextView.setText(camPilotoData.getConstructor());
        pointsTextView.setText(camPilotoData.getPoints());
        winsTextView.setText(camPilotoData.getWins());
    }

    public static CamPilotosViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.campilotos_recycler_cell, parent, false);
        return new CamPilotosViewHolder(view);
    }
}
