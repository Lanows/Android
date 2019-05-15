package com.example.projetoheadsup;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TelaJogo extends AppCompatActivity implements SensorEventListener {

    private static final int UPDATE_THRESHOULD = 500;
    private final float[] mGravity = new float[3];
    private SensorManager mSensorManager;
    private Sensor mGyroscope;

    private TextView mXValueView, mYValueView, mZValueView;
    private long mLastUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_jogo);

        mXValueView = findViewById(R.id.mXValueView);
        mYValueView = findViewById(R.id.mYValueView);
        mZValueView = findViewById(R.id.mZValueView);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if(mSensorManager != null){
            mGyroscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        }

        if(mGyroscope == null){
            finish();
        }

    }


    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mGyroscope, SensorManager.SENSOR_DELAY_GAME);
        mLastUpdate = System.currentTimeMillis();
    }


    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if(event.sensor.getType() == Sensor.TYPE_GYROSCOPE){

            long actualTime = System.currentTimeMillis();

            if (actualTime - mLastUpdate > UPDATE_THRESHOULD){

                mLastUpdate = actualTime;

                float x = event.values[0], y = event.values[1], z = event.values[2];

                mGravity[0] = lowPass(x, mGravity[0]);
                mGravity[1] = lowPass(y, mGravity[1]);
                mGravity[2] = lowPass(z, mGravity[2]);

                mXValueView.setText(String.valueOf(mGravity[0]));
                mYValueView.setText(String.valueOf(mGravity[1]));
                mZValueView.setText(String.valueOf(mGravity[2]));
            }
        }
    }


    private float lowPass(float current, float gravity){
//
        float mAlpha = 0.8f;
        return gravity * mAlpha  + current * (1 - mAlpha);
//        return current - gravity;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
