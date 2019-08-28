package com.example.recetera2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.example.recetera2.interfaces.IComunicaFragments;

public class MainActivity extends AppCompatActivity implements IComunicaFragments, InicioFragment.OnFragmentInteractionListener {

    Fragment fragmentInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentInicio=new InicioFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragments,fragmentInicio).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void selectpostres() {

        Intent intent = new Intent(this,seleccion_recetas.class);
        intent.putExtra("seleccion","recetas_postres");
        startActivity(intent);
    }

    @Override
    public void selectdesayuno() {

        Intent intent = new Intent(this,seleccion_recetas.class);
        intent.putExtra("seleccion","recetas_desayuno");
        startActivity(intent);

    }

    @Override
    public void selectfritos() {

        Intent intent = new Intent(this,seleccion_recetas.class);
        intent.putExtra("seleccion","recetas_fritas");
        startActivity(intent);
    }

    @Override
    public void selectsaludable() {

        Intent intent = new Intent(this,seleccion_recetas.class);
        intent.putExtra("seleccion","recetas_saludable");
        startActivity(intent);
    }

    @Override
    public void selectrapida() {


        Intent intent = new Intent(this,seleccion_recetas.class);
        intent.putExtra("seleccion","recetas_rapida");
        startActivity(intent);
    }

    @Override
    public void selectbebidas() {

        Intent intent = new Intent(this,seleccion_recetas.class);
        intent.putExtra("seleccion","recetas_bebidas");
        startActivity(intent);
    }
}
