package com.auribises.myfirstapp;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SesnorDemoActivity extends AppCompatActivity implements View.OnClickListener,SensorEventListener{

    Button btnActivate;
    TextView txtData;

    SensorManager sensorManager;
    Sensor sensor;

    String message = "I am in Emergency!! Please Help";
    String num1 = "+91 99999 77677";
    String num2 = "+91 99999 77677";

    void initViews(){
        btnActivate = findViewById(R.id.buttonActivate);
        txtData = findViewById(R.id.textViewData);

        btnActivate.setOnClickListener(this);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesnor_demo);
        initViews();
    }


    @Override
    public void onClick(View v) {

        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float[] values = event.values;

        float x = values[0];
        float y = values[1];
        float z = values[2];



        float cal = ((x*x)+(y*y)+(z*z))/(SensorManager.GRAVITY_EARTH*SensorManager.GRAVITY_EARTH);
        if(cal>2){
            txtData.setText("Device Shaken: "+x+":"+y+":"+z);
            sensorManager.unregisterListener(this);

            //SmsManager smsManager = SmsManager.getDefault();
            //smsManager.sendTextMessage(num1,null,message,null,null);
            //smsManager.sendTextMessage(num2,null,message,null,null);

        }else{
            txtData.setText("Coordinates: "+x+":"+y+":"+z);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sensorManager.unregisterListener(this);
    }
}
