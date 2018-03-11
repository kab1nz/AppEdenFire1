package com.example.a.appedenfire.objetos;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.a.appedenfire.R;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

/**
 * Created by a on 10/03/2018.
 */

public class ReservaListAdapter extends RecyclerView.Adapter<ReservaListAdapter.ViewHolder> {
    List<Habitacion> reservaList;
    PeticionesFirebase listener;
    public Context context;
    public ReservaListAdapter(Context context, List<Habitacion> reservaList, PeticionesFirebase listener){
        this.reservaList=reservaList;
        this.context=context;
        this.listener=listener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.nombre.setText(reservaList.get(position).getNombre());
        holder.apellido.setText(reservaList.get(position).getApellido());
        holder.email.setText(reservaList.get(position).getEmail());
        holder.fechaentrada.setText(reservaList.get(position).getFechaentrada());
        holder.fechasalida.setText(reservaList.get(position).getFechasalida());

        holder.nhab.setText(String.valueOf(reservaList.get(position).getNhabitaciones()));
        holder.precio.setText(String.valueOf(reservaList.get(position).getPrecio()));
        holder.tipo.setText(reservaList.get(position).getTipo());
        final String user_id = reservaList.get(position).userId;
        Button btnaceptar = holder.mView.findViewById(R.id.btnaceptar);
        Button btnrechazar = holder.mView.findViewById(R.id.btnrechazar);

        btnaceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.aceptarReserva(user_id,position);


            }
        });
        btnrechazar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              listener.rechazarReserva(user_id,position);
            }
        });
        int re = reservaList.get(position).getReserva();

        if(re==1){
            holder.cv.setBackgroundColor(context.getResources().getColor(R.color.verde));
        } if(re==0){
            holder.cv.setBackgroundColor(0xFFFFFF);

        } if(re==2){
            holder.cv.setBackgroundColor(context.getResources().getColor(R.color.rojo));

        }

    }

    @Override
    public int getItemCount() {
        return reservaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View mView;
        public TextView nombre;
        public TextView apellido;
        public TextView email;
        public TextView fechaentrada;
        public TextView nhab;
        public TextView fechasalida;
        public TextView tipo;
        public TextView precio;
        CardView cv;

        public ViewHolder(View view) {
            super(view);
             mView = view;

            nombre=(TextView)mView.findViewById(R.id.labelNombre);
            apellido=(TextView)mView.findViewById(R.id.labelApellido);
            email=(TextView)mView.findViewById(R.id.labelEmail);
            fechaentrada=(TextView)mView.findViewById(R.id.labelFentrada);
            fechasalida=(TextView)mView.findViewById(R.id.labelFsalida);
            nhab=(TextView)mView.findViewById(R.id.labelNhab);
            tipo=(TextView)mView.findViewById(R.id.labelTipo);
            precio=(TextView)mView.findViewById(R.id.labelPrecio);
            cv=mView.findViewById(R.id.card_view);

        }
    }
}
