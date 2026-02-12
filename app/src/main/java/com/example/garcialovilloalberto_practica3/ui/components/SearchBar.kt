package com.example.garcialovilloalberto_practica3.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Buscador simple con icono de lupa y placeholder. No es funcional.
 *
 * Utiliza un [TextField] con el icono de búsqueda [leadingIcon] y un texto de placeholder.
 *
 * @param modifier Modificador opcional para personalizar el layout del TextField.
 *
 */
@Composable
fun SearchBar(
    onBack: () -> Unit,
) {
    Row(
        modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
    ) {
        Spacer(Modifier.width(20.dp))

        Icon(
            imageVector = Icons.Default.ArrowBackIosNew,
            contentDescription = null,
            modifier = Modifier
                .clickable { onBack() }
                .padding(5.dp)
                .fillMaxHeight()
        )

        TextField(
            value = "",
            onValueChange = { /* todo */ },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                focusedContainerColor = MaterialTheme.colorScheme.surface
            ),
            placeholder = {
                Text("Search")
            },
            modifier = Modifier
                .heightIn(min = 60.dp)
                .padding(horizontal = 15.dp)
                .weight(1f)
        )
    }
}