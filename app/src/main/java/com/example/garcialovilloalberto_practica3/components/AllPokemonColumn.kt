package com.example.garcialovilloalberto_practica3.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AllPokemonColumn(modifier: Modifier = Modifier, navController: NavController) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier.height(500.dp)
    ) {
        items(pokemonDataAlphabetical) { item ->
            PokemonCard(
                item.drawable,
                item.text,
                Modifier.height(80.dp),
                cardWidth = 350,
                navController = navController
            )
        }
    }
}