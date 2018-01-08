package com.auribises.myfirstapp;

import android.content.Intent;
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

    Student s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        Toast.makeText(this,"ActivityOne onCreate",Toast.LENGTH_LONG).show();

        eTxtA = (EditText)findViewById(R.id.editText);
        eTxtB = (EditText)findViewById(R.id.editText2);
        txtTitle = (TextView)findViewById(R.id.textView);

        s1 = new Student();
        s1.roll = 101;
        s1.name = "Fionna";

    }

    public void clickHandler(View view){

        String num1 = eTxtA.getText().toString().trim();
        String num2 = eTxtB.getText().toString().trim();

        int a = Integer.parseInt(num1);
        int b = Integer.parseInt(num2);

        int c = a+b;

        //txtTitle.setText("sum is: "+c);

        Toast.makeText(this,"You Clicked Button and c is: "+c,Toast.LENGTH_LONG).show();

        Intent intent = new Intent(ActivityOne.this,ActivityFour.class);

        intent.putExtra("keyStudent",s1);

        //intent.putExtra("keyResult",c);
        //intent.putExtra("keyName","John Watson");

        /*Bundle bundle = new Bundle();
        bundle.putString("keyName","George Watson");
        bundle.putInt("keyResult",c);

        intent.putExtra("keyBundle",bundle);

        startActivity(intent);*/

        startActivityForResult(intent,101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 101 && resultCode == 201){

            int num = data.getIntExtra("keyNum",0);

            int div = num/2;

            eTxtA.setText("First Part: "+div);
            eTxtB.setText("Second Part: "+div);

        }
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
