package com.AlbertoGarciaLovillo.AppPokemon

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.rememberNavBackStack
import com.AlbertoGarciaLovillo.AppPokemon.ui.components.EditFloatingActionButton
import com.AlbertoGarciaLovillo.AppPokemon.ui.components.PokemonNavigationBar
import com.AlbertoGarciaLovillo.AppPokemon.ui.components.SearchBar
import com.AlbertoGarciaLovillo.AppPokemon.navigation.AppNavigation
import com.AlbertoGarciaLovillo.AppPokemon.navigation.Routes
import com.AlbertoGarciaLovillo.AppPokemon.ui.theme.PokemonTheme
import com.AlbertoGarciaLovillo.AppPokemon.ui.theme.blancoOscuro
import com.AlbertoGarciaLovillo.AppPokemon.ui.theme.fondoAgua
import com.AlbertoGarciaLovillo.AppPokemon.ui.theme.fondoFuego
import com.AlbertoGarciaLovillo.AppPokemon.ui.theme.fondoPlanta
import com.google.firebase.auth.FirebaseAuth

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
fun AppStructure(
    auth: FirebaseAuth
) {

    val backStack = rememberNavBackStack(Routes.Login)
    val currentRoute = backStack.lastOrNull()
    val homeScreenScrollState = rememberLazyListState()
    val allPokemonScrollState = rememberLazyListState()
    val showEditButton = currentRoute == Routes.HomePokemon || currentRoute == Routes.AllPokemon


    val animatedBackgroundColor by animateColorAsState(
        targetValue = when (currentRoute) {
            Routes.HomePokemon -> fondoPlanta
            Routes.AllPokemon -> fondoAgua
            is Routes.ImagePokemon -> fondoFuego
            else -> blancoOscuro
        },
        label = "backgroundColorAnimation"
    )

    PokemonTheme {
        Scaffold(
            topBar = {
                if (currentRoute != Routes.Login && currentRoute != Routes.Register) {
                    Column(Modifier.fillMaxWidth()) {
                        Spacer(Modifier.height(40.dp))
                        SearchBar(
                            onBack = { backStack.removeLastOrNull() }
                        )
                        Spacer(Modifier.height(10.dp))
                    }
                }
            },
            bottomBar = {
                if (currentRoute != Routes.Login && currentRoute != Routes.Register) {
                    PokemonNavigationBar(
                        backStack = backStack,
                    )
                }
            },
            containerColor = animatedBackgroundColor,
            floatingActionButton = {
                if (showEditButton) {
                    val isScrolling = when (currentRoute) {
                        Routes.HomePokemon -> homeScreenScrollState.isScrollInProgress
                        Routes.AllPokemon -> allPokemonScrollState.isScrollInProgress
                        else -> false
                    }

                    EditFloatingActionButton(
                        extended = isScrolling,
                        onClick = { }
                    )
                }
            },
        ) { innerPadding ->
            Spacer(Modifier.height(128.dp))
            AppNavigation(
                auth = auth,
                padding = innerPadding,
                backStack = backStack,
                homeScreenScrollState = homeScreenScrollState,
                allPokemonScrollState = allPokemonScrollState
            )
        }
    }
}
