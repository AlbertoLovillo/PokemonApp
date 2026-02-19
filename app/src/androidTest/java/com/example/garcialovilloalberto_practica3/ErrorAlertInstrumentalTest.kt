package com.example.garcialovilloalberto_practica3

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.garcialovilloalberto_practica3.ui.components.ErrorAlert
import com.example.garcialovilloalberto_practica3.viewmodel.AuthenticationViewModel
import junit.framework.TestCase.assertFalse
import org.junit.Rule
import org.junit.Test

// Prueba unitaria (ejercicio 3a)
class ErrorAlertInstrumentalTest {
    // Regla que permite interacturar con la interfaz
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun errorAlertTest() {

        // Creo un viewModel que falla siempre
        val viewModel = AuthenticationViewModel { _, _ ->
            Result.failure(Exception())
        }

        // Hago que salga el error
        viewModel.showError()

        // Ejecuto el ErrorAlert
        composeTestRule.setContent {
            ErrorAlert(viewModel = viewModel)
        }

        // Comprueba que el texto es el siguiente
        composeTestRule.onNodeWithText("Error").assertExists()
        composeTestRule.onNodeWithText("Incorrect email or password").assertExists()

        // Clicka el boton
        composeTestRule.onNodeWithText("Confirm").performClick()

        // Espera a que se ejecute todo
        composeTestRule.waitForIdle()

        // Comprueba que el error se ha quitado
        assertFalse(viewModel.uiState.value.showDialogError)
    }
}