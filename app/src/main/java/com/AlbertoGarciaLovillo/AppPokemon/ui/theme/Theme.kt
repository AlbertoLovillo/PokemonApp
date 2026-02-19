package com.AlbertoGarciaLovillo.AppPokemon.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color


@Immutable
data class AppColorScheme(
    // Colores fuertes
    val verdePlanta: Color,
    val azulAgua: Color,
    val rojoFuego: Color,

    // Fondos
    val fondoPlanta: Color,
    val fondoAgua: Color,
    val fondoFuego: Color,

    // Ayuda
    val blanco: Color,
    val blancoOscuro: Color,
    val negro: Color,
    val negroClaro: Color
)


val unspecified_scheme = AppColorScheme(
    Color.Unspecified,
    Color.Unspecified,
    Color.Unspecified,
    Color.Unspecified,
    Color.Unspecified,
    Color.Unspecified, Color.Unspecified,
    Color.Unspecified, Color.Unspecified,
    Color.Unspecified
)

val LocalAppColors = staticCompositionLocalOf {
    unspecified_scheme
}

@Composable
fun PokemonTheme(
    content: @Composable () -> Unit
) {
    val appColors = AppColorScheme(
        verdePlanta = verdePlanta,
        azulAgua = azulAgua,
        rojoFuego = rojoFuego,

        fondoPlanta = fondoPlanta,
        fondoAgua = fondoAgua,
        fondoFuego = fondoFuego,

        blanco = blanco,
        blancoOscuro = blancoOscuro,
        negro = negro,
        negroClaro = negroClaro
    )

    CompositionLocalProvider(
        LocalAppColors provides appColors
    ) {
        MaterialTheme {
            content()
        }
    }
}







//@Immutable
//data class ColorFamily(
//    val color: Color,
//    val onColor: Color,
//    val colorContainer: Color,
//    val onColorContainer: Color
//)
//
//val unspecified_scheme = ColorFamily(
//    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
//)
//
//@Composable
//fun AppTheme(
//    darkTheme: Boolean = isSystemInDarkTheme(),
//    // Dynamic color is available on Android 12+
//    dynamicColor: Boolean = true,
//    content: @Composable() () -> Unit
//) {
//    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }
//
//        darkTheme -> darkScheme
//        else -> lightScheme
//    }
//
//    MaterialTheme(
//        colorScheme = colorScheme,
//        typography = AppTypography,
//        content = content
//    )
//}
//
//
//
//
//
////private val DarkColorScheme = darkColorScheme(
////    primary = Purple80,
////    secondary = PurpleGrey80,
////    tertiary = Pink80
////)
////
////private val LightColorScheme = lightColorScheme(
////    primary = Purple40,
////    secondary = PurpleGrey40,
////    tertiary = Pink40
////
////    /* Other default colors to override
////    background = Color(0xFFFFFBFE),
////    surface = Color(0xFFFFFBFE),
////    onPrimary = Color.White,
////    onSecondary = Color.White,
////    onTertiary = Color.White,
////    onBackground = Color(0xFF1C1B1F),
////    onSurface = Color(0xFF1C1B1F),
////    */
////)
////
//
//@Composable
//fun GarciaLovilloAlberto_Practica3Theme(
//    darkTheme: Boolean = isSystemInDarkTheme(),
//    // Dynamic color is available on Android 12+
//    dynamicColor: Boolean = true,
//    content: @Composable () -> Unit
//) {
//    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }
//
//        darkTheme -> mediumContrastDarkColorScheme
//        else -> mediumContrastLightColorScheme
//    }
//
//    MaterialTheme(
//        colorScheme = colorScheme,
//        typography = AppTypography,
//        content = content
//    )
//}