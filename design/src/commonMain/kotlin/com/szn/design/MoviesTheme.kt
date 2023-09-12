package com.szn.design

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val DarkColorPalette = darkColorScheme(
    background = Color.Black,
    onBackground = Color.White,
    primary = Color(4, 7, 34),
    onPrimary = Color.Blue,
    onPrimaryContainer = Color.White,
    secondary = Color.White,
    surface = Color(0xFFCF6679),
    onSecondary = Color.LightGray,
    error = Color(0xFF85041C),
    onError = Color.LightGray
)

private val LightColorPalette = lightColorScheme(
    background = Color.White,
    onBackground = Color.Black,
    primary = Color(4, 7, 34),
    onPrimary = Color.Blue,
    onPrimaryContainer = Color.White,
    secondary = Color.White,
    surface = Color.Black,
    onSecondary = Color.LightGray,
    error = Color(0xFFA51E37),
    onError = Color.LightGray
)

@Composable
fun MoviesTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    println("Theme: $darkTheme")

    MaterialTheme(
        colorScheme = colors,
//        shapes = Shapes,
        content = content,
//        typography = Typography
    )
}
