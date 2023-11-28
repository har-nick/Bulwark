package uk.co.harnick.bulwark.core.ui.presentation.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import uk.co.harnick.bulwark.core.util.isDark

@Composable
fun ColorCircle(
    color: Color,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = {}
) {
    Surface(
        modifier = modifier,
        shape = CircleShape,
        color = color,
        contentColor = if (color.isDark()) Color.White else Color.DarkGray,
        content = content
    )
}