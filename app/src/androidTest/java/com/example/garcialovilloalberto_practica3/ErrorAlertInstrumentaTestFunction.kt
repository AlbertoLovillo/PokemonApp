package com.example.garcialovilloalberto_practica3

import androidx.activity.ComponentActivity
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

// Prueba de funciones (ejercicio 3b)
class ErrorAlertInstrumentaTestFunction {
    // Regla que permite interacturar con la interfaz
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun errorAlert_MuestraCorrectamente() {

        composeTestRule.setContent {

            var showDialog by remember { mutableStateOf(true) }

            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    confirmButton = { TextButton( onClick = { showDialog = false } ) { Text("Confirm") } },
                    title = { Text("Error") },
                    text = { Text("Incorrect email or password") }
                )
            }
        }

        // Comprobamos si se ve en pantalla
        composeTestRule
            .onNodeWithText("Incorrect email or password")
            .assertIsDisplayed()

        // Clicka el boton
        composeTestRule
            .onNodeWithText("Confirm")
            .performClick()

        // Comprobamos que no se vea en pantalla
        composeTestRule
            .onNodeWithText("Incorrect email or password")
            .assertDoesNotExist()
    }
}
