package com.example.garcialovilloalberto_practica3.non_used_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.garcialovilloalberto_practica3.ui.components.PokemonElement
import com.example.garcialovilloalberto_practica3.data.pokemonDataGenerational



@Composable
fun PokemonRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(pokemonDataGenerational) { item ->
            PokemonElement(item.drawable, item.text)
        }
    }
}
