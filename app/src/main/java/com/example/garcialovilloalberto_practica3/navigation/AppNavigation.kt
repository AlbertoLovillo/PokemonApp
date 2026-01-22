package com.example.garcialovilloalberto_practica3.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.example.garcialovilloalberto_practica3.screens.AllPokemonScreen
import com.example.garcialovilloalberto_practica3.screens.ImagePokemonScreen
import com.example.garcialovilloalberto_practica3.screens.MainPokemonScreen
import kotlinx.serialization.Serializable

/**
 * Representa las rutas de navegación de la aplicación.
 *
 * Cada subclase define una pantalla navegable y, cuando es necesario,
 * los parámetros requeridos para su visualización.
 */
sealed class Routes : NavKey {
    @Serializable
    data object MainPokemonScreen : Routes()

    @Serializable
    data object AllPokemonScreen : Routes()

    @Serializable
    data class ImagePokemonScreen(val drawable: Int) : Routes()
}

/**
 * Composable encargado de definir la navegación de la aplicación.
 *
 * Asocia cada [Routes] con su pantalla correspondiente y gestiona la navegación hacia adelante y
 * hacia atrás mediante un [NavBackStack].
 *
 * @param padding Espaciado interno proporcionado por el contenedor superior.
 * @param backStack Pila de navegación que mantiene el historial de pantallas.
 * @param mainScreenScrollState Estado de scroll de la pantalla principal de Pokemon.
 * @param allPokemonScrollState Estado de scroll de la pantalla de todos los Pokemon.
 *
 */
@Composable
fun AppNavigation(
    padding: PaddingValues,
    backStack: NavBackStack<NavKey>,
    mainScreenScrollState: LazyListState,
    allPokemonScrollState: LazyListState
) {

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Routes.MainPokemonScreen> {
                MainPokemonScreen(
                    onNavigateToImagePokemon = { drawable ->
                    backStack.add(Routes.ImagePokemonScreen(drawable))
                    },
                    lazyListState = mainScreenScrollState
                )
            }
            entry<Routes.AllPokemonScreen> {
                AllPokemonScreen(
                    onNavigateToImagePokemon = { drawable ->
                        backStack.add(Routes.ImagePokemonScreen(drawable))
                    },
                    onNavigateBack = { backStack.removeLastOrNull() },
                    lazyListState = allPokemonScrollState
                )
            }
            entry<Routes.ImagePokemonScreen> { entry ->
                ImagePokemonScreen(
                    drawable = entry.drawable,
                    onNavigateBack = { backStack.removeLastOrNull() }
                )
            }
        }
    )
}