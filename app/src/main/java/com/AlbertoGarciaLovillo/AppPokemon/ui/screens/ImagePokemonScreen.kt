package com.AlbertoGarciaLovillo.AppPokemon.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.AlbertoGarciaLovillo.AppPokemon.ui.animations.swipeToDismiss
import com.AlbertoGarciaLovillo.AppPokemon.ui.components.ImagePokemon
import com.AlbertoGarciaLovillo.AppPokemon.ui.components.ScreenModel
import com.AlbertoGarciaLovillo.AppPokemon.viewmodel.PokemonViewModel

/**
 * Pantalla que muestra la imagen detallada de un Pokemon.
 *
 * Presenta una vista de imagen a pantalla completa y permite regresar a la pantalla anterior
 * deslizando hacia arriba.
 *
 * @param modifier Modificador opcional para personalizar el layout de la pantalla.
 * @param drawable Recurso drawable que representa la imagen del Pokemon a mostrar.
 * Debe ser un identificador válido anotado con [DrawableRes].
 * @param onNavigateBack Callback que se ejecuta cuando el usuario descarta la pantalla mediante el
 * gesto de deslizamiento.
 *
 */
@Composable
fun ImagePokemonScreen(
    viewModel: PokemonViewModel = viewModel(),
    onNavigateBack: () -> Unit
) {

    val uiState by viewModel.uiState.collectAsState()

    Column(modifier = Modifier.swipeToDismiss(onDismissed = onNavigateBack)) {
        Spacer(Modifier.height(86.dp))

        ScreenModel(
            title = "Pokemon image"
        ) {
            ImagePokemon(uiState.imageUrl)
        }
    }
}
