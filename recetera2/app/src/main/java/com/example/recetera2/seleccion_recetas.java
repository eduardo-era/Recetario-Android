package com.example.recetera2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class seleccion_recetas extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<listaderecetas> reli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_recetas);

        recyclerView = findViewById(R.id.recyclerviewid);
        reli = new ArrayList<>();


        jsonrequest();

    }

    private void jsonrequest() {

        JSONObject obj = null;

        try {
            Bundle extra = getIntent().getExtras();
            String select = extra.getString("seleccion");
            obj = new JSONObject(loadJSONFromAsset(select+".json"));
            JSONArray m_jArray = obj.getJSONArray("recetas");

            for (int i = 0; i < m_jArray.length(); i++)
            {
                JSONObject jo_inside = m_jArray.getJSONObject(i);
                listaderecetas listrece = new listaderecetas();
                listrece.setNombre_receta(jo_inside.getString("nombre_receta"));
                listrece.setTipo(jo_inside.getString("tipo"));
                listrece.setTiempo_de_preparacion(jo_inside.getString("tiempo_de_preparacion"));
                listrece.setIngredientes(jo_inside.getString("ingredientes"));
                listrece.setPreparacion(jo_inside.getString("preparacion"));
                listrece.setImagen_receta(jo_inside.getString("imagen_receta"));

                reli.add(listrece);

            }
            setuprecyclerview(reli);

        }catch (JSONException e){

            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"llega hasta aqui",Toast.LENGTH_SHORT).show();

        }
    }

    private void setuprecyclerview(List<listaderecetas> reli) {

        RecyclerViewAdapter myadapter  = new RecyclerViewAdapter(this,reli);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);
    }


    public String loadJSONFromAsset(String flName) {
        String json;
        try {
            InputStream is = this.getAssets().open(flName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {

            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
