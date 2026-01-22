package com.example.garcialovilloalberto_practica3.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.garcialovilloalberto_practica3.data.DrawableStringPair

/**
 * Cuadricula(Grid) horizontal que muestra los Pokemon favoritos en forma de tarjetas.
 *
 * Utiliza un [LazyHorizontalGrid] con 2 filas, para mostrar cada Pokemon mediante [PokemonCard].
 * Permite reaccionar al clic de cada Pokemon mediante [onPokemonClick].
 *
 * @param modifier Modificador opcional para personalizar el layout de la cuadricula.
 * @param pokemonList Lista de Pokemon a mostrar, cada uno representado por un [DrawableStringPair]
 * que contiene imagen y nombre.
 * @param onPokemonClick Lambda que se ejecuta al seleccionar un Pokemon, recibiendo como parámetro
 * el recurso drawable del Pokemon.
 *
 */
@Composable
fun FavoritePokemonGrid(
    modifier: Modifier = Modifier,
    pokemonList: List<DrawableStringPair>,
    onPokemonClick: (Int) -> Unit //Nuevo
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.height(168.dp)
    ) {
        items(pokemonList) { item ->
            PokemonCard(
                drawable =  item.drawable,
                text = item.text,
                modifier = Modifier.height(80.dp),
                cardWidth = 240,
                onClick = { onPokemonClick(item.drawable) } //Nuevo
            )
        }
    }
}