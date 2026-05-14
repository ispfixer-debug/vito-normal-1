package com.vito.client.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val VitoColorScheme = lightColorScheme(
    primary = Color(0xFF2196F3),
    secondary = Color(0xFF4CAF50),
    tertiary = Color(0xFFFF9800),
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black
)

@Composable
fun VitoClientTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = VitoColorScheme) {
        content()
    }
}
