package uk.co.harnick.bulwark.common.navigation.presentation.components.rail

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import uk.co.harnick.bulwark.common.navigation.domain.Screens

@Composable
fun <T : Screen> Screens<T>.toNavRailItem(modifier: Modifier = Modifier) {
    val navigator = LocalNavigator.currentOrThrow

    val isSelected by mutableStateOf(label == navigator.lastItem.key)
    val imageVector by derivedStateOf { if (isSelected) activeIcon else inactiveIcon }

    NavigationRailItem(
        selected = isSelected,
        onClick = { navigator.replaceAll(screenProvider()) },
        modifier = modifier.then(Modifier.pointerHoverIcon(PointerIcon.Hand)),
        icon = { Icon(imageVector = imageVector, contentDescription = null) },
        label = { Text(label) },
        alwaysShowLabel = false
    )
}
