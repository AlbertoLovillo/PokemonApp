package com.AlbertoGarciaLovillo.AppPokemon.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.AlbertoGarciaLovillo.AppPokemon.ui.components.AllPokemonColumn
import com.AlbertoGarciaLovillo.AppPokemon.ui.components.ScreenModel
import com.AlbertoGarciaLovillo.AppPokemon.viewmodel.PokemonViewModel

/**
 * Pantalla que muestra la lista completa de Pokemon.
 *
 * Obtiene el estado de la UI desde [PokemonViewModel] y presenta los Pokemon en una columna
 * desplazable.
 * Permite navegar al detalle de un Pokemon seleccionado y regresar a la pantalla anterior.
 *
 * @param modifier Modificador opcional para personalizar el layout de la pantalla.
 * @param viewModel ViewModel encargado de exponer el estado de la pantalla mediante
 * [allPokemonUiState].
 * @param onNavigateToImagePokemon Callback que se ejecuta al seleccionar un Pokemon, recibiendo
 * como parámetro el ID del Pokemon.
 * @param onNavigateBack Callback invocado para regresar a la pantalla anterior.
 * @param lazyListState Estado de scroll de la lista de Pokemon, utilizado para controlar y observar
 * el desplazamiento de la columna.
 *
 */
@Composable
fun AllPokemonScreen(
    viewModel: PokemonViewModel = viewModel(),
    onNavigateToImagePokemon: () -> Unit,
    onNavigateBack: () -> Unit,
    lazyListState: LazyListState = rememberLazyListState()

) {
    val uiState by viewModel.uiState.collectAsState()
    val pokemonsByName by viewModel.pokemonsByName.collectAsState()

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Spacer(Modifier.height(86.dp))
        ScreenModel(
            title = "Pokemon"
        ) {
            AllPokemonColumn(
                pokemonList = pokemonsByName,
                onPokemonClick =  onNavigateToImagePokemon,
                lazyListState = lazyListState
            )
        }
    }
}