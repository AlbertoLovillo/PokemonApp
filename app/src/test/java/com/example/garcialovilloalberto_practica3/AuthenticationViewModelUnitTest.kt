package com.example.garcialovilloalberto_practica3

import com.example.garcialovilloalberto_practica3.viewmodel.AuthenticationViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class AuthenticationViewModelUnitTest {

    @Test
    fun authenticationViewModel_LoginSuccess_NavigatesToHome() = runTest {

        // Simula un login que siempre devuelve éxito
        val fakeLoginProvider: suspend (String, String) -> Result<Unit> =
            { _, _ -> Result.success(Unit) }

        // Crea el ViewModel usando el login simulado
        val viewModel = AuthenticationViewModel(fakeLoginProvider)

        // Variable para comprobar si se llamó a la navegación
        var navigateCalled = false

        viewModel.updateEmail("test@email.com")
        viewModel.updatePassword("123456")

        // Ejecuta el login y marca navegación si tiene éxito
        viewModel.clickLogin {
            navigateCalled = true
        }

        // Espera a que terminen las corrutinas
        advanceUntilIdle()

        // Comprueba que se llamó a la navegación
        assertTrue(navigateCalled)

        // Comprueba que no se mostró el diálogo de error
        assertFalse(viewModel.uiState.value.showDialogError)
    }
}
