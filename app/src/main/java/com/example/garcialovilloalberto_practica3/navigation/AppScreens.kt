package com.example.garcialovilloalberto_practica3.navigation

sealed class AppScreens(val route: String) {
    object MainPokemonScreen : AppScreens("main_pokemon_screen")
    object AllPokemonScreen : AppScreens("all_pokemon_screen")
    object ImagePokemonScreen : AppScreens("image_pokemon_screen")
}
