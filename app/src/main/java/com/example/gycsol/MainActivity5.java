package com.example.gycsol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity5 extends AppCompatActivity {


    TextView textfecha, texthora;
    ImageView imagenlogofi, logofi;
    ImageView img, logo1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        Date date = new Date();

        textfecha = (TextView) findViewById(R.id.textfechafi);
        texthora = (TextView) findViewById(R.id.horafi);
        logo1 = (ImageView) findViewById(R.id.logo);
        img = (ImageView) findViewById(R.id.imageView11);
        Picasso.get()
                .load("https://casinogycsol.s3-sa-east-1.amazonaws.com/Logos/asmar.png")
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(img);

        Picasso.get()
                .load("https://casinogycsol.s3-sa-east-1.amazonaws.com/Logos/sodexo.png")
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(logo1);


        //fecha del dia
        SimpleDateFormat fechac = new SimpleDateFormat("EEEE, d MMMM 'del' yyyy");
        String sfecha=fechac.format(date);
        textfecha.setText(sfecha);

        SimpleDateFormat horac = new SimpleDateFormat("hh:mm");
        String shora = horac.format(date);
        texthora.setText(shora);

    }
}