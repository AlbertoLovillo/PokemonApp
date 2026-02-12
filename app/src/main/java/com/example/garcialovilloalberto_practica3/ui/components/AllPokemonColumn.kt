package com.example.garcialovilloalberto_practica3.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.garcialovilloalberto_practica3.data.DrawableStringPair

/**
 * Columna que muestra una lista de todos los Pokemon en forma de tarjetas.
 *
 * Utiliza un [LazyColumn]que muestra cada Pokemon mediante [PokemonCard].
 * Permite reaccionar al clic de cada Pokemon mediante [onPokemonClick].
 *
 * @param modifier Modificador opcional para personalizar el layout de la columna.
 * @param pokemonList Lista de Pokemon a mostrar, cada uno representado por un [DrawableStringPair]
 * que contiene imagen y nombre.
 * @param onPokemonClick Lambda que se ejecuta al seleccionar un Pokemon, recibiendo como parámetro
 * el recurso drawable del Pokemon.
 * @param lazyListState Estado de scroll de la [LazyColumn], usado para observar el
 * desplazamiento de la lista.
 *
 */
@Composable
fun AllPokemonColumn(
    modifier: Modifier = Modifier,
    pokemonList: List<DrawableStringPair>,
    onPokemonClick: (Int) -> Unit,
    lazyListState: LazyListState = rememberLazyListState()
) {
    LazyColumn(
        state = lazyListState,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
            .height(500.dp),
    ) {
        items(pokemonList) { item ->
            PokemonCard(
                drawable = item.drawable,
                text = item.text,
                modifier = Modifier.height(80.dp),
                cardWidth = 350,
                onClick = { onPokemonClick(item.drawable) }
            )
        }
    }
}