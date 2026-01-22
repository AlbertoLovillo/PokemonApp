package com.example.garcialovilloalberto_practica3.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Botón de acción flotante personalizado con etiqueta animada. No es funcional.
 *
 * Muestra un [FloatingActionButton] que puede expandirse para mostrar un texto ("Editar") junto al
 * ícono cuando [extended] es verdadero.
 * La animación combina [fadeIn]/[fadeOut] con deslizamiento horizontal y redimensionamiento suave
 * gracias a [animateContentSize].
 *
 * @param extended Indica si el botón debe mostrar la etiqueta junto al ícono.
 * @param onClick Lambda que se ejecuta al pulsar el botón.
 * @param modifier Modificador opcional para personalizar el layout del FAB.
 *
 */
@Composable
fun EditFloatingActionButton(
    extended: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    FloatingActionButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp).animateContentSize()
        ) {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = null
            )

            AnimatedVisibility(
                visible = extended,
                enter = fadeIn(
                    animationSpec = tween(
                        durationMillis = 150,
                        delayMillis = 100
                    )
                ) + slideInHorizontally(
                    initialOffsetX = { it / 2 },
                    animationSpec = tween(delayMillis = 100)
                ),
                exit = fadeOut(
                    animationSpec = tween(
                        durationMillis = 300
                    )
                ) + slideOutHorizontally(
                    animationSpec = tween(
                        durationMillis = 200
                    )
                )
            ) {
                Text(
                    text = "Editar",
                    modifier = Modifier.padding(start = 8.dp, top = 3.dp)
                )
            }
        }
    }
}