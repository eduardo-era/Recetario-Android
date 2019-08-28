package com.example.recetera2;

public class listaderecetas {

    String imagen_receta,nombre_receta,tipo,ingredientes,preparacion,tiempo_de_preparacion;

    public void setImagen_receta(String imagen_receta) {
        this.imagen_receta = imagen_receta;
    }

    public void setNombre_receta(String nombre_receta) {
        this.nombre_receta = nombre_receta;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    public void setTiempo_de_preparacion(String tiempo_de_preparacion) {
        this.tiempo_de_preparacion = tiempo_de_preparacion;
    }

    public listaderecetas() {

    }

    public  listaderecetas(String imagen_receta,String nombre_receta,String tipo, String ingredientes,String preparacion,String tiempo_de_preparacion)
    {
        this.imagen_receta=imagen_receta;
        this.nombre_receta=nombre_receta;
        this.tipo=tipo;
        this.ingredientes=ingredientes;
        this.preparacion=preparacion;
        this.tiempo_de_preparacion=tiempo_de_preparacion;
    }

    public String getImagen_receta() {
        return imagen_receta;
    }

    public String getNombre_receta() {
        return nombre_receta;
    }

    public String getTipo() {
        return tipo;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public String getTiempo_de_preparacion() {
        return tiempo_de_preparacion;
    }


}
