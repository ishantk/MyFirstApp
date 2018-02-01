package com.auribises.myfirstapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PrefActivity extends AppCompatActivity {

    SharedPreferences preferences;
    EditText edname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pref);
        preferences = getSharedPreferences("myFile",MODE_PRIVATE);
        edname = findViewById(R.id.edname);
        String name = preferences.getString("keyName","NA");
        edname.setText(name);
    }

    public void clickHandler(View view) {

        String nm = edname.getText().toString();

        preferences.edit().putString("keyName",nm).apply();



    }
}
