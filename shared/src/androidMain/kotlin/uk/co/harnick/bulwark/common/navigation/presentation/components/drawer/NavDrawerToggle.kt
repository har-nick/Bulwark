package uk.co.harnick.bulwark.common.navigation.presentation.components.drawer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable

@Composable
fun NavDrawerToggle() {
    IconButton(
        onClick = { NavDrawer.open() }
    ) {
        Icon(
            imageVector = Icons.Rounded.Menu,
            contentDescription = "Open Navigation Drawer"
        )
    }
}