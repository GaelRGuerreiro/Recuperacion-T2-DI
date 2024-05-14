package com.example.f1racinglpg.CamPilotos;

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


public class CamPilotosDetailActivity extends AppCompatActivity  {

    private TextView nombrePiloto;
    private TextView constructor;
    private TextView nationality;
    private TextView points;
    private TextView wins;
    private TextView birth;
    private TextView permanentNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilotodetail);



        Intent intent = getIntent();
        String Piloto = intent.getStringExtra("name");
        String Constructor = intent.getStringExtra("constructor");
        String Birth = intent.getStringExtra("birth");
        String Wins = intent.getStringExtra("wins");
        String PermanentNumber = intent.getStringExtra("permanentNumber");
        String Nationality = intent.getStringExtra("nationality");
        String Points = intent.getStringExtra("points");


        nombrePiloto = findViewById(R.id.textViewNombre);
        constructor = findViewById(R.id.textViewEscuderia);
        birth=findViewById(R.id.textViewNacimiento);
        wins=findViewById(R.id.textViewVictorias);
        permanentNumber=findViewById(R.id.textViewNumber);
        nationality=findViewById(R.id.textViewNacionalidad);
        points=findViewById(R.id.textViewPuntos);


        nombrePiloto.setText(Piloto);
        constructor.setText(Constructor);
        birth.setText(Birth);
        wins.setText(Wins);
        permanentNumber.setText(PermanentNumber);
        nationality.setText(Nationality);
        points.setText(Points);

    }

}





















