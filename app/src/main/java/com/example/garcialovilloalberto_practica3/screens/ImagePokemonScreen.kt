package com.example.garcialovilloalberto_practica3.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.garcialovilloalberto_practica3.R
import com.example.garcialovilloalberto_practica3.components.ImagePokemon
import com.example.garcialovilloalberto_practica3.components.SearchBar

@Composable
fun ImagePokemonScreen(modifier: Modifier = Modifier, navController: NavController, @DrawableRes drawable: Int) {
    Column(modifier) {
        Spacer(Modifier.height(32.dp))

        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(navController = navController, title = R.string.pokemon_image) {
            ImagePokemon(drawable)
        }
    }
}
