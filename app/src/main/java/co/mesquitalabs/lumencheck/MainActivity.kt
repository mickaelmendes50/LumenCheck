package co.mesquitalabs.lumencheck

import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val ambientLight by viewModel.ambientLight.collectAsState()

            LumencheckTheme(ambientLightLevel = ambientLight) {
                MainContainer()
            }
        }
    }
}
