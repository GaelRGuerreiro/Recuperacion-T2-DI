package com.example.f1racinglpg.Circuitos;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.f1racinglpg.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CircuitoFragment extends Fragment {
    private RecyclerView recyclerView;
    private Activity activity;
    private TextView nombreCircuito;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.circuito_fragment, container, false);
        recyclerView = layout.findViewById(R.id.circuito_recycler); // Obtener una referencia al RecyclerView desde el diseño
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                ((LinearLayoutManager) recyclerView.getLayoutManager()).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        String url = "https://raw.githubusercontent.com/GaelRGuerreiro/Recuperacion-T2-DI/main/circuitos.json";
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        // Llamar al método parseJson para parsear la respuesta JSON
                        List<CircuitoData> circuitoDataArray = parseJson(response);


                        if (circuitoDataArray != null) {
                            // Crear un adaptador con los datos parseados y configurar el RecyclerView
                            CircuitoViewAdapter adapter = new CircuitoViewAdapter(circuitoDataArray, activity);
                            recyclerView.setAdapter(adapter);
                            recyclerView.setLayoutManager(new LinearLayoutManager(activity));
                        } else {
                            // Manejar el caso en que ocurra un error al parsear la respuesta JSON
                            Toast.makeText(activity, "Error al parsear la respuesta JSON", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Manejar los errores de la solicitud y mostrar un Toast con el mensaje de error.
                        Toast.makeText(activity, "Error en la solicitud: " + error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        );

        // Agregar la solicitud a la cola de Volley para su procesamiento.
        RequestQueue queue = Volley.newRequestQueue(activity);
        queue.add(request);

        return layout;
    }




    private List<CircuitoData> parseJson(JSONObject response) {
        try {
            JSONArray circuits = response.getJSONObject("MRData")
                    .getJSONObject("CircuitTable")
                    .getJSONArray("Circuits");
            List<CircuitoData> allCircuits = new ArrayList<>();

            for (int i = 0; i < circuits.length(); i++) {
                JSONObject circuit = circuits.getJSONObject(i);
                JSONObject location = circuit.getJSONObject("Location");
                String circuitUrl = circuit.getString("url");
                String circuitName = circuit.getString("circuitName");
                String locality = location.getString("locality");
                String country = location.getString("country");
                String latitud = location.getString("lat");
                String longitud = location.getString("long");
                CircuitoData data = new CircuitoData( circuitUrl,circuitName,latitud,longitud, locality, country);
                allCircuits.add(data);
            }

            return allCircuits;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}





