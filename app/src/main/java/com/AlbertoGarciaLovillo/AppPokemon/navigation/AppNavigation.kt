package com.AlbertoGarciaLovillo.AppPokemon.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.AlbertoGarciaLovillo.AppPokemon.ui.screens.AllPokemonScreen
import com.AlbertoGarciaLovillo.AppPokemon.ui.screens.ImagePokemonScreen
import com.AlbertoGarciaLovillo.AppPokemon.ui.screens.HomePokemonScreen
import com.AlbertoGarciaLovillo.AppPokemon.ui.screens.LoginScreen
import com.AlbertoGarciaLovillo.AppPokemon.ui.screens.RegisterScreen
import com.google.firebase.auth.FirebaseAuth

/**
 * Composable encargado de definir la navegación de la aplicación.
 *
 * Asocia cada [Routes] con su pantalla correspondiente y gestiona la navegación hacia adelante y
 * hacia atrás mediante un [NavBackStack].
 *
 * @param padding Espaciado interno proporcionado por el contenedor superior.
 * @param backStack Pila de navegación que mantiene el historial de pantallas.
 * @param homeScreenScrollState Estado de scroll de la pantalla principal de Pokemon.
 * @param allPokemonScrollState Estado de scroll de la pantalla de todos los Pokemon.
 *
 */
@Composable
fun AppNavigation(
    auth: FirebaseAuth,
    padding: PaddingValues,
    backStack: NavBackStack<NavKey>,
    homeScreenScrollState: LazyListState,
    allPokemonScrollState: LazyListState
) {

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Routes.HomePokemon> {
                HomePokemonScreen(
                    onNavigateToImagePokemon = { backStack.add(Routes.ImagePokemon) },
                    lazyListState = homeScreenScrollState
                )
            }
            entry<Routes.AllPokemon> {
                AllPokemonScreen(
                    onNavigateToImagePokemon = { backStack.add(Routes.ImagePokemon) },
                    onNavigateBack = { backStack.removeLastOrNull() },
                    lazyListState = allPokemonScrollState
                )
            }
            entry<Routes.ImagePokemon> {
                ImagePokemonScreen(
                    onNavigateBack = { backStack.removeLastOrNull() }
                )
            }
            entry<Routes.Login> {
                LoginScreen(
                    auth = auth,
                    onNavigateToRegister = { backStack.add(Routes.Register) },
                    onNavigateToHome = { backStack.add(Routes.HomePokemon) }
                )
            }
            entry<Routes.Register> {
                RegisterScreen(
                    auth = auth,
                    onNavigateToLogin = { backStack.add(Routes.Login) },
                    onNavigateToHome = { backStack.add(Routes.HomePokemon) }
                )
            }
        }
    )
}