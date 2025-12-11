package com.example.garcialovilloalberto_practica3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.example.garcialovilloalberto_practica3.screens.MainPokemonApp

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val windowSizeClass = calculateWindowSizeClass(this)
            MainPokemonApp(windowSizeClass)
        }
    }
}



//@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
//@Composable
//fun PortraitAppPreview() {
//    MyPokemonAppPortrait()
//}
//
//@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
//@Composable
//fun LandscapeAppreview() {
//    MyPokemonAppLandscape()
//}

