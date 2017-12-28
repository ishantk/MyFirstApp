package com.auribises.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

// Activity Life Cycle

public class ActivityOne extends AppCompatActivity {

    EditText eTxtA, eTxtB;
    TextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        Toast.makeText(this,"ActivityOne onCreate",Toast.LENGTH_LONG).show();

        eTxtA = (EditText)findViewById(R.id.editText);
        eTxtB = (EditText)findViewById(R.id.editText2);
        txtTitle = (TextView)findViewById(R.id.textView);

    }

    public void clickHandler(View view){

        String num1 = eTxtA.getText().toString().trim();
        String num2 = eTxtB.getText().toString().trim();

        int a = Integer.parseInt(num1);
        int b = Integer.parseInt(num2);

        int c = a+b;

        txtTitle.setText("sum is: "+c);

        Toast.makeText(this,"You Clicked Button and c is: "+c,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"ActivityOne onStart",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"ActivityOne onRestart",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"ActivityOne onResume",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"ActivityOne onPause",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"ActivityOne onStop",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"ActivityOne onDestroy",Toast.LENGTH_LONG).show();
    }
}
