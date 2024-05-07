package com.example.f1racinglpg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class CircuitDetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    private TextView nombreCircuito;
    private TextView country;
    private TextView locality;
    private ImageView imageCircuit;
    private GoogleMap mMap;

    // Variables de instancia para latitud y longitud del circuito
    private String circuitLat;
    private String circuitLng;
    private String circuito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circuitdetail);



        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);




        ImageButton btnZoomIn = findViewById(R.id.btnZoomIn);
        btnZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aumentar el nivel de zoom
                mMap.animateCamera(CameraUpdateFactory.zoomIn());
            }
        });

        ImageButton btnZoomOut = findViewById(R.id.btnZoomOut);
        btnZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Disminuir el nivel de zoom
                mMap.animateCamera(CameraUpdateFactory.zoomOut());
            }
        });

        // Aquí puedes agregar el código necesario para inicializar y mostrar los detalles del circuito en la pantalla de detalles.
        // Por ejemplo, puedes obtener datos del Intent que inició esta actividad.
        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra("circuitUrl");
        circuitLng = intent.getStringExtra("long");
        circuitLat = intent.getStringExtra("lat");
        String circuitName = intent.getStringExtra("circuitName");
        String localidad = intent.getStringExtra("locality");
        String pais = intent.getStringExtra("country");
        String circuito = intent.getStringExtra("circuitName");

        // Cambiar el nombre del TextView de la clase para evitar conflictos
        nombreCircuito = findViewById(R.id.nombreCircuito);
        locality = findViewById(R.id.localidad);
        country=findViewById(R.id.pais);
        imageCircuit=findViewById(R.id.imageCircuit);

        // Actualizar los TextView con los datos correctos
        nombreCircuito.setText(circuitName);
        locality.setText(localidad);
        country.setText(pais);
        Util.downloadBitmapToImageView(imageUrl, this.imageCircuit);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        double CircuitLng = Double.parseDouble(circuitLng);
        double CircuitLat = Double.parseDouble(circuitLat);
        LatLng circuitLocation = new LatLng(CircuitLat, CircuitLng);
        mMap.addMarker(new MarkerOptions().position(circuitLocation).title(circuito));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(circuitLocation, 15));
    }
}





















