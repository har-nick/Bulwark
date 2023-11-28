package uk.co.harnick.bulwark.core.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance

@Composable
fun Color.isDark(): Boolean = luminance() <= 0.6F