package com.example.f1racinglpg.CamConstructores;

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

public class CamConsFragment extends Fragment {
    private RecyclerView recyclerView;
    private Activity activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.camcons_fragment, container, false);
        recyclerView = layout.findViewById(R.id.camcons_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                ((LinearLayoutManager) recyclerView.getLayoutManager()).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        String url = "https://ergast.com/api/f1/current/constructorStandings.json";
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        // Llamar al método parseJson para parsear la respuesta JSON
                        List<CamConsData> consDataArray = parseJson(response);


                        if (consDataArray != null) {
                            // Crear un adaptador con los datos parseados y configurar el RecyclerView
                            CamConsViewAdapter adapter = new CamConsViewAdapter(consDataArray, activity);
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




    private List<CamConsData> parseJson(JSONObject response) {
        try {
            JSONArray drivers = response.getJSONObject("MRData")
                    .getJSONObject("StandingsTable")
                    .getJSONArray("StandingsLists");
            List   <CamConsData> allTheData = new ArrayList<>();

            JSONObject driver = drivers.getJSONObject(0);
            JSONArray results = driver.getJSONArray("ConstructorStandings");
            for (int i = 0; i < results.length(); i++) {
                JSONObject result = results.getJSONObject(i);


                String constructorName = result.getJSONObject("Constructor").getString("name");
                String position = result.getString("position");
                String points = result.getString("points");
                String wins = result.getString("wins");
                String nationality = result.getJSONObject("Constructor").getString("nationality");

                CamConsData data = new CamConsData( position,points,wins,constructorName,nationality);
                allTheData.add(data);
            }

            return allTheData;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}






