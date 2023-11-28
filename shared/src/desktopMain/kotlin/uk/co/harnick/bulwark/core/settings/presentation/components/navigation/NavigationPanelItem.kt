package uk.co.harnick.bulwark.core.settings.presentation.components.navigation

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import uk.co.harnick.bulwark.core.settings.domain.model.SettingCollection

@Composable
fun SettingCollection.toNavigationPanelItem(
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor by animateColorAsState(
        when (isSelected) {
            true -> MaterialTheme.colorScheme.secondaryContainer
            false -> Color.Transparent
        }
    )
    val foregroundColor by animateColorAsState(
        when (isSelected) {
            true -> MaterialTheme.colorScheme.onSecondaryContainer
            false -> MaterialTheme.colorScheme.onSurfaceVariant
        }
    )

    Row(
        modifier = Modifier
            .pointerHoverIcon(PointerIcon.Hand)
            .clip(MaterialTheme.shapes.extraLarge)
            .clickable { onClick() }
            .widthIn(min = 56.dp)
            .fillMaxWidth()
            .height(56.dp)
            .background(backgroundColor)
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = if (isSelected) activeIcon else inactiveIcon,
            contentDescription = null,
            tint = foregroundColor
        )
        Text(
            text = title,
            modifier = Modifier.padding(start = 8.dp),
            color = foregroundColor,
            overflow = TextOverflow.Visible,
            maxLines = 1,
            style = MaterialTheme.typography.labelLarge
        )
    }
}
