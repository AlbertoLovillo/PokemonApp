package com.AlbertoGarciaLovillo.AppPokemon.data

data class AuthenticationUiState(
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val showDialogError: Boolean = false,
)
