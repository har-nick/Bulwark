package uk.co.harnick.bulwark.common.navigation.presentation.components.expandablenavrail

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MenuOpen
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.unit.dp

@Composable
fun ExpandableNavRailToggle(railIsExpanded: Boolean, onClick: () -> Unit) {
    val iconRotation by animateFloatAsState(
        if (railIsExpanded) 0F else 180F
    )

    IconButton(
        onClick,
        modifier = Modifier
            .pointerHoverIcon(PointerIcon.Hand)
            .size(56.dp)
    ) {
        Icon(
            imageVector = Icons.Rounded.MenuOpen,
            contentDescription = null,
            modifier = Modifier.rotate(iconRotation),
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}