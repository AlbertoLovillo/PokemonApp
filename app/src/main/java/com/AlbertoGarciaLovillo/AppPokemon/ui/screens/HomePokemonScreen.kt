package com.AlbertoGarciaLovillo.AppPokemon.ui.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.AlbertoGarciaLovillo.AppPokemon.ui.components.FavoritePokemonGrid
import com.AlbertoGarciaLovillo.AppPokemon.ui.components.HomePokemonCarousel
import com.AlbertoGarciaLovillo.AppPokemon.ui.components.ScreenModel
import com.AlbertoGarciaLovillo.AppPokemon.viewmodel.PokemonViewModel

/**
 * Pantalla principal de la aplicación.
 *
 * Muestra una lista desplazable que contiene un carrusel de Pokemon por generación y una cuadricula
 * de Pokemon favoritos.
 * El estado de la UI se obtiene desde [PokemonViewModel].
 *
 * @param modifier Modificador opcional para personalizar el layout de la pantalla.
 * @param viewModel ViewModel que expone el estado principal de la UI mediante [mainUiState].
 * @param onNavigateToImagePokemon Callback que se ejecuta al seleccionar un Pokemon, recibiendo
 * como parámetro el ID del Pokemon seleccionado.
 * @param lazyListState Estado de la lista utilizado para controlar y observar el desplazamiento del
 * [LazyColumn].
 *
 */
@Composable
fun HomePokemonScreen(
    modifier: Modifier = Modifier,
    viewModel: PokemonViewModel = viewModel(),
    onNavigateToImagePokemon: () -> Unit,
    lazyListState: LazyListState = rememberLazyListState()
    ) {
    val uiState by viewModel.uiState.collectAsState()
    val pokemonsByPokedex by viewModel.pokemonsByPokedex.collectAsState()
    val pokemonsByName by viewModel.pokemonsByName.collectAsState()

    LazyColumn(
        state = lazyListState,
        modifier = modifier
    ) {
        item {
            Spacer(Modifier.height(86.dp))
        }
        item {
            ScreenModel(
                title = "Pokemon") {
                HomePokemonCarousel(
                    homePokemonList = pokemonsByPokedex)
            }
        }

        item {
            ScreenModel(
                title = "Favorite Collections") {
                FavoritePokemonGrid(
                    favoritePokemonList = pokemonsByName,
                    onPokemonClick = onNavigateToImagePokemon)
            }
        }

        item {
            Spacer(Modifier.height(16.dp))
        }
    }
}
