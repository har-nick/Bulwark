package uk.co.harnick.bulwark.common.navigation.presentation.components.drawer

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import uk.co.harnick.bulwark.common.navigation.domain.Screens

@Composable
fun <T : Screen> Screens<T>.ToNavDrawerItem(modifier: Modifier = Modifier) {
    val navigator = LocalNavigator.currentOrThrow

    val isSelected = label == navigator.lastItem.key
    val imageVector = if (isSelected) activeIcon else inactiveIcon

    NavigationDrawerItem(
        label = { Text(label) },
        selected = isSelected,
        onClick = { navigator.replaceAll(screenProvider()) },
        modifier = modifier.then(Modifier.pointerHoverIcon(PointerIcon.Hand)),
        icon = { Icon(imageVector = imageVector, contentDescription = null) }
    )
}
