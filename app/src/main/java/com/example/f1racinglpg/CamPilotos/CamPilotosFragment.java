package com.example.f1racinglpg.CamPilotos;

import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.f1racinglpg.Circuitos.CircuitoData;
import com.example.f1racinglpg.Circuitos.CircuitoViewAdapter;
import com.example.f1racinglpg.Inicio.CorredorData;
import com.example.f1racinglpg.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CamPilotosFragment extends Fragment {
    private RecyclerView recyclerView;
    private Activity activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.campilotos_fragment, container, false);
        recyclerView = layout.findViewById(R.id.campilotos_recycler); // Obtener una referencia al RecyclerView desde el diseño
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                ((LinearLayoutManager) recyclerView.getLayoutManager()).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        String url = "https://ergast.com/api/f1/current/driverStandings.json";
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        // Llamar al método parseJson para parsear la respuesta JSON
                        List<CamPilotoData> pilotoDataArray = parseJson(response);


                        if (pilotoDataArray != null) {
                            // Crear un adaptador con los datos parseados y configurar el RecyclerView
                           CamPilotosViewAdapter adapter = new CamPilotosViewAdapter(pilotoDataArray, activity);
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




    private List<CamPilotoData> parseJson(JSONObject response) {
        try {
            JSONArray drivers = response.getJSONObject("MRData")
                    .getJSONObject("StandingsTable")
                    .getJSONArray("StandingsLists");
            List   <CamPilotoData> allTheData = new ArrayList<>();

            JSONObject driver = drivers.getJSONObject(0);
            JSONArray results = driver.getJSONArray("DriverStandings");
            for (int i = 0; i < results.length(); i++) {
                JSONObject result = results.getJSONObject(i);

                String driverCode = result.getJSONObject("Driver").getString("code");
                String driverName = result.getJSONObject("Driver").getString("givenName")+" "+result.getJSONObject("Driver").getString("familyName");
                String constructorName = result.getJSONArray("Constructors").getJSONObject(0).getString("name");
                String position = result.getString("position");
                String points = result.getString("points");
                String wins = result.getString("wins");
                String birth = result.getJSONObject("Driver").getString("dateOfBirth");
                String nationality = result.getJSONObject("Driver").getString("nationality");
                String permanentNumber=result.getJSONObject("Driver").getString("permanentNumber");

                CamPilotoData data = new CamPilotoData( position,points,wins,driverName,constructorName,driverCode,birth,nationality,permanentNumber);
                allTheData.add(data);
            }

            return allTheData;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}






