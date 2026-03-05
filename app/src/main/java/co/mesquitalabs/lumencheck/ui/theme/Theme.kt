package co.mesquitalabs.lumencheck.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import co.mesquitalabs.lumencheck.enums.AmbientLightLevel

private val DarkColorScheme = darkColorScheme(
    primary = customYellow,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = customYellow,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

private val MediumColorScheme = lightColorScheme(
    primary = customYellow,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = Color(0xFF7E7E7E),

    /* Other default colors to override
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun LumencheckTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    ambientLightLevel: AmbientLightLevel,
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when (ambientLightLevel) {
        AmbientLightLevel.DARK -> DarkColorScheme
        AmbientLightLevel.MEDIUM -> MediumColorScheme
        AmbientLightLevel.LIGHT -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
