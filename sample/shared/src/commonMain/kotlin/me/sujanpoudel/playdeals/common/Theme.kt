package me.sujanpoudel.playdeals.common

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
  background = Color.Black,
  onBackground = Color.White,
  primary = SampleGreen,
  primaryVariant = SampleGreenDark,
  onPrimary = Color.White,
  secondary = SampleGreen,
  onSecondary = Color.White,
  error = Red200
)

private val LightColorPalette = lightColors(
  background = Color.White,
  onBackground = Color.Black,
  primary = SampleGreen,
  primaryVariant = SampleGreenDark,
  onPrimary = Color.White,
  secondary = SampleGreen,
  secondaryVariant = SampleGreenDark,
  onSecondary = Color.White,
  error = Red800
)

@Composable
fun SampleTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable() () -> Unit
) {
  val colors = if (darkTheme) {
    DarkColorPalette
  } else {
    LightColorPalette
  }

  MaterialTheme(
    colors = colors,
    content = content
  )
}
