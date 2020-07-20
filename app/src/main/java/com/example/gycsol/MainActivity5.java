package com.example.gycsol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity5 extends AppCompatActivity {


    TextView textfecha, texthora;
    ImageView imagenlogofi, logofi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        Date date = new Date();

        textfecha = (TextView) findViewById(R.id.textfechafi);
        texthora = (TextView) findViewById(R.id.horafi);
        imagenlogofi = (ImageView) findViewById(R.id.imageView55);
        Glide.with(this)
                .load("https://casinogycsol.s3-sa-east-1.amazonaws.com/Logos/asmar.png")
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(imagenlogofi);

        logofi = (ImageView)findViewById(R.id.logo5);
        Glide.with(this)
                .load("https://casinogycsol.s3-sa-east-1.amazonaws.com/Logos/sodexo.png")
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(logofi);

        //fecha del dia
        SimpleDateFormat fechac = new SimpleDateFormat("EEEE, d MMMM 'del' yyyy");
        String sfecha=fechac.format(date);
        textfecha.setText(sfecha);

        SimpleDateFormat horac = new SimpleDateFormat("hh:mm");
        String shora = horac.format(date);
        texthora.setText(shora);

    }
}