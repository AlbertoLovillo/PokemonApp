package com.example.garcialovilloalberto_practica3

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.rememberNavBackStack
import com.example.garcialovilloalberto_practica3.components.EditFloatingActionButton
import com.example.garcialovilloalberto_practica3.components.PokemonNavigationBar
import com.example.garcialovilloalberto_practica3.components.SearchBar
import com.example.garcialovilloalberto_practica3.navigation.AppNavigation
import com.example.garcialovilloalberto_practica3.navigation.Routes
import com.example.garcialovilloalberto_practica3.ui.theme.PokemonTheme
import com.example.garcialovilloalberto_practica3.ui.theme.blancoOscuro
import com.example.garcialovilloalberto_practica3.ui.theme.fondoAgua
import com.example.garcialovilloalberto_practica3.ui.theme.fondoFuego
import com.example.garcialovilloalberto_practica3.ui.theme.fondoPlanta

/**
 * Composable raíz de la aplicación.
 *
 * Define la estructura principal de la app utilizando [Scaffold], gestionando la navegación, el 
 * tema visual, los estados de scroll y las animaciones de fondo según la pantalla actual.
 *
 * La pantalla actual se determina a partir del [backStack], lo que permite:
 * - Cambiar dinámicamente el color de fondo.
 * - Mostrar u ocultar el botón de acción flotante.
 * - Adaptar el comportamiento del FAB al estado de scroll de cada pantalla.
 * 
 */
@Composable
fun MyPokemonApp() {

    val backStack = rememberNavBackStack(Routes.MainPokemonScreen)
    val currentRoute = backStack.lastOrNull()
    val mainScreenScrollState = rememberLazyListState()
    val allPokemonScrollState = rememberLazyListState()
    val showEditButton = currentRoute == Routes.MainPokemonScreen || currentRoute == Routes.AllPokemonScreen


    val animatedBackgroundColor by animateColorAsState(
        targetValue = when (currentRoute) {
            Routes.MainPokemonScreen -> fondoPlanta
            Routes.AllPokemonScreen -> fondoAgua
            is Routes.ImagePokemonScreen -> fondoFuego
            else -> blancoOscuro
        },
        label = "backgroundColorAnimation"
    )

    PokemonTheme {
        Scaffold(
            topBar = {
                Column(Modifier.fillMaxWidth()) {
                    Spacer(Modifier.height(32.dp))
                    SearchBar(Modifier.padding(horizontal = 16.dp))
                }
            },
            bottomBar = {
                PokemonNavigationBar(
                    backStack = backStack,
                )
            },
            containerColor = animatedBackgroundColor,
            floatingActionButton = {
                if (showEditButton) {
                    val isScrolling = when (currentRoute) {
                        Routes.MainPokemonScreen -> mainScreenScrollState.isScrollInProgress
                        Routes.AllPokemonScreen -> allPokemonScrollState.isScrollInProgress
                        else -> false
                    }

                    EditFloatingActionButton(
                        extended = isScrolling,
                        onClick = { }
                    )
                }
            }
            ,
        ) { innerPadding ->
            Spacer(Modifier.height(128.dp))
            AppNavigation(
                padding = innerPadding,
                backStack = backStack,
                mainScreenScrollState = mainScreenScrollState,
                allPokemonScrollState = allPokemonScrollState
            )
        }
    }
}
