package com.example.gycsol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity3 extends AppCompatActivity {

    TextView fecha, hora, dia;
    ImageView imagen, logom;

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
        Glide.with(this)
                .load("https://casinogycsol.s3-sa-east-1.amazonaws.com/Logos/asmar.png")
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(imagen);

        logom = (ImageView) findViewById(R.id.logo3);
        Glide.with(this)
                .load("https://casinogycsol.s3-sa-east-1.amazonaws.com/Logos/sodexo.png")
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(logom);

    }

    public void Cerrar(View view) {
        Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
        startActivity(intent);

    }
}