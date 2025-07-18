package io.lb.presentation.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = PrimaryRed,
    onPrimary = Color.White,
    secondary = PrimaryBlue,
    onSecondary = Color.White,
    tertiary = Color.White,
    onTertiary = PrimaryRed,
    onPrimaryContainer = DarkerBlue,
    onSecondaryContainer = DarkerRed,
    onTertiaryContainer = GrayBlue
)

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryRedDark,
    onPrimary = Color.White,
    secondary = PrimaryBlueDark,
    onSecondary = Color.White,
    tertiary = Color.Black,
    onTertiary = PrimaryRed,
    onPrimaryContainer = DarkerBlueDark,
    onSecondaryContainer = DarkerRedDark,
    onTertiaryContainer = GrayBlueDark
)

@Composable
fun AstorMemoryChallengeTheme(
    darkTheme: Boolean,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val view = LocalView.current
    SideEffect {
        val window = (view.context as Activity).window
        window.statusBarColor = if (darkTheme) DarkerRedDark.toArgb() else DarkerRed.toArgb()
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
