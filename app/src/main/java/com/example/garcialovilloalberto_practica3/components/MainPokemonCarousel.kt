package com.example.garcialovilloalberto_practica3.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.carousel.HorizontalUncontainedCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.garcialovilloalberto_practica3.data.DrawableStringPair
import com.example.garcialovilloalberto_practica3.data.pokemonDataGenerational

/**
 * Carrusel horizontal que muestra el Pokemon por generación.
 *
 * Utiliza [HorizontalUncontainedCarousel] para mostrar una lista de Pokemon deslizable
 * horizontalmente, mostrando cada Pokemon mediante [PokemonElement].
 *
 * @param pokemonList Lista de Pokemon a mostrar, cada uno representado por un [DrawableStringPair]
 * que contiene imagen y nombre.
 *
 * @see PokemonElement
 *
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPokemonCarousel(
    pokemonList: List<DrawableStringPair>
) {
    HorizontalUncontainedCarousel(
        state = rememberCarouselState { pokemonDataGenerational.count() },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 16.dp, bottom = 16.dp),
        itemWidth = 100.dp,
        itemSpacing = 8.dp,
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) { i ->
        val item = pokemonList[i]
        PokemonElement(
            drawable = item.drawable,
            text = item.text
        )
    }
}
