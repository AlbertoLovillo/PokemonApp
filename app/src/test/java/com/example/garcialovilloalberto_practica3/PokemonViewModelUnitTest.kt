package com.example.garcialovilloalberto_practica3

import com.example.garcialovilloalberto_practica3.data.favoriteCollectionData
import com.example.garcialovilloalberto_practica3.data.pokemonDataAlphabetical
import com.example.garcialovilloalberto_practica3.data.pokemonDataGenerational
import com.example.garcialovilloalberto_practica3.viewmodel.PokemonViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class PokemonViewModelUnitTest {

    private val viewModel = PokemonViewModel()

    @Test
    fun pokemonViewModel_InicializacionCorrecta() {

        val homeState = viewModel.homeUiState.value
        val allState = viewModel.allPokemonUiState.value

        // Verifica que las listas no estén vacías
        assertTrue(homeState.homePokemonList.isNotEmpty())
        assertTrue(allState.allPokemonList.isNotEmpty())
        assertTrue(allState.allPokemonList.isNotEmpty())

        // Verifica que las listas coincidan con las listas de datos
        assertEquals(pokemonDataGenerational, homeState.homePokemonList)
        assertEquals(favoriteCollectionData, homeState.favoritePokemonList)
        assertEquals(pokemonDataAlphabetical, allState.allPokemonList)
    }
}