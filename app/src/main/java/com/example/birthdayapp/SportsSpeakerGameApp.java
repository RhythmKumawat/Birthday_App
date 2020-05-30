package com.example.birthdayapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class SportsSpeakerGameApp extends AppCompatActivity implements View.OnClickListener {

    private ImageButton imgBoxing, imgKickBoxing, imgJudo, imgKarate,
            imgAikido, imgTaekwondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBoxing = findViewById(R.id.imgBoxing);
        imgKickBoxing = findViewById(R.id.imgKickBoxing);
        imgJudo = findViewById(R.id.imgJudo);
        imgAikido = findViewById(R.id.imgAikido);
        imgKarate = findViewById(R.id.imgKarate);
        imgTaekwondo = findViewById(R.id.imgTaekwondo);

        imgBoxing.setOnClickListener(SportsSpeakerGameApp.this);
        imgKickBoxing.setOnClickListener(SportsSpeakerGameApp.this);
        imgJudo.setOnClickListener(SportsSpeakerGameApp.this);
        imgKarate.setOnClickListener(SportsSpeakerGameApp.this);
        imgAikido.setOnClickListener(SportsSpeakerGameApp.this);
        imgTaekwondo.setOnClickListener(SportsSpeakerGameApp.this);

    }


    @Override
    public void onClick(View imageButtonView) {

        switch (imageButtonView.getId()) {

            case R.id.imgBoxing:
                playSportsName(imgBoxing.getTag().toString());
                break;
            case R.id.imgKickBoxing:
                playSportsName(imgKickBoxing.getTag().toString());
                break;
            case R.id.imgJudo:
                playSportsName(imgJudo.getTag().toString());
                break;
            case R.id.imgKarate:
                playSportsName(imgKarate.getTag().toString());
                break;
            case R.id.imgAikido:
                playSportsName(imgAikido.getTag().toString());
                break;
            case R.id.imgTaekwondo:
                playSportsName(imgTaekwondo.getTag().toString());
                break;
        }

    }

    private void playSportsName(String sportName)  {

        MediaPlayer sportPlayer = MediaPlayer.create(this,
                    getResources().getIdentifier
                          (sportName, "raw", getPackageName()));

        sportPlayer.start();

    }

}
