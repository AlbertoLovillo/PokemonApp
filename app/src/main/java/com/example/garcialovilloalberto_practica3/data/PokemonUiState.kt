package com.example.garcialovilloalberto_practica3.data

/**
 * Estado de la UI para la pantalla principal de Pokemon.
 *
 * Contiene la información necesaria para representar las secciones de Pokemon por generación y la
 * colección de Pokemon favoritos.
 *
 * Este estado es inmutable y está pensado para ser observado desde composables mediante flujos de
 * estado.
 *
 * @property generationalPokemon Lista de Pokemon ordenados por generación.
 * @property favoritePokemon Lista de Pokemon favoritos.
 *
 */
data class MainPokemonUiState(
    val generationalPokemon: List<DrawableStringPair> = emptyList(),
    val favoritePokemon: List<DrawableStringPair> = emptyList()
)

/**
 * Estado de la UI para la pantalla que muestra todos los Pokemon.
 *
 * Representa todos los Pokemon disponibles en la aplicación.
 *
 * Este estado es inmutable y permite una representación declarativa de la interfaz de usuario.
 *
 * @property allPokemon Lista completa de Pokemon.
 *
 */
data class AllPokemonUiState(
    val allPokemon: List<DrawableStringPair> = emptyList()
)