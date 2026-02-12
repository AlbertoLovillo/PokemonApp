package com.example.garcialovilloalberto_practica3.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

/**
 * Modelo de pantalla genérico que incluye un título y contenido personalizado.
 *
 * Tiene un título en la parte superior usando [Text] y permite incluir
 * cualquier contenido composable en la sección inferior en [content].
 * Se usa para organizar pantallas de Pokemon de forma consistente.
 *
 * @param title Recurso de string que representa el título de la pantalla.
 * Debe estar anotado con [StringRes].
 * @param modifier Modificador opcional para personalizar el layout del contenedor principal.
 * @param content Composable que representa el contenido principal de la pantalla.
 *
 */
@Composable
fun ScreenModel(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}