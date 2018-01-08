package com.auribises.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityFour extends AppCompatActivity implements View.OnClickListener{

    TextView txtResult;
    EditText eTxtResult;
    Button btnGoBack;

    void initViews(){
        txtResult = findViewById(R.id.textViewResult);
        eTxtResult = findViewById(R.id.editTextResult);

        btnGoBack = findViewById(R.id.buttonBack);
        btnGoBack.setOnClickListener(this);

        Intent rcv = getIntent();

        //Student s = (Student)rcv.getSerializableExtra("keyStudent");

        //Bundle rcvBun = rcv.getBundleExtra("keyBundle");

        //int result = rcv.getIntExtra("keyResult",0);
        //String name = rcv.getStringExtra("keyName");
        //int result = rcvBun.getInt("keyResult",0);
        //String name = rcvBun.getString("keyName");

        //txtResult.setText("Welcome, "+name);
        //eTxtResult.setText("Result is: "+result);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        initViews();
    }

    @Override
    public void onClick(View view) {

        String data = eTxtResult.getText().toString();
        int num = Integer.parseInt(data);

        Intent intent = new Intent();
        intent.putExtra("keyNum",num);

        setResult(201,intent);
        finish();

    }
}
