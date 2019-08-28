package com.example.recetera2;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolders> {

    private Context mContext;
    private List<listaderecetas> mData;
    RequestOptions option ;


    public RecyclerViewAdapter(Context mContext, List<listaderecetas> mData) {

        this.mContext = mContext;
        this.mData = mData;

        //opcion para la imagen

        option=new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

    }

    @NonNull
    @Override
    public MyViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater inflater = LayoutInflater .from(mContext);
        view = inflater.inflate(R.layout.recetas_item,parent,false );

        final MyViewHolders viewHolders = new MyViewHolders(view);
        viewHolders.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent(mContext,RecetasActivity.class);
                i.putExtra("imagen_receta",mData.get(viewHolders.getAdapterPosition()).getImagen_receta());
                i.putExtra("nombre_receta",mData.get(viewHolders.getAdapterPosition()).getNombre_receta());
                i.putExtra("tipo",mData.get(viewHolders.getAdapterPosition()).getTipo());
                i.putExtra("ingredientes",mData.get(viewHolders.getAdapterPosition()).getIngredientes());
                i.putExtra("preparacion",mData.get(viewHolders.getAdapterPosition()).getPreparacion());
                i.putExtra("tiempo_de_preparacion",mData.get(viewHolders.getAdapterPosition()).getTiempo_de_preparacion()

                );

                mContext.startActivity(i);

            }
        });

        return viewHolders;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolders holder, int position) {

        holder.re_name.setText(mData.get(position).getNombre_receta());
        holder.re_tipo.setText(mData.get(position).getTipo());
        holder.re_tiempo.setText(mData.get(position).getTiempo_de_preparacion());

        // cargar imagen desde file
        String imagen = mData.get(position).getImagen_receta();
        Glide.with(mContext).load(mData.get(position).getImagen_receta()).apply(option).into(holder.img_thumbnail);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolders extends RecyclerView.ViewHolder{

        TextView re_name;
        TextView re_tipo;
        TextView re_tiempo;
        ImageView img_thumbnail;

        LinearLayout view_container;

        public MyViewHolders(@NonNull View itemView) {
            super(itemView);

            view_container=itemView.findViewById(R.id.container);

            re_name=itemView.findViewById(R.id.recetaname);
            re_tipo=itemView.findViewById(R.id.tiopodereceta);
            re_tiempo=itemView.findViewById(R.id.tiempo_preparacion);
            img_thumbnail= itemView.findViewById(R.id.thumbnail);
        }
    }
}
