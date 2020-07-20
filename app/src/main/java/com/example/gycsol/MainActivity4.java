package com.example.gycsol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity4 extends AppCompatActivity {

    ImageView imgenl, logosa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        imgenl = (ImageView) findViewById(R.id.imageView44);
        Glide.with(this)
                .load("https://casinogycsol.s3-sa-east-1.amazonaws.com/Logos/asmar.png")
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(imgenl);

        logosa = (ImageView) findViewById(R.id.logo4);
        Glide.with(this)
                .load("https://casinogycsol.s3-sa-east-1.amazonaws.com/Logos/sodexo.png")
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(logosa);

    }

    public void enviaruser(View view) {
        Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
        startActivity(intent);
    }
}