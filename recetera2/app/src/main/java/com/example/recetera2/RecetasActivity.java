package com.example.recetera2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.Arrays;

public class RecetasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas);

        String imagen = getIntent().getExtras().getString("imagen_receta");
        String nombre = getIntent().getExtras().getString("nombre_receta");
        String tipo = getIntent().getExtras().getString("tipo");
        String ingredientes = getIntent().getExtras().getString("ingredientes");
        String preparacion = getIntent().getExtras().getString("preparacion");
        String tiempo = getIntent().getExtras().getString("tiempo_de_preparacion");


        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);


        TextView re_name = findViewById(R.id.r_recetaname);
        TextView re_tipo = findViewById(R.id.r_tiopodereceta);
        TextView re_tiempo = findViewById(R.id.r_tiempo_preparacion);
        TextView re_ingredientes = findViewById(R.id.r_ingredientes);
        TextView re_preparacion = findViewById(R.id.r_preparacion);

        ImageView img = findViewById(R.id.r_thumbnail);


        re_name.setText(nombre);
        re_tipo.setText(tipo);
        re_tiempo.setText(tiempo);
        String ingre = ingredientes;
        try {
            JSONArray jsonArray = new JSONArray(ingre);
            String[] strArr = new String[jsonArray.length()];

            for(int i = 0; i<jsonArray.length(); i++)
            {
                strArr[i]=jsonArray.getString(i);
            }

            for(int i = 0; i<jsonArray.length(); i++){
                re_ingredientes.append("\n");
                re_ingredientes.append("►");
                re_ingredientes.append(strArr[i]);
                re_ingredientes.append("\n");

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String prep = preparacion;
        try {
            JSONArray jsonArray2 = new JSONArray(prep);
            String[] strArr2 = new String[jsonArray2.length()];

            for(int i = 0; i<jsonArray2.length(); i++)
            {
                strArr2[i]=jsonArray2.getString(i);
            }

            for(int i = 0; i<jsonArray2.length(); i++){
                re_preparacion.append("\n");
                re_preparacion.append((i+1)+"-");
                re_preparacion.append(strArr2[i]);
                re_preparacion.append("\n");

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Glide.with(this).load(imagen).into(img);

    }
}
