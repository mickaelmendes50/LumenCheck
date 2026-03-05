package co.mesquitalabs.lumencheck

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import co.mesquitalabs.lumencheck.ui.MainContainer
import co.mesquitalabs.lumencheck.ui.theme.LumencheckTheme
import co.mesquitalabs.lumencheck.viewmodel.SensorViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: SensorViewModel by viewModels()

    private lateinit var sensorManager: SensorManager
    private var lightSensor: Sensor? = null

    private val lightListener = object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent) {
            if (event.sensor.type == Sensor.TYPE_LIGHT) {
                val lux = event.values[0]
                viewModel.onLightSensorChanged(lux)
                Log.d("Lumencheck", "Lux: $lux")
            }
        }

        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) = Unit
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)

        enableEdgeToEdge()
        setContent {
            val ambientLight by viewModel.ambientLight.collectAsState()

            LumencheckTheme(ambientLightLevel = ambientLight) {
                MainContainer()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        lightSensor?.let {
            sensorManager.registerListener(
                lightListener,
                it,
                SensorManager.SENSOR_DELAY_NORMAL
            )
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(lightListener)
    }
}
