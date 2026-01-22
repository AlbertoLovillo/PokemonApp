package com.example.garcialovilloalberto_practica3.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

/**
 * Elemento que muestra un Pokémon con imagen circular y nombre.
 *
 * Se muestra en un [Column]. La imagen se recorta en un [CircleShape].
 *
 * @param drawable Recurso drawable que representa la imagen del Pokémon.
 * Debe estar anotado con [DrawableRes].
 * @param text Recurso de string que representa el nombre del Pokémon.
 * Debe estar anotado con [StringRes].
 * @param modifier Modificador opcional para personalizar el layout del elemento.
 *
 */
@Composable
fun PokemonElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.background(Color.Transparent),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(text),
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

//@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
//@Composable
//fun PokemonElementPreview() {
//    PokemonTheme {
//        PokemonElement(
//            text = R.string.meganium,
//            drawable = R.drawable.meganium,
//            modifier = Modifier.padding(8.dp)
//        )
//    }
//}