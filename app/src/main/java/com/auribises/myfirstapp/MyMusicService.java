package com.auribises.myfirstapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.os.IBinder;
import android.widget.Toast;

import java.io.IOException;

public class MyMusicService extends Service {

    String songName;
    MediaPlayer mediaPlayer;


    public MyMusicService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"Service Created",Toast.LENGTH_LONG).show();


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"Service Started",Toast.LENGTH_LONG).show();

        songName = intent.getStringExtra("keySong");

        mediaPlayer = new MediaPlayer();

        String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+songName;

        String url = "www.auribises.com/music/songname.mp3";

        try {
            mediaPlayer.setDataSource(path);

            //mediaPlayer.setDataSource(this, Uri.parse(url));

            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mediaPlayer.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"Service Destroyed",Toast.LENGTH_LONG).show();

        mediaPlayer.stop();
        mediaPlayer.release();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
