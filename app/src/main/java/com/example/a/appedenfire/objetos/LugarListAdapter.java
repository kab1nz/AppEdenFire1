package com.example.a.appedenfire.objetos;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a.appedenfire.R;

import java.util.List;

/**
 * Created by a on 12/03/2018.
 */

public class LugarListAdapter extends RecyclerView.Adapter<LugarListAdapter.ViewHolder>{
    List<Lugar> lugarList;
    PeticionesFirebase listener;
    public Context context;
    public LugarListAdapter(Context context, List<Lugar> lugarList){
        this.context=context;
        this.lugarList=lugarList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutlugar,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LugarListAdapter.ViewHolder holder, int position) {
        holder.nombreLugar.setText(lugarList.get(position).getNombreLugar());
        holder.descripcionLugar.setText(lugarList.get(position).getDescripcionLugar());
        holder.ratingLugar.setText(lugarList.get(position).getRatingLugar());
        int a =  Integer.parseInt(lugarList.get(position).getImage());

    }



    @Override
    public int getItemCount() {
        return lugarList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View mView;
        public TextView nombreLugar;
        public TextView descripcionLugar;
        public TextView ratingLugar;
        public ImageView imageLugar;

        CardView cv;

        public ViewHolder(View view) {
            super(view);
            mView = view;

            nombreLugar=(TextView)mView.findViewById(R.id.nombreLugar);
            descripcionLugar=(TextView)mView.findViewById(R.id.descripcionLugar);
            ratingLugar=(TextView)mView.findViewById(R.id.ratingLugar);
            imageLugar=(ImageView) mView.findViewById(R.id.imageLugar);

            cv=mView.findViewById(R.id.cardviewlugar);

        }
    }
}


