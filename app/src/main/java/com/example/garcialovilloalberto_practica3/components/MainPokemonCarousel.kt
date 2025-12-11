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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.garcialovilloalberto_practica3.ui.theme.GarciaLovilloAlberto_Practica3Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPokemonCarousel() {
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
        val item = pokemonDataGenerational[i]

        PokemonElement(
            drawable = item.drawable,
            text = item.text
        )
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun PokemonCarouselPreview() {
    GarciaLovilloAlberto_Practica3Theme {
        MainPokemonCarousel()
    }
}