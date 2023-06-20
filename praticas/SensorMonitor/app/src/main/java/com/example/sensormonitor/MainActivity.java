package com.example.sensormonitor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private ListView sensorListView;
    private ArrayAdapter<String> sensorListAdapter;
    private List<Sensor> availableSensors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorListView = findViewById(R.id.listSensor);
        sensorListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        sensorListView.setAdapter(sensorListAdapter);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        availableSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

        for (Sensor sensor : availableSensors) {
            sensorListAdapter.add(sensor.getName());
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d("Sensor", sensorEvent.sensor.toString() + "-" + sensorEvent.values[0]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Empty
    }
}

