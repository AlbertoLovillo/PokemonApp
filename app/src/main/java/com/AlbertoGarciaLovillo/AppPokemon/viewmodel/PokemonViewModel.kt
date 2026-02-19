package com.AlbertoGarciaLovillo.AppPokemon.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.AlbertoGarciaLovillo.AppPokemon.data.Pokemon
import com.AlbertoGarciaLovillo.AppPokemon.data.PokemonUiState
import com.AlbertoGarciaLovillo.AppPokemon.data.favoriteCollectionData
import com.AlbertoGarciaLovillo.AppPokemon.data.pokemonDataAlphabetical
import com.AlbertoGarciaLovillo.AppPokemon.data.pokemonDataGenerational
import com.google.firebase.Firebase
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * ViewModel encargado de gestionar el estado de la UI.
 *
 * Expone estados inmutables mediante [kotlinx.coroutines.flow.StateFlow] para las distintas pantallas de la aplicación,
 * separando la lógica de presentación de la interfaz de usuario.
 *
 */
class PokemonViewModel : ViewModel() {

    private val db = Firebase.firestore
    private val pokemonCollection = db.collection("pokemonData")
    private val homePokemonQuery = pokemonCollection.orderBy("pokedex")
    private val allPokemonQuery = pokemonCollection.orderBy("name")

    private val _pokemonsByName = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemonsByName: StateFlow<List<Pokemon>> = _pokemonsByName

    private val _pokemonsByPokedex = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemonsByPokedex: StateFlow<List<Pokemon>> = _pokemonsByPokedex


    private val _uiState = MutableStateFlow(PokemonUiState())
    val uiState: StateFlow<PokemonUiState> = _uiState.asStateFlow()

    init {
        listenPokemon(homePokemonQuery, _pokemonsByPokedex)
        listenPokemon(allPokemonQuery, _pokemonsByName)
    }

    fun updateName(valor: String) {
        _uiState.update { it.copy(name = valor) }
    }

    fun updateImageUrl(valor: String) {
        _uiState.update { it.copy(imageUrl = valor) }
    }

    fun updatePokedex(valor: Int) {
        _uiState.update { it.copy(pokedex = valor) }
    }

    fun cleanState() {
        _uiState.value = PokemonUiState()
    }

    private fun listenPokemon(
        query: Query,
        state: MutableStateFlow<List<Pokemon>>
    ) {
        query.addSnapshotListener { snapshot, error ->
            if (error != null) return@addSnapshotListener

            snapshot?.let {
                val list = it.documents.mapNotNull { doc ->
                    val pokemon = doc.toObject(Pokemon::class.java)
                    pokemon?.id = doc.id
                    pokemon
                }
                state.value = list
            }
        }
    }


    fun addPokemon() {
        val pokemon = Pokemon(
            name = _uiState.value.name,
            imageUrl = _uiState.value.imageUrl,
            pokedex = _uiState.value.pokedex
        )

        pokemonCollection.add(pokemon)
        cleanState()
    }


    fun deletePokemon(id: String) {
        pokemonCollection.document(id).delete()
    }


    fun updatePokemon(id: String) {

        val datosActualizados = mutableMapOf<String, Any>()

        if (_uiState.value.name.isNotBlank()) datosActualizados["name"] = _uiState.value.name
        if (_uiState.value.imageUrl.isNotBlank()) datosActualizados["imageUrl"] = _uiState.value.imageUrl
        if (_uiState.value.pokedex != 0) datosActualizados["pokedex"] = _uiState.value.pokedex

        pokemonCollection.document(id).update(datosActualizados)

        cleanState()
    }

}