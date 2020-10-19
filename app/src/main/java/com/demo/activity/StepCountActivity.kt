package com.demo.activity

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.base.R


class StepCountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step_count)
        //1、创建传感器管理者，通过传感器管理者获取计步传感器实例
        val manager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        //2、创建传感器管理者，通过传感器管理者获取计步传感器实例
        val stepSensor = manager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
        Log.e("步数", stepSensor.name)
        //3、注册计步传感器监听
//        manager.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_NORMAL);
        manager.registerListener(object : SensorEventListener {
            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
            }

            override fun onSensorChanged(event: SensorEvent?) {
                if (event!!.sensor.type == Sensor.TYPE_STEP_COUNTER) { //event.values[0]为计步历史累加值
                    Log.e("===", "onSensorChanged: 当前步数：" + event.values[0])
                }
            }

        }, stepSensor, SensorManager.SENSOR_DELAY_NORMAL)
    }
}

