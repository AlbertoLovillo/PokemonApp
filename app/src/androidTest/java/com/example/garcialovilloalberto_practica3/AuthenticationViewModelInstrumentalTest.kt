package com.example.garcialovilloalberto_practica3

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.garcialovilloalberto_practica3.viewmodel.AuthenticationViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AuthenticationViewModelInstrumentedTest {

    @Test
    fun authenticationViewModel_LoginSuccess_NavigatesToHome() = runBlocking {

        val fakeLoginProvider: suspend (String, String) -> Result<Unit> =
            { _, _ -> Result.success(Unit) }

        val viewModel = AuthenticationViewModel(fakeLoginProvider)

        var navigateCalled = false

        viewModel.updateEmail("test@email.com")
        viewModel.updatePassword("123456")

        viewModel.clickLogin {
            navigateCalled = true
        }

        delay(100) // Pequeña espera para que termine la corrutina

        assertTrue(navigateCalled)
        assertFalse(viewModel.uiState.value.showDialogError)
    }
}