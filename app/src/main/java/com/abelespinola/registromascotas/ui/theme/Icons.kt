package com.abelespinola.registromascotas.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

// ESTO ES PARA INTRODUCIR UN ICONO DE HUESO EN EL CAMPO RAZA

val IconoHuesito: ImageVector
    get() = ImageVector.Builder(
        name = "Huesito",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).apply {
        path(fill = SolidColor(Color.Black)) {
            moveTo(20f, 13.18f)
            curveTo(20.6f, 13.56f, 21f, 14.23f, 21f, 15f)
            curveTo(21f, 16.65f, 19.65f, 18f, 18f, 18f)
            curveTo(16.94f, 18f, 15.97f, 17.43f, 15.43f, 16.5f)
            lineTo(8.57f, 16.5f)
            curveTo(8.03f, 17.43f, 7.06f, 18f, 6f, 18f)
            curveTo(4.35f, 18f, 3f, 16.65f, 3f, 15f)
            curveTo(3f, 14.23f, 3.4f, 13.56f, 4f, 13.18f)
            lineTo(4f, 10.82f)
            curveTo(3.4f, 10.44f, 3f, 9.77f, 3f, 9f)
            curveTo(3f, 7.35f, 4.35f, 6f, 6f, 6f)
            curveTo(7.06f, 6f, 8.03f, 6.57f, 8.57f, 7.5f)
            lineTo(15.43f, 7.5f)
            curveTo(15.97f, 6.57f, 16.94f, 6f, 18f, 6f)
            curveTo(19.65f, 6f, 21f, 7.35f, 21f, 9f)
            curveTo(21f, 9.77f, 20.6f, 10.44f, 20f, 10.82f)
            lineTo(20f, 13.18f)
            close()
        }
    }.build()