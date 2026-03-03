package co.mesquitalabs.lumencheck

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import co.mesquitalabs.lumencheck.ui.MainContainer
import co.mesquitalabs.lumencheck.ui.theme.LumencheckTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LumencheckTheme {
                MainContainer()
            }
        }
    }
}
