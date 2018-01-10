package com.auribises.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{


    //ListView listView;
    //GridView gridView;

    RecyclerView recyclerView;

    ArrayList<Person> personList;
    //PersonAdapter adapter;
    PersonRecyclerAdapter recyclerAdapter;

    void initViews(){
        //listView = findViewById(R.id.listView);
        //gridView = findViewById(R.id.gridView);

        recyclerView = findViewById(R.id.recyclerView);

        personList = new ArrayList<Person>();

        Person p1 = new Person(R.drawable.contact,"John Watson","987654387");
        Person p2 = new Person(R.drawable.pb,"Jennie Watson","987654387");
        Person p3 = new Person(R.drawable.folder,"Jack Watson","987654387");
        Person p4 = new Person(R.drawable.category,"Jim Watson","987654387");
        Person p5 = new Person(R.drawable.music,"Joe Watson","987654387");

        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        personList.add(p5);


        //adapter = new PersonAdapter(this,R.layout.list_item,personList);
        //listView.setAdapter(adapter);

        //listView.setOnItemClickListener(this);
        //gridView.setAdapter(adapter);
        //gridView.setOnItemClickListener(this);

        recyclerAdapter = new PersonRecyclerAdapter(this,R.layout.list_item,personList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);

        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(recyclerAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_my_list);
        setContentView(R.layout.activity_my_grid);
        initViews();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Person p = personList.get(i);
        Toast.makeText(this,"You Selected: "+p.name,Toast.LENGTH_LONG).show();
    }
}
