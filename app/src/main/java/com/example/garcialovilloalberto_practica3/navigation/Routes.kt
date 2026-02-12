package com.example.garcialovilloalberto_practica3.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

/**
 * Representa las rutas de navegación de la aplicación.
 *
 * Cada subclase define una pantalla navegable y, cuando es necesario,
 * los parámetros requeridos para su visualización.
 */
sealed class Routes : NavKey {
    @Serializable
    data object HomePokemon : Routes()

    @Serializable
    data object AllPokemon : Routes()

    @Serializable
    data class ImagePokemon(val drawable: Int) : Routes()

    @Serializable
    data object Login : Routes()

    @Serializable
    data object Register : Routes()
}