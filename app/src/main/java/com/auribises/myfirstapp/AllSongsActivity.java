package com.auribises.myfirstapp;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;

public class AllSongsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listView;
    ArrayAdapter<String> adapter;

    void readFilesFromSDCard(){

        listView = findViewById(R.id.listView);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);

        try {

            String path = Environment.getDownloadCacheDirectory().getAbsolutePath();
            Log.i("PATH",path);
            File file = new File(path);

            String[] files = file.list();

            for(String s : files){
                if(s.endsWith(".mp3")){
                    adapter.add(s);
                }
            }


            listView.setAdapter(adapter);
            listView.setOnItemClickListener(this);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_songs);

        readFilesFromSDCard();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String name = adapter.getItem(position);
        Toast.makeText(this,"You Wish to Play: "+name,Toast.LENGTH_LONG).show();

        Intent intent = new Intent(AllSongsActivity.this,PlaySongActivity.class);
        intent.putExtra("keySong",name);
        startActivity(intent);
    }
}
