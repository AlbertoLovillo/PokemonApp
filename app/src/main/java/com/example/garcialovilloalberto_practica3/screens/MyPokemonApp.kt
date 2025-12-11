package com.example.garcialovilloalberto_practica3.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.garcialovilloalberto_practica3.components.PokemonNavigationBar
import com.example.garcialovilloalberto_practica3.components.PokemonNavigationRail
import com.example.garcialovilloalberto_practica3.navigation.AppNavigation
import com.example.garcialovilloalberto_practica3.ui.theme.GarciaLovilloAlberto_Practica3Theme


@Composable
fun MainPokemonApp(windowSize: WindowSizeClass) {
    val navController = rememberNavController()

    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            MyPokemonAppPortrait(navController = navController)
        }
        WindowWidthSizeClass.Expanded -> {
            MyPokemonAppLandscape(navController = navController)
        }
    }
}


@Composable
fun MyPokemonAppPortrait(navController: NavHostController) {
    GarciaLovilloAlberto_Practica3Theme {
        Scaffold(
            bottomBar = {
                PokemonNavigationBar(navController = navController)
            }
        ) {
            padding ->
            AppNavigation(navController = navController, padding = padding)
        }
    }
}


@Composable
fun MyPokemonAppLandscape(navController: NavHostController) {
    GarciaLovilloAlberto_Practica3Theme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Row {
                PokemonNavigationRail()
                AppNavigation(navController = navController, padding = PaddingValues(0.dp))
            }
        }
    }
}
