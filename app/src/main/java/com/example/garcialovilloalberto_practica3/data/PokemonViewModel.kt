package com.example.garcialovilloalberto_practica3.data

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * ViewModel encargado de gestionar el estado de la UI.
 *
 * Expone estados inmutables mediante [StateFlow] para las distintas pantallas de la aplicación,
 * separando la lógica de presentación de la interfaz de usuario.
 *
 */
class PokemonViewModel : ViewModel() {

    private val _mainUiState = MutableStateFlow(MainPokemonUiState())
    val mainUiState: StateFlow<MainPokemonUiState> = _mainUiState.asStateFlow()

    private val _allPokemonUiState = MutableStateFlow(AllPokemonUiState())
    val allPokemonUiState: StateFlow<AllPokemonUiState> = _allPokemonUiState.asStateFlow()

    init {
        loadData()
    }

    /**
     * Carga los datos iniciales de Pokemon y actualiza los estados de la UI.
     *
     * Inicializa las listas de Pokemon por generación, favoritos y el listado completo de Pokemon.
     *
     */
    private fun loadData() {
        _mainUiState.update {
            it.copy(
                generationalPokemon = pokemonDataGenerational,
                favoritePokemon = favoriteCollectionData
            )
        }

        _allPokemonUiState.update {
            it.copy(
                allPokemon = pokemonDataAlphabetical
            )
        }
    }
}
