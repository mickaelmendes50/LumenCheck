package co.mesquitalabs.lumencheck.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import co.mesquitalabs.lumencheck.enums.AmbientLightLevel

@Composable
fun LumenScreen(
    navController: NavHostController,
    ambientLightLevel: AmbientLightLevel
) {
    val (icon, label) = when (ambientLightLevel) {
        AmbientLightLevel.DARK -> Icons.Default.Star to "Ambiente escuro"
        AmbientLightLevel.MEDIUM -> Icons.Default.ThumbUp to "Ambiente médio"
        AmbientLightLevel.LIGHT -> Icons.Default.Add to "Ambiente claro"
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                modifier = Modifier.size(96.dp)
            )
            Text(text = label)
        }
    }
}
