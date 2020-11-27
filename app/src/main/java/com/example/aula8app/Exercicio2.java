package com.example.aula8app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Exercicio2 extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor sensor;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio2);

        linearLayout = findViewById(R.id.view);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION), SensorManager.SENSOR_DELAY_NORMAL);
        //sensorManager.registerListener(this, sensorManager.getDefaultSensor(getResources().getConfiguration().orientation), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        //if(sensorEvent.sensor.getType() == getResources().getConfiguration().orientation) {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_ORIENTATION) {

            //if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            //linearLayout.setBackgroundColor(Color.BLUE);
            //}
            //if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //linearLayout.setBackgroundColor(Color.GREEN);
            //}

            float x = sensorEvent.values[0];
            float z = sensorEvent.values[2];

            if ((z > 1.2 && z < 1.8) || (z < -1.2 && z > -1.8)) {
                linearLayout.setBackgroundColor(Color.GREEN); //landscape
            } else {
                if ((z > -0.8 && z < 0.2) || (z < -2.84 && z > -3.44)) {
                    linearLayout.setBackgroundColor(Color.BLUE); //portrait
                }
            }

            if (x > 1.27 && x < 1.87) {
                System.exit(0);
            } else {
                if (x < -1.27 && x > -1.87) {
                    linearLayout.setBackgroundColor(Color.RED);
                }
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}