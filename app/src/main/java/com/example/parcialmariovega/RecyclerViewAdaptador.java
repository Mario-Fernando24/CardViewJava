package com.example.parcialmariovega;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class RecyclerViewAdaptador extends RecyclerView.Adapter {


    public static  class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nombre, descripcion;
        ImageView foto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre = (TextView)itemView.findViewById(R.id.textProduxto);
            descripcion = (TextView)itemView.findViewById(R.id.textDescripcion);
            foto = (ImageView) itemView.findViewById(R.id.imageViewprodct);



        }
    }

    public List<Productos> listaproductos;

    public RecyclerViewAdaptador(List<Productos>  listaproduc ){

        this.listaproductos = listaproduc;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_elementos,parent,false);
        ViewHolder  viewHolder = new ViewHolder(view);

        return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }


   // @Override
    //  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {



    //  holder.nombre.setText(listaproductos.get(position).getNombre());
    //   holder.descripcion.setText(listaproductos.get(position).getDescripcion());
    //    holder.foto.setImageResource(listaproductos.get(position).getFotoproducto());

    //}


    @Override
    public int getItemCount() {


        return listaproductos.size()     ;
    }

}
