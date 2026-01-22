package com.example.garcialovilloalberto_practica3.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

/**
 * Tarjeta que muestra un Pokemon con imagen y nombre.
 *
 * Utiliza un [ElevatedCard] que muestra la imagen y el nombre del Pokemon en un [Row].
 * Permite reaccionar al clic mediante [onClick].
 *
 * @param drawable Recurso drawable que representa la imagen del Pokemon.
 * Debe estar anotado con [DrawableRes].
 * @param text Recurso de string que representa el nombre del Pokemon.
 * Debe estar anotado con [StringRes].
 * @param modifier Modificador opcional para personalizar el layout de la tarjeta.
 * @param cardWidth Ancho de la tarjeta en dp.
 * @param onClick Lambda que se ejecuta al pulsar la tarjeta.
 *
 */
@Composable
fun PokemonCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier,
    cardWidth: Int,
    onClick: () -> Unit //Nuevo
) {
    ElevatedCard(
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        modifier = modifier.clickable(
            onClick = onClick //Nuevo
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(cardWidth.dp)
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)
            )
            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}