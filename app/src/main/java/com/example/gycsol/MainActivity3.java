package com.example.gycsol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.gycsol.Adaptadores.AdapterComedor;
import com.example.gycsol.Adaptadores.MyAdapter;
import com.example.gycsol.listados.ListComedor;
import com.example.gycsol.listados.ListItem;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    String URL_DATA = "https://api.casino.gycsol.cl/api/Tablet/EnrolarEtapa01?userSecret=237295307&userPass=123&deviceId=123456";
    TextView fecha, hora, dia;
    ImageView imagen, logom;

    RecyclerView recyclerme;
    AdapterComedor adapterComedor;
    ProgressDialog progressDialog;
    private List<ListComedor> listComedors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        Date date = new Date();

        fecha = (TextView) findViewById(R.id.textfecha);
        hora = (TextView) findViewById(R.id.horal);

        //fecha del dia
        SimpleDateFormat fechac = new SimpleDateFormat("EEEE, d MMMM 'del' yyyy");
        String sfecha=fechac.format(date);
        fecha.setText(sfecha);

        SimpleDateFormat horac = new SimpleDateFormat("hh:mm");
        String shora = horac.format(date);
        hora.setText(shora);

        imagen = (ImageView) findViewById(R.id.imageView33);
        logom = (ImageView) findViewById(R.id.logo3);
        Picasso.get()
                .load("https://casinogycsol.s3-sa-east-1.amazonaws.com/Logos/asmar.png")
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(imagen);

        Picasso.get()
                .load("https://casinogycsol.s3-sa-east-1.amazonaws.com/Logos/sodexo.png")
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(logom);

        recyclerme = (RecyclerView) findViewById(R.id.recyclermenu);
        recyclerme.setHasFixedSize(true);
        recyclerme.setLayoutManager(new LinearLayoutManager(this));
        listComedors = new ArrayList<>();
        loadmenucomedor();

    }

    private void loadmenucomedor() {
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loooding...");
        progressDialog.show();

        final StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("lineas");
                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject rcive=jsonArray.getJSONObject(i);
                        ListComedor Item=new ListComedor(
                                rcive.getString("linea"),
                                rcive.getString("comedor"),
                                rcive.getString("descripcionLinea"),
                                rcive.getString("urlMandante")
                        );
                        listComedors.add(Item);
                    }
                    adapterComedor=new AdapterComedor(listComedors,getApplicationContext());

                    recyclerme.setAdapter(adapterComedor);

                }catch (JSONException e)
                {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity3.this,"Server error",Toast.LENGTH_SHORT).show();
            }
        }


        );
        RequestQueue quque= Volley.newRequestQueue(this);
        quque.add(stringRequest);
    }

    public void Cerrar(View view) {
        Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
        startActivity(intent);

    }
}