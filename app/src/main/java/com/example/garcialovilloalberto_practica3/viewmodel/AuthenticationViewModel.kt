package com.example.garcialovilloalberto_practica3.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.garcialovilloalberto_practica3.data.AuthenticationUiState
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AuthenticationViewModel(
    private val loginProvider: suspend (String, String) -> Result<Unit>
) : ViewModel() {

    private val _uiState = MutableStateFlow(AuthenticationUiState())
    val uiState: StateFlow<AuthenticationUiState> = _uiState.asStateFlow()

    fun defaultValues() {
        _uiState.value = _uiState.value.copy(
            email = "",
            password = "",
            confirmPassword = "",
            showDialogError = false
        )
    }

    fun updateEmail(email: String) {
        _uiState.update { it.copy(email = email) }
    }

    fun updatePassword(password: String) {
        _uiState.update { it.copy(password = password) }
    }

    fun updateConfirmPassword(confirmPassword: String) {
        _uiState.update { it.copy(confirmPassword = confirmPassword) }
    }


//    fun clickLogin(auth: FirebaseAuth, onNavigateToHome: () -> Unit) {
//        if (_uiState.value.password.length >= 6) {
//            auth.signInWithEmailAndPassword(_uiState.value.email, _uiState.value.password)
//                .addOnSuccessListener {
//                    onNavigateToHome()
//                }
//                .addOnFailureListener { e ->
//                    Log.e("Firebase", "Error en login: ${e.message}", e)
//                    showError()
//                }
//        } else showError()
//    }


    // Modificado para crear el ViewModel dentro de LoginScreen usando remember y así inyectarle la función de login sin tocar la arquitectura ni Firebase directamente.
    fun clickLogin(onNavigateToHome: () -> Unit) {

        val email = _uiState.value.email
        val password = _uiState.value.password

        if (password.length < 6) {
            showError()
            return
        }

        viewModelScope.launch {
            val result = loginProvider(email, password)

            if (result.isSuccess) {
                onNavigateToHome()
            } else {
                showError()
            }
        }
    }

    fun clickRegister(auth: FirebaseAuth, onNavigateToHome: () -> Unit) {
        if (_uiState.value.password.length >= 6 && _uiState.value.confirmPassword.length >= 6) {
            if (_uiState.value.password == _uiState.value.confirmPassword) {
                auth.createUserWithEmailAndPassword(_uiState.value.email, _uiState.value.password)
                    .addOnSuccessListener { user ->
                        onNavigateToHome()
                    }
                    .addOnFailureListener { e ->
                        Log.e("Firebase", "Error en registro: ${e.message}", e)
                        showError()
                    }
            }
        } else showError()
    }

    fun showError() {
        _uiState.value = _uiState.value.copy(showDialogError = true)
    }


    fun dismissError() {
        _uiState.value = _uiState.value.copy(showDialogError = false)
    }
}