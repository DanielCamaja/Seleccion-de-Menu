package com.example.gycsol.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gycsol.R;
import com.example.gycsol.listados.ListComedor;

import java.util.List;

public class AdapterComedor extends RecyclerView.Adapter<AdapterComedor.ViewHolder> {

    private List<ListComedor> listacomedor;
    private Context mContex;

    public AdapterComedor(List<ListComedor> listacomedor, Context mContex) {
        this.listacomedor = listacomedor;
        this.mContex = mContex;
    }

    @NonNull
    @Override
    public AdapterComedor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_comedor,parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterComedor.ViewHolder holder, int position) {
        final ListComedor listComedor = listacomedor.get(position);
        holder.textonum.setText(listComedor.getId());
        holder.textnom.setText(listComedor.getComedor());
        holder.menu.setText(listComedor.getDescripcionLinea());



    }

    @Override
    public int getItemCount() {
        return listacomedor.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textonum;
        TextView textnom;
        TextView menu;
        ImageView imagen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textonum = (TextView) itemView.findViewById(R.id.textno);
            textnom = (TextView) itemView.findViewById(R.id.textonombrec);
            menu = (TextView) itemView.findViewById(R.id.textomenu);

        }
    }
}
