package com.example.garcialovilloalberto_practica3.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.garcialovilloalberto_practica3.R
import com.example.garcialovilloalberto_practica3.components.FavoritePokemonGrid
import com.example.garcialovilloalberto_practica3.components.MainPokemonCarousel
import com.example.garcialovilloalberto_practica3.components.SearchBar

@Composable
fun MainPokemonScreen(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier.verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(32.dp))

        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(navController = navController, title = R.string.pokemon) {
            MainPokemonCarousel()
        }
        HomeSection(navController = navController, title = R.string.favorite_collections) {
            FavoritePokemonGrid(navController = navController)
        }
        Spacer(Modifier.height(16.dp))
    }
}


@Composable
fun HomeSection(
    navController: NavController,
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

