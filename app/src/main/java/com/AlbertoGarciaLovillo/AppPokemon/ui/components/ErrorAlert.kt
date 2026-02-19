package com.AlbertoGarciaLovillo.AppPokemon.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.AlbertoGarciaLovillo.AppPokemon.viewmodel.AuthenticationViewModel

@Composable
fun ErrorAlert(viewModel: AuthenticationViewModel = viewModel<AuthenticationViewModel>()) {

    val uiState by viewModel.uiState.collectAsState()

    AlertDialog(
        onDismissRequest = { viewModel.dismissError() },
        confirmButton = {
            TextButton(
                onClick = { viewModel.dismissError() }
            ) {
                Text("Confirm")
            }
        },
        title = {
            Text("Error")
        },
        text = {
            Text("Incorrect email or password")
        }
    )
}