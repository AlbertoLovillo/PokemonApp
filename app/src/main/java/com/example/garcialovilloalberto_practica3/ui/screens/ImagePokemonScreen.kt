package com.example.garcialovilloalberto_practica3.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.garcialovilloalberto_practica3.R
import com.example.garcialovilloalberto_practica3.ui.animations.swipeToDismiss
import com.example.garcialovilloalberto_practica3.ui.components.ImagePokemon
import com.example.garcialovilloalberto_practica3.ui.components.ScreenModel

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
    modifier: Modifier = Modifier,
    @DrawableRes drawable: Int,
    onNavigateBack: () -> Unit
) {
    Column(modifier = modifier.swipeToDismiss(onDismissed = onNavigateBack)) {
        Spacer(Modifier.height(86.dp))

        ScreenModel(
            title = "Pokemon image"
        ) {
            ImagePokemon(drawable)
        }
    }
}
