package com.example.gycsol.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gycsol.R;
import com.example.gycsol.listados.ListComedor;
import com.example.gycsol.listados.ListadoStock;

import java.util.List;

public class AdapterStock extends RecyclerView.Adapter<AdapterStock.ViewHolder> {

    private List<ListadoStock> listadoStocks;
    private Context mContex;

    public AdapterStock(List<ListadoStock> listadoStocks, Context mContex) {
        this.listadoStocks = listadoStocks;
        this.mContex = mContex;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listado_boton,parent, false);

        return new AdapterStock.ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ListadoStock listadoStock = listadoStocks.get(position);
        holder.btncarn.setText(listadoStock.getMenudesc());

    }

    @Override
    public int getItemCount() {
        return listadoStocks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView btncarn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            btncarn = (TextView) itemView.findViewById(R.id.btncarne);
        }
    }
}
