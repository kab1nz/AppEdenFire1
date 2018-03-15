package com.eden.a.appedenfire.objetos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eden.a.appedenfire.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by usuario on 13/03/2018.
 */

public class LugarAdapter extends RecyclerView.Adapter<LugarAdapter.LugarHolder> {
    private Context context;
    private List<Lugar>lugarList;

    public LugarAdapter(Context context, List<Lugar> lugarList) {
        this.context = context;
        this.lugarList = lugarList;
    }

    @NonNull
    @Override
    public LugarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view =layoutInflater.inflate(R.layout.layoutlugar,null);
        return new LugarHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LugarHolder holder, int position) {
        Lugar lugar= lugarList.get(position);

        holder.nombreLugar.setText(lugar.getNombreLugar());
        holder.descripcionLugar.setText(lugar.getDescripcionLugar());
        holder.ratingLugar.setText(String.valueOf(lugar.getRatingLugar()));
        Picasso.get()
                .load(lugar.getImage())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return lugarList.size();
    }

    public class LugarHolder extends RecyclerView.ViewHolder{
        public TextView nombreLugar,descripcionLugar,ratingLugar;
        public ImageView imageView;
        public LugarHolder(View itemView) {
            super(itemView);
            nombreLugar=itemView.findViewById(R.id.nombreLugar);
            descripcionLugar=itemView.findViewById(R.id.descripcionLugar);
            ratingLugar=itemView.findViewById(R.id.ratingLugar);
            imageView=itemView.findViewById(R.id.imageLugar);
        }
    }
}
