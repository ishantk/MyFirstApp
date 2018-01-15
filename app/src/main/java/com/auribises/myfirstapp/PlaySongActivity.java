package com.auribises.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlaySongActivity extends AppCompatActivity implements View.OnClickListener{

    TextView txtSongName;
    Button btnPlay,btnStop;
    String songName;

    void  initViews(){
        txtSongName = findViewById(R.id.textViewSongName);
        btnPlay = findViewById(R.id.buttonPlay);
        btnStop = findViewById(R.id.buttonStop);

        btnPlay.setOnClickListener(this);
        btnStop.setOnClickListener(this);

        Intent rcv = getIntent();

        songName = rcv.getStringExtra("keySong");
        txtSongName.setText(songName);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);
        initViews();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        Intent intent = new Intent(PlaySongActivity.this,MyMusicService.class);

        if(id == R.id.buttonPlay){

            intent.putExtra("keySong",songName);
            startService(intent);

        }else{
            stopService(intent);
        }
    }
}
