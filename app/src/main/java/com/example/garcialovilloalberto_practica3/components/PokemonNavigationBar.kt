package com.example.garcialovilloalberto_practica3.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.garcialovilloalberto_practica3.R
import com.example.garcialovilloalberto_practica3.navigation.AppScreens

@Composable
fun PokemonNavigationBar(modifier: Modifier = Modifier, navController: NavController) {
    NavigationBar(
        modifier = modifier
    ) {
        var homeIcon by remember { mutableStateOf(true) }
        var bookmarkIcon by remember { mutableStateOf(false) }

        NavigationBarItem(icon = {
            Icon(
                imageVector = Icons.Default.Home, contentDescription = null
            )
        }, label = {
            Text(
                text = stringResource(R.string.bottom_navigation_home)
            )
        }, selected = homeIcon, onClick = {
            navController.navigate(AppScreens.MainPokemonScreen.route)
            homeIcon = true; bookmarkIcon = false
        })
        NavigationBarItem(icon = {
            Icon(
                imageVector = Icons.Default.AccountCircle, contentDescription = null
            )
        }, label = {
            Text(
                text = stringResource(R.string.bottom_navigation_profile)
            )
        }, selected = bookmarkIcon, onClick = {
            navController.navigate(AppScreens.AllPokemonScreen.route)
            bookmarkIcon = true; homeIcon = false
        })
    }
}

// La otra pantalla se diseña con figma y sera una lista de cards todos los pokemon en orden alfabetico y
// que al clickar se abra la imagen en grande. Esto lo haria con modifier.clickable y las imagenes tendran el mismo ancho que los cards