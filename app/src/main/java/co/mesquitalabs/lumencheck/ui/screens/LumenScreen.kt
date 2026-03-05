package co.mesquitalabs.lumencheck.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import co.mesquitalabs.lumencheck.R
import co.mesquitalabs.lumencheck.enums.AmbientLightLevel
import co.mesquitalabs.lumencheck.viewmodel.SensorViewModel

@Composable
fun LumenScreen(
    navController: NavHostController,
    ambientLightLevel: AmbientLightLevel,
    viewModel: SensorViewModel
) {
    val currentLux by viewModel.currentLux.collectAsState()

    val (icon, label) = when (ambientLightLevel) {
        AmbientLightLevel.DARK -> R.drawable.brightness_empty_24dp_e3e3e3_fill0_wght400_grad0_opsz24 to "Ambiente escuro"
        AmbientLightLevel.MEDIUM -> R.drawable.brightness_medium_24dp_e3e3e3_fill0_wght400_grad0_opsz24 to "Ambiente médio"
        AmbientLightLevel.LIGHT -> R.drawable.brightness_7_24dp_e3e3e3_fill0_wght400_grad0_opsz24 to "Ambiente claro"
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = label,
                modifier = Modifier.size(96.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Text(
                text = label,
                modifier = Modifier.padding(top = 16.dp),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = "Lux: $currentLux",
                modifier = Modifier.padding(top = 6.dp),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.inverseSurface
            )
        }
    }
}
