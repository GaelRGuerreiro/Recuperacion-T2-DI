package com.example.f1racinglpg;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class InicioFragment extends Fragment {
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
        View layout = inflater.inflate(R.layout.inicio_fragment, container, false);
        recyclerView = layout.findViewById(R.id.inicio_recycler); // Obtener una referencia al RecyclerView desde el diseño
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                ((LinearLayoutManager) recyclerView.getLayoutManager()).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        nombreCircuito= layout.findViewById(R.id.circuitNameTextView);

        // Realizar la solicitud JSON utilizando Volley
        String url = "https://ergast.com/api/f1/current/last/results.json";
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{

                        JSONArray races = response.getJSONObject("MRData")
                                .getJSONObject("RaceTable")
                                .getJSONArray("Races");
                        List  <CorredorData> allTheData = new ArrayList<>();

                        JSONObject race = races.getJSONObject(0);

                            JSONObject circuit = race.getJSONObject("Circuit");
                            String circuitName = circuit.getString("circuitName");
                            nombreCircuito.setText(circuitName);


                        }catch(Exception e){}



                            // Llamar al método parseJson para parsear la respuesta JSON
                        List<CorredorData> corredorDataArray = parseJson(response);

                        // Prueba para trabajar si no va la pagina
                        //new ArrayList<>();
                       // CorredorData x = new CorredorData("MAX","Opel","2","1:21:21.123","18");
                       //corredorDataArray.add(x);
                        if (corredorDataArray != null) {
                            // Crear un adaptador con los datos parseados y configurar el RecyclerView
                            InicioViewAdapter adapter = new InicioViewAdapter(corredorDataArray, activity);
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
                        Toast.makeText(activity, "Error en la solicitud: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );

        // Agregar la solicitud a la cola de Volley para su procesamiento.
        RequestQueue queue = Volley.newRequestQueue(activity);
        queue.add(request);

        return layout;
    }




    private List<CorredorData> parseJson(JSONObject response) {
        try {
            JSONArray races = response.getJSONObject("MRData")
                    .getJSONObject("RaceTable")
                    .getJSONArray("Races");
            List   <CorredorData> allTheData = new ArrayList<>();

                JSONObject race = races.getJSONObject(0);
                JSONArray results = race.getJSONArray("Results");
            for (int i = 0; i < results.length(); i++) {
                JSONObject result = results.getJSONObject(i);
                JSONObject circuit = race.getJSONObject("Circuit");

                String driverName = result.getJSONObject("Driver").getString("code");
                String constructorName = result.getJSONObject("Constructor").getString("name");
                String position = result.getString("position");
                String points = "+"+result.getString("points");
                String time="";
                try {
                     time = result.getJSONObject("Time").getString("time");
                }catch(JSONException e){
                     time = "0:00:00";
                }
                CorredorData data = new CorredorData( driverName, constructorName, position, time,points );
                allTheData.add(data);
            }

            // Convertir la lista de objetos InicioData a un array
            return allTheData;
        } catch (JSONException e) {
            e.printStackTrace();
            return null; // Devolver null en caso de error
        }
    }
}





