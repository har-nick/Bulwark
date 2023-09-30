package uk.co.harnick.composemptemplate.common.navigation.presentation.components.drawer

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import uk.co.harnick.composemptemplate.common.navigation.domain.ScreenParams
import uk.co.harnick.composemptemplate.common.navigation.domain.Screens

@Composable
fun <T : Screen, S : ScreenParams> Screens<T, S>.toNavDrawerItem(params: S) {
    val navigator = LocalNavigator.currentOrThrow

    val isSelected = this.label == navigator.lastItem.key
    val imageVector = if (isSelected) activeIcon else inactiveIcon

    NavigationDrawerItem(
        label = { Text(label) },
        selected = isSelected,
        onClick = { navigator.replaceAll(screenProvider(params)) },
        icon = { Icon(imageVector = imageVector, contentDescription = null) }
    )
}