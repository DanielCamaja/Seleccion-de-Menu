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
import com.example.gycsol.listados.ListadoStock;

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
        holder.idpedido.setText(listComedor.getId());
        holder.rutpe.setText(listComedor.getComedor());
        holder.nombretr.setText(listComedor.getDescripcionLinea());
        holder.menu.setText(listComedor.getDescMenu());
        holder.hora.setText(listComedor.getHoraConsumo());
        holder.empresa.setText(listComedor.getNombreEmpresa());



    }

    @Override
    public int getItemCount() {
        return listacomedor.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView idpedido;
        TextView rutpe;
        TextView nombretr;
        TextView menu;
        TextView hora;
        TextView empresa;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            idpedido = (TextView) itemView.findViewById(R.id.textno);
            rutpe = (TextView) itemView.findViewById(R.id.textrut);
            nombretr = (TextView) itemView.findViewById(R.id.textonombrec);
            menu = (TextView) itemView.findViewById(R.id.textomenu);
            hora = (TextView) itemView.findViewById(R.id.texthora);
            empresa = (TextView) itemView.findViewById(R.id.textempresa);

        }
    }
}
