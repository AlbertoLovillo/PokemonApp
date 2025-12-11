package com.example.garcialovilloalberto_practica3.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.garcialovilloalberto_practica3.R
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun PokemonNavigationRail(
    modifier: Modifier = Modifier
) {
    var homeIcon by remember { mutableStateOf(true) }
    var bookmarkIcon by remember { mutableStateOf(false) }

    NavigationRail(
        modifier = modifier.padding(start = 8.dp, end = 8.dp),
        containerColor = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            NavigationRailItem(icon = {
                Icon(
                    imageVector = Icons.Default.Home, contentDescription = null
                )
            }, label = {
                Text(stringResource(R.string.bottom_navigation_home))
            }, selected = homeIcon, onClick = {
                homeIcon = true; bookmarkIcon = false
            })

            Spacer(modifier = Modifier.height(8.dp))

            NavigationRailItem(icon = {
                Icon(imageVector = Icons.Default.Bookmark, contentDescription = null)
            }, label = {
                Text(stringResource(R.string.bottom_navigation_profile))
            }, selected = bookmarkIcon, onClick = {
                bookmarkIcon = true; homeIcon = false
            })
        }
    }
}