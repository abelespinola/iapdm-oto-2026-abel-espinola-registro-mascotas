package com.abelespinola.registromascotas.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = AutumnPrimary,
    onPrimary = Color.White,
    background = LightBg_Autumn,
    surface = LightGlassSurface,
    surfaceVariant = LightInputGlass,
    onSurfaceVariant = AutumnDarkText
)

private val DarkColorScheme = darkColorScheme(
    primary = AutumnPrimary,
    onPrimary = Color.White,
    background = DarkBg_Autumn,
    surface = DarkGlassSurface,
    surfaceVariant = DarkInputGlass,
    onSurfaceVariant = Color.White
)

@Composable
fun MascotasTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // Toma el Typography del archivo Type.kt
        content = content
    )
}