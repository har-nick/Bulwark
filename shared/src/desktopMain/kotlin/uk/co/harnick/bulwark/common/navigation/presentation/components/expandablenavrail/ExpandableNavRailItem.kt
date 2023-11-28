package uk.co.harnick.bulwark.common.navigation.presentation.components.expandablenavrail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement.Start
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Icon
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
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import uk.co.harnick.bulwark.common.navigation.domain.Screens

@Composable
fun <T : Screen> Screens<T>.toExpandableNavRailItem(
    railIsExpanded: Boolean,
    modifier: Modifier = Modifier
) {
    val navigator = LocalNavigator.currentOrThrow

    val isSelected = label == navigator.lastItem.key
    val imageVector = if (isSelected) activeIcon else inactiveIcon
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
            .clickable { navigator.replaceAll(screenProvider()) }
            .widthIn(min = 56.dp)
            .fillMaxWidth()
            .height(56.dp)
            .background(backgroundColor)
            .padding(horizontal = 16.dp)
            .then(modifier),
        horizontalArrangement = Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            tint = foregroundColor
        )
        AnimatedVisibility(
            railIsExpanded,
            enter = fadeIn(tween(delayMillis = 200)),
            exit = fadeOut(tween(durationMillis = 0)),
            content = {
                Text(
                    text = label,
                    modifier = Modifier.padding(start = 8.dp),
                    color = foregroundColor,
                    overflow = TextOverflow.Visible,
                    maxLines = 1,
                    style = MaterialTheme.typography.labelLarge
                )
            }
        )
    }
}