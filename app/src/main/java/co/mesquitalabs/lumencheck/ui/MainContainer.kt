package co.mesquitalabs.lumencheck.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import co.mesquitalabs.lumencheck.ui.navigation.AppNavigation
import co.mesquitalabs.lumencheck.viewmodel.SensorViewModel

@Composable
fun MainContainer(
    viewModel: SensorViewModel
) {
    val navController = rememberNavController()
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        AppNavigation(
            navController = navController,
            paddingValues = innerPadding,
            viewModel = viewModel
        )
    }
}
