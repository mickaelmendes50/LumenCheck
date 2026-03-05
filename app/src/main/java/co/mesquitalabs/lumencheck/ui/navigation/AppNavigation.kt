package co.mesquitalabs.lumencheck.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import co.mesquitalabs.lumencheck.ui.screens.HomeScreen
import co.mesquitalabs.lumencheck.ui.screens.LumenScreen
import co.mesquitalabs.lumencheck.viewmodel.SensorViewModel

@Composable
fun AppNavigation(
    navController: NavHostController,
    paddingValues: PaddingValues,
    viewModel: SensorViewModel = viewModel(),
) {
    val ambientLight by viewModel.ambientLight.collectAsState()

    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = Modifier.padding(paddingValues)
    ) {
        composable("home") {
            HomeScreen(navController)
        }
        composable("lumen") {
            LumenScreen(navController = navController, ambientLightLevel = ambientLight)
        }
    }
}
