package com.davronxolboyev.app.cars;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    TextView appName;
    TextView textGita;
    CardView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        logo = findViewById(R.id.logoGita);
        appName = findViewById(R.id.appname);
        textGita = findViewById(R.id.gitaText);
        Animation bounce = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bonce);

        appName.startAnimation(bounce);
        textGita.startAnimation(bounce);
        logo.startAnimation(bounce);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }, 2500);
    }
}