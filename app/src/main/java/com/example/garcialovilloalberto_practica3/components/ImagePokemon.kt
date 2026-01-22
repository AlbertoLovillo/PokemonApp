package com.example.garcialovilloalberto_practica3.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.garcialovilloalberto_practica3.ui.theme.blancoOscuro
import com.example.garcialovilloalberto_practica3.ui.theme.fondoFuego

/**
 * Muestra la imagen de un Pokémon en pantalla completa.
 *
 * La imagen se coloca dentro de un [Box] que ocupa el espacio disponible, con el color de fondo
 * [fondoFuego]. La imagen tiene bordes redondeados y clip.
 *
 * @param drawableId Recurso drawable que representa la imagen del Pokémon a mostrar.
 * Debe ser un identificador válido anotado con [DrawableRes].
 * @param modifier Modificador opcional para personalizar el layout del contenedor.
 *
 */
@Composable
fun ImagePokemon(
    @DrawableRes drawableId: Int, modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(fondoFuego)
    ) {
        Image(
            painter = painterResource(drawableId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .border(
                    width = 10.dp,
                    color = blancoOscuro,
                    shape = RoundedCornerShape(25.dp)
                )
                .clip(RoundedCornerShape(25.dp))
        )
    }
}

