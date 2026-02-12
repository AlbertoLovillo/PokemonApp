package com.example.garcialovilloalberto_practica3.data

data class AuthenticationUiState(
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val showDialogError: Boolean = false,
)
