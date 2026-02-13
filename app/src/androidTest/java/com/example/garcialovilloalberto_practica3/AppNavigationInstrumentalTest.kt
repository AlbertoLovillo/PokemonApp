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

class AppNavigationInstrumentalTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<ComponentActivity>()

    private lateinit var backStack: NavBackStack<NavKey>

    @Before
    fun setup() {
        backStack = NavBackStack(Routes.Login)
    }

    @Test
    fun login_navigates_to_home() {
        composeRule.setContent {
            AppNavigation(
                auth = FirebaseAuth.getInstance(),
                padding = PaddingValues(),
                backStack = backStack,
                homeScreenScrollState = LazyListState(),
                allPokemonScrollState = LazyListState()
            )
        }

        // Act
        composeRule.runOnUiThread {
            backStack.add(Routes.HomePokemon)
        }

        // Assert
        assertTrue(backStack.last() is Routes.HomePokemon)
    }

    @Test
    fun navigate_to_image_adds_correct_route() {
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

        composeRule.runOnUiThread {
            backStack.add(Routes.ImagePokemon(drawableId))
        }

        val last = backStack.last()

        assertTrue(last is Routes.ImagePokemon)
        assertEquals(drawableId, (last as Routes.ImagePokemon).drawable)
    }

    @Test
    fun back_removes_last_entry() {
        composeRule.setContent {
            AppNavigation(
                auth = FirebaseAuth.getInstance(),
                padding = PaddingValues(),
                backStack = backStack,
                homeScreenScrollState = LazyListState(),
                allPokemonScrollState = LazyListState()
            )
        }

        composeRule.runOnUiThread {
            backStack.add(Routes.HomePokemon)
            backStack.removeLastOrNull()
        }

        assertTrue(backStack.last() is Routes.Login)
    }
}