package uk.co.harnick.bulwark.core.window.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.CropSquare
import androidx.compose.material.icons.rounded.Minimize
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ApplicationScope
import androidx.compose.ui.window.FrameWindowScope
import androidx.compose.ui.window.WindowPlacement.Floating
import androidx.compose.ui.window.WindowPlacement.Fullscreen
import androidx.compose.ui.window.WindowPlacement.Maximized

@Composable
fun FrameWindowScope.TaskbarActions(
    applicationScope: ApplicationScope,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        IconButton(
            onClick = { window.isMinimized = true },
            modifier = Modifier.pointerHoverIcon(PointerIcon.Hand),
            content = { Icon(imageVector = Icons.Rounded.Minimize, contentDescription = null) }
        )

        IconButton(
            onClick = {
                window.placement = when (window.placement) {
                    Floating -> Maximized
                    Maximized -> Floating
                    Fullscreen -> Maximized
                }
            },
            modifier = Modifier.pointerHoverIcon(PointerIcon.Hand),
            content = { Icon(imageVector = Icons.Rounded.CropSquare, contentDescription = null) }
        )

        IconButton(
            onClick = { applicationScope.exitApplication() },
            modifier = Modifier.pointerHoverIcon(PointerIcon.Hand),
            content = { Icon(imageVector = Icons.Rounded.Close, contentDescription = null) }
        )
    }
}
