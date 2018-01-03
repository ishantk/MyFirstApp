package com.auribises.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ActivityThree extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listView;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        listView = (ListView)findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);

        adapter.add("Myntra"); //0
        adapter.add("Flipkart");
        adapter.add("Amazon");
        adapter.add("Koovs");  //n-1

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String name = adapter.getItem(i);
        Toast.makeText(this,"You Selected: "+name,Toast.LENGTH_LONG).show();
    }
}
