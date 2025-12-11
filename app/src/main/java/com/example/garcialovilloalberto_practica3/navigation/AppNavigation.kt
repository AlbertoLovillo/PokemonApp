package com.example.garcialovilloalberto_practica3.navigation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.garcialovilloalberto_practica3.screens.AllPokemonScreen
import com.example.garcialovilloalberto_practica3.screens.ImagePokemonScreen
import com.example.garcialovilloalberto_practica3.screens.MainPokemonScreen

@Composable
fun AppNavigation(
    navController: NavHostController, padding: PaddingValues
) {
    NavHost(navController = navController, startDestination = AppScreens.MainPokemonScreen.route) {
        composable(route = AppScreens.MainPokemonScreen.route) {
            MainPokemonScreen(navController = navController)
        }
        composable(route = AppScreens.AllPokemonScreen.route) {
            AllPokemonScreen(navController = navController)
        }
        composable(route = AppScreens.ImagePokemonScreen.route + "/{drawable}",
            arguments = listOf(navArgument("drawable") { type = NavType.IntType })) {
                backStackEntry ->
            val drawable = backStackEntry.arguments?.getInt("drawable") ?: 0
            ImagePokemonScreen(navController = navController, drawable = drawable)
        }
    }
}