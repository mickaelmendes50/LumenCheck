package co.mesquitalabs.lumencheck.viewmodel

import androidx.lifecycle.ViewModel
import co.mesquitalabs.lumencheck.enums.AmbientLightLevel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SensorViewModel : ViewModel() {

    private val _ambientLight = MutableStateFlow(AmbientLightLevel.MEDIUM)
    val ambientLight: StateFlow<AmbientLightLevel> = _ambientLight

    private val _currentLux = MutableStateFlow(0f)
    val currentLux: StateFlow<Float> = _currentLux

    fun onLightSensorChanged(lux: Float) {
        _currentLux.value = lux
        val newLevel = when {
            lux < 50f -> AmbientLightLevel.DARK
            lux < 300f -> AmbientLightLevel.MEDIUM
            else -> AmbientLightLevel.LIGHT
        }
        if (newLevel != _ambientLight.value) {
            _ambientLight.value = newLevel
        }
    }
}
