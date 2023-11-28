package uk.co.harnick.bulwark.core.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import kotlin.math.max
import kotlin.math.min

fun calculateContrastRatio(foreground: Color, background: Color): Float {
    val foregroundLuminance = foreground.luminance() + 0.05F
    val backgroundLuminance = background.luminance() + 0.05F

    return max(foregroundLuminance, backgroundLuminance) /
            min(foregroundLuminance, backgroundLuminance)
}
