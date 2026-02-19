package com.example.garcialovilloalberto_practica3

import com.example.garcialovilloalberto_practica3.viewmodel.AuthenticationViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

// Prueba local del Login (ejercicio 2)
@OptIn(ExperimentalCoroutinesApi::class)
class AuthenticationViewModelUnitTest {

    @Test
    fun authenticationViewModel_LoginExitoso_Unitaria() = runTest {

        // Creo un Login falso que siempre es correcto
        val fakeLoginProvider: suspend (String, String) -> Result<Unit> =
            { _, _ -> Result.success(Unit) }

        // Creo el ViewModel usando el login simulado
        val viewModel = AuthenticationViewModel(fakeLoginProvider)

        // Variable que indica si la funcion ha sido llamada
        var navigateCalled = false

        viewModel.updateEmail("test@email.com")
        viewModel.updatePassword("123456")

        // Simula que se ha logeado y si es exitoso navigateCalled = true
        viewModel.clickLogin {
            navigateCalled = true
        }

        // Pausa para que termine la corrutina
        advanceUntilIdle()

        // Comprueba que es true, sino daria error
        assertTrue(navigateCalled)
        // Comprueba que es false, sino daria error
        assertFalse(viewModel.uiState.value.showDialogError)
    }
}
