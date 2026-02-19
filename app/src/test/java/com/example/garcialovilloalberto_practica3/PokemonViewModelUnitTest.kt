package com.example.garcialovilloalberto_practica3

import com.example.garcialovilloalberto_practica3.data.favoriteCollectionData
import com.example.garcialovilloalberto_practica3.data.pokemonDataAlphabetical
import com.example.garcialovilloalberto_practica3.data.pokemonDataGenerational
import com.example.garcialovilloalberto_practica3.viewmodel.PokemonViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

// Prueba unitaria del ViewModel (ejercicio 1)
class PokemonViewModelUnitTest {

    private val viewModel = PokemonViewModel()

    @Test
    fun pokemonViewModel_InicializacionCorrecta() {

        val homeState = viewModel.homeUiState.value
        val allState = viewModel.allPokemonUiState.value

        // Comprueba que no este vacio
        assertTrue(homeState.homePokemonList.isNotEmpty())
        assertTrue(allState.allPokemonList.isNotEmpty())
        assertTrue(allState.allPokemonList.isNotEmpty())

        // Comprueba que los dos datos sean los mismos
        assertEquals(pokemonDataGenerational, homeState.homePokemonList)
        assertEquals(favoriteCollectionData, homeState.favoritePokemonList)
        assertEquals(pokemonDataAlphabetical, allState.allPokemonList)
    }
}