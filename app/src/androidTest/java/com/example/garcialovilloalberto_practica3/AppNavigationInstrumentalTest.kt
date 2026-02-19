package com.example.garcialovilloalberto_practica3

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.garcialovilloalberto_practica3.navigation.AppNavigation
import com.example.garcialovilloalberto_practica3.navigation.Routes
import com.google.firebase.auth.FirebaseAuth
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

// Prueba de Navigation 3 (ejercicio 3c)
class AppNavigationInstrumentalTest {

    // Regla que permite interacturar con la interfaz
    @get:Rule
    val composeRule = createAndroidComposeRule<ComponentActivity>()

    // Crea un BackStack para el test
    private lateinit var backStack: NavBackStack<NavKey>

    @Before
    fun setup() {
        backStack = NavBackStack(Routes.Login)
    }

    @Test
    fun login_NavigatesToHome() {
        composeRule.setContent {
            AppNavigation(
                auth = FirebaseAuth.getInstance(),
                padding = PaddingValues(),
                backStack = backStack,
                homeScreenScrollState = LazyListState(),
                allPokemonScrollState = LazyListState()
            )
        }

        // Ejecuto eso en en hilo principal (UI Thread)
        composeRule.runOnUiThread {
            backStack.add(Routes.HomePokemon)
        }

        // Compruebo que la ultima pantalla cargada es la indicada antes
        assertTrue(backStack.last() is Routes.HomePokemon)
    }

    @Test
    fun navigateToImage_AddRutaCorrecta() {
        composeRule.setContent {
            AppNavigation(
                auth = FirebaseAuth.getInstance(),
                padding = PaddingValues(),
                backStack = backStack,
                homeScreenScrollState = LazyListState(),
                allPokemonScrollState = LazyListState()
            )
        }

        val drawableId = 123

        // Ejecuto eso en en hilo principal (UI Thread)
        composeRule.runOnUiThread {
            backStack.add(Routes.ImagePokemon(drawableId))
        }

        val last = backStack.last()

        // Compruebo que la ultima pantalla cargada es la indicada antes
        assertTrue(last is Routes.ImagePokemon)
        // Compruebo que el drawableId sea el de la pantalla ImagePokemon
        assertEquals(drawableId, (last as Routes.ImagePokemon).drawable)
    }

    @Test
    fun navigateBack_RemoveSaltOrNull() {
        composeRule.setContent {
            AppNavigation(
                auth = FirebaseAuth.getInstance(),
                padding = PaddingValues(),
                backStack = backStack,
                homeScreenScrollState = LazyListState(),
                allPokemonScrollState = LazyListState()
            )
        }

        // Ejecuto eso en en hilo principal (UI Thread)
        composeRule.runOnUiThread {
            backStack.add(Routes.HomePokemon)
            backStack.removeLastOrNull()
        }

        // Compruebo que la ultima pantalla cargada es la anterior a la indicada antes
        assertTrue(backStack.last() is Routes.Login)
    }
}