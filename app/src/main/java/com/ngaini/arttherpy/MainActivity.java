package com.ngaini.arttherpy;

import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor senorAccelerometer;

    private long last_uppdate;
    private float last_x, last_y, last_z;
    private static final int SHAKE_THRESHOLD=600;

    private float mAccelCurrent; // current acceleration including gravity
    private float mAccelLast; // last acceleration including gravity
    private float mAccel; // acceleration apart from gravity
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new drawClass(this, null));
//        registerReceiver(new BroadcastThis(), new IntentFilter("android.intent.action.USER_PRESENT"));
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        // the type of sensor we are interested in using
        senorAccelerometer =sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this,senorAccelerometer,SensorManager.SENSOR_DELAY_NORMAL);
        mAccelCurrent = SensorManager.GRAVITY_EARTH;
        mAccelLast = SensorManager.GRAVITY_EARTH;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * method to detect the shake gesture
     * is called every time the built-in sensor detect a change
     * @param event
     */
    @Override
    public void onSensorChanged(SensorEvent event) {

        Sensor mySensor = event.sensor;

        //double checking if we are referencing the correct sensor type
        if(mySensor.getType()==Sensor.TYPE_ACCELEROMETER)
        {
            //reading the sensor values
            // x- axis lateral movement
            float x = event.values[0];
            //y axis vertical movement
            float y = event.values[1];
            //z-axis movement in and out of the plane
            float z= event.values[2];
            mAccelLast = mAccelCurrent;
            mAccelCurrent = (float) Math.sqrt((double) (x*x + y*y + z*z));
            float delta = mAccelCurrent - mAccelLast;
            mAccel = mAccel * 0.9f + delta; // perform low-cut filter
            displayAcceleration();
        }

    }



    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    // on hibernation , unregister the sensor
    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }



    // when the application resumes, register the sensor again
    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, senorAccelerometer, sensorManager.SENSOR_DELAY_NORMAL);
    }

    private void displayAcceleration() {
//        textView = (TextView)findViewById(R.id.accelerometer_textview);
        int accel = Math.abs((int) mAccel);
        if (accel > 2) {
                drawClass eraseCanvas = new drawClass(this, null);
                eraseCanvas.eraseFunction();
            Toast.makeText(MainActivity.this, "Shaking @"+accel, Toast.LENGTH_SHORT).show();
        } else {

//            textView.setTextColor(Color.BLACK);
        }
//        textView.setText(Integer.toString(accel));
    }
}
