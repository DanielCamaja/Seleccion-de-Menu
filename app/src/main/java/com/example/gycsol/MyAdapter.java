package com.example.gycsol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        final ListItem listItem = listItems.get(position);
        holder.texttitulo.setText(listItem.getComedor());
        holder.textdesc.setText(listItem.getDescripcionLinea());
        Picasso.get().load(listItem.getUrlMandante()).into(holder.imagen);



    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView texttitulo;
        TextView textdesc;
        ImageView imagen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            texttitulo = (TextView) itemView.findViewById(R.id.textonombre);
            textdesc = (TextView) itemView.findViewById(R.id.textoinfo);
            imagen = (ImageView) itemView.findViewById(R.id.imagetipo);

        }
    }
}
