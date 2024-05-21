package com.example.f1racinglpg.CamConstructores;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.f1racinglpg.R;
import com.example.f1racinglpg.Util;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class CamConsDetail extends AppCompatActivity  {

    private TextView constructor;
    private TextView nationality;
    private TextView points;
    private TextView wins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consdetail);



        Intent intent = getIntent();
        String Constructor = intent.getStringExtra("name");
        String Wins = intent.getStringExtra("wins");
        String Nationality = intent.getStringExtra("nationality");
        String Points = intent.getStringExtra("points");


        constructor = findViewById(R.id.textViewEscuderia);
        wins=findViewById(R.id.textViewVictorias);
        nationality=findViewById(R.id.textViewNacionalidad);
        points=findViewById(R.id.textViewPuntos);


        constructor.setText(Constructor);
        wins.setText(Wins);
        nationality.setText(Nationality);
        points.setText(Points);

    }

}





















