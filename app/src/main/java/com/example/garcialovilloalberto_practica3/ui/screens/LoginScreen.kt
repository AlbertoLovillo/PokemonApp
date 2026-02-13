package com.example.garcialovilloalberto_practica3.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.garcialovilloalberto_practica3.ui.components.ErrorAlert
import com.example.garcialovilloalberto_practica3.viewmodel.AuthenticationViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

@Composable
fun LoginScreen(
//    auth: FirebaseAuth,   // -> Quitado al tener que modificar el AuthenticationViewModel
//    viewModel: AuthenticationViewModel = viewModel<AuthenticationViewModel>(),   // -> Quitado para poder crearlo abajo de la forma necesaria.
    onNavigateToRegister: () -> Unit,
    onNavigateToHome: () -> Unit
) {

    // Añadido para que el AuthenticationViewModel pueda iniciar sesión en Firebase sin depender directamente de la implementación.
    val firebaseAuth = FirebaseAuth.getInstance()

    val viewModel = remember {
        AuthenticationViewModel { email, password ->
            try {
                firebaseAuth
                    .signInWithEmailAndPassword(email, password)
                    .await()
                Result.success(Unit)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    val uiState by viewModel.uiState.collectAsState()

    var hide by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login",
            fontSize = 45.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Email") },
            value = uiState.email,
            onValueChange = { viewModel.updateEmail(it) }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Password") },
            value = uiState.password,
            onValueChange = { viewModel.updatePassword(it) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation =
                if (hide) PasswordVisualTransformation()
                else VisualTransformation.None,
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.RemoveRedEye,
                    contentDescription = null,
                    modifier = Modifier.clickable { hide = !hide }
                )
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                viewModel.clickLogin(onNavigateToHome)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(text = "Enter")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row {
            Text(text = "Don't have an account?")

            Spacer(modifier = Modifier.padding(5.dp))

            Text(
                text = "Register",
                modifier = Modifier.clickable {
                    onNavigateToRegister()
                    viewModel.defaultValues()
                },
                color = MaterialTheme.colorScheme.primary
            )
        }
        if (uiState.showDialogError) {
            ErrorAlert()
        }
    }
}