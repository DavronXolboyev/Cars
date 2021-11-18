package com.davronxolboyev.app.cars.game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.davronxolboyev.app.cars.R;

import java.util.ArrayList;
import java.util.List;

public class LogoGame extends AppCompatActivity {

    List<GameLogos> logos;
    ImageView logo1;
    ImageView logo2;
    ImageView logo3;
    ImageView logo4;
    int id;
    int count = 0;
    int res = 0;
    TextView question;

    SoundPool sp;
    int correct, wrong, winner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_game);

        sp = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        correct = sp.load(this, R.raw.correctanswersound, 1);
        wrong = sp.load(this, R.raw.wronganswersound, 1);
        winner = sp.load(this, R.raw.winnersound, 1);


        logo1 = findViewById(R.id.image1);
        logo2 = findViewById(R.id.image2);
        logo3 = findViewById(R.id.image3);
        logo4 = findViewById(R.id.image4);
        question = findViewById(R.id.question);

        logos = new ArrayList<>();

        logos.add(new GameLogos(2, R.drawable.game_chevrolet, R.drawable.game_mercedes_benz,
                R.drawable.game_skoda, R.drawable.game_mazda, "Mercedes"));
        logos.add(new GameLogos(4, R.drawable.game_acura, R.drawable.game_bmw,
                R.drawable.game_bentley, R.drawable.game_ford_mustang, "Ford Mustang"));
        logos.add(new GameLogos(4, R.drawable.game_skoda, R.drawable.game_ford_mustang,
                R.drawable.game_audi, R.drawable.game_bmw, "BMW"));
        logos.add(new GameLogos(3, R.drawable.game_hyundai, R.drawable.game_bentley,
                R.drawable.game_honda, R.drawable.game_maserati, "Honda"));
        logos.add(new GameLogos(3, R.drawable.game_jeep, R.drawable.game_chevrolet,
                R.drawable.game_daewoo, R.drawable.game_mercedes_benz, "Daewoo"));
        logos.add(new GameLogos(2, R.drawable.game_acura, R.drawable.game_ford,
                R.drawable.game_volkswagen, R.drawable.game_bmw, "Ford"));
        logos.add(new GameLogos(1, R.drawable.game_jeep, R.drawable.game_bmw,
                R.drawable.game_bentley, R.drawable.game_ford_mustang, "Jeep"));
        logos.add(new GameLogos(2, R.drawable.game_mitsubishi, R.drawable.game_bentley,
                R.drawable.game_mercedes_benz, R.drawable.game_skoda, "Bentley"));
        logos.add(new GameLogos(4, R.drawable.game_mercedes_benz, R.drawable.game_skoda,
                R.drawable.game_bentley, R.drawable.game_audi, "Audi"));
        logos.add(new GameLogos(3, R.drawable.game_acura, R.drawable.game_mitsubishi,
                R.drawable.game_maserati, R.drawable.game_jeep, "Maserati"));
        logos.add(new GameLogos(3, R.drawable.game_honda, R.drawable.game_ford_mustang,
                R.drawable.game_lexus, R.drawable.game_bmw, "Lexus"));
        logos.add(new GameLogos(2, R.drawable.game_acura, R.drawable.game_tesla,
                R.drawable.game_bentley, R.drawable.game_ford_mustang, "Tesla"));
        logos.add(new GameLogos(2, R.drawable.game_hyundai, R.drawable.game_mazda,
                R.drawable.game_skoda, R.drawable.game_tesla, "Mazda"));
        logos.add(new GameLogos(1, R.drawable.game_mitsubishi, R.drawable.game_maserati,
                R.drawable.game_mazda, R.drawable.game_ford_mustang, "Mitsibushi"));
        logos.add(new GameLogos(4, R.drawable.game_audi, R.drawable.game_jeep,
                R.drawable.game_chevrolet, R.drawable.game_porsche, "Porsche"));
        logos.add(new GameLogos(4, R.drawable.game_audi, R.drawable.game_mitsubishi,
                R.drawable.game_ford_mustang, R.drawable.game_skoda, "Skoda"));
        logos.add(new GameLogos(3, R.drawable.game_mazda, R.drawable.game_bmw,
                R.drawable.game_subaru, R.drawable.game_lexus, "Subaru"));
        logos.add(new GameLogos(2, R.drawable.game_daewoo, R.drawable.game_toyota,
                R.drawable.game_bentley, R.drawable.game_honda, "Toyota"));
        logos.add(new GameLogos(2, R.drawable.game_acura, R.drawable.game_volkswagen,
                R.drawable.game_maserati, R.drawable.game_ford_mustang, "Volkswagen"));

        startGame();
    }

    private void startGame() {

        Animation bounce = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bonce);
        int r = (int) (Math.random() * 19);
        question.setText(logos.get(r).getQuestion());
        logo1.setImageResource(logos.get(r).getImage1());
        logo2.setImageResource(logos.get(r).getImage2());
        logo3.setImageResource(logos.get(r).getImage3());
        logo4.setImageResource(logos.get(r).getImage4());
        logo1.startAnimation(bounce);
        logo2.startAnimation(bounce);
        logo3.startAnimation(bounce);
        logo4.startAnimation(bounce);

        if (count < 10) {
            logo1.setOnClickListener(v -> {
                id = 1;
                if (id == logos.get(r).getCoorect()) {
                    play(correct);
                    res++;
                } else {
                    play(wrong);
                }
                count++;
                startGame();
            });
            logo2.setOnClickListener(v -> {
                id = 2;
                if (id == logos.get(r).getCoorect()) {
                    play(correct);
                    res++;
                } else {
                    play(wrong);
                }
                count++;
                startGame();
            });
            logo3.setOnClickListener(v -> {
                id = 3;
                if (id == logos.get(r).getCoorect()) {
                    play(correct);
                    res++;
                } else {
                    play(wrong);
                }
                count++;
                startGame();
            });
            logo4.setOnClickListener(v -> {
                id = 4;
                if (id == logos.get(r).getCoorect()) {
                    play(correct);
                    res++;
                } else {
                    play(wrong);
                }
                count++;
                startGame();
            });
        } else {
            play(winner);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Correct answers : " + res + "\nIncorrect answers : " + (10 - res) + "\n\n\nShall we start again?")
                    .setTitle("Result")
                    .setPositiveButton("Yes", ((dialog, which) -> {
                        count = 0;
                        res = 0;
                        startGame();
                        dialog.cancel();
                    }))
                    .setNegativeButton("No", ((dialog, which) -> {
                        dialog.cancel();
                        onBackPressed();
                    }))
                    .setIcon(R.drawable.ic_baseline_videogame_asset_24);

            AlertDialog dialog = builder.create();
            dialog.show();
        }

    }

    public void play(int soundID) {
        sp.play(soundID, 1, 1, 0, 0, 1);
    }
}