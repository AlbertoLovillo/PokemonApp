package com.example.garcialovilloalberto_practica3.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.DensitySmall
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.garcialovilloalberto_practica3.R
import com.example.garcialovilloalberto_practica3.navigation.Routes
import com.example.garcialovilloalberto_practica3.ui.theme.blancoOscuro
import com.example.garcialovilloalberto_practica3.ui.theme.negroClaro

/**
 * Barra de navegación que permite moverse entre las pantallas de la aplicación.
 *
 * Utiliza [NavigationBar] y muestra elementos de navegación para navegar entre pantallas.
 * El estado de selección se basa en la ruta actual del [backStack].
 *
 * @param backStack Pila de navegación que mantiene el historial de pantallas.
 * Se utiliza para determinar la ruta actual y para navegar a nuevas rutas.
 * @param modifier Modificador opcional para personalizar el layout de la barra de navegación.
 *
 */
@Composable
fun PokemonNavigationBar(
    backStack: NavBackStack<NavKey>,
    modifier: Modifier = Modifier
) {
    val currentRoute = backStack.lastOrNull()

    NavigationBar(
        containerColor = negroClaro,
        contentColor = blancoOscuro,
        modifier = modifier
    ) {
        if (currentRoute != Routes.MainPokemonScreen) {
            NavigationBarItem(
                selected = false,
                icon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIosNew,
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = stringResource(R.string.bottom_navigation_return)
                    )
                },
                onClick = { backStack.removeLastOrNull() }
            )
        }

        NavigationBarItem(
            selected = (currentRoute == Routes.MainPokemonScreen),
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = stringResource(R.string.bottom_navigation_home)
                )
            },
            onClick = { backStack.add(Routes.MainPokemonScreen) }
        )

        NavigationBarItem(
            selected = (currentRoute == Routes.AllPokemonScreen),
            icon = {
                Icon(
                    imageVector = Icons.Default.DensitySmall,
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = stringResource(R.string.bottom_navigation_all)
                )
            },
            onClick = { backStack.add(Routes.AllPokemonScreen) }
        )
    }
}
