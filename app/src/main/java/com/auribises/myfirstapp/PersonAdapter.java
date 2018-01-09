package com.auribises.myfirstapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ishantkumar on 09/01/18.
 */

public class PersonAdapter extends ArrayAdapter<Person> {

    Context context;
    int resource;
    ArrayList<Person> objects;

    public PersonAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Person> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(resource,parent,false);

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView txtName = view.findViewById(R.id.textViewName);
        TextView txtPhone = view.findViewById(R.id.textViewPhone);

        Person p = objects.get(position);

        imageView.setBackgroundResource(p.image);
        txtName.setText(p.name);
        txtPhone.setText(p.phone);

        return view;
    }
}
