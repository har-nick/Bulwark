package uk.co.harnick.bulwark.common.navigation.domain

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Info
import androidx.compose.ui.graphics.vector.ImageVector
import cafe.adriel.voyager.core.screen.Screen
import uk.co.harnick.bulwark.features.example.domain.NotesParams
import uk.co.harnick.bulwark.features.example.presentation.NotesScreen

sealed class Screens<T : Screen, S : ScreenParams>(
    val label: String,
    val activeIcon: ImageVector,
    val inactiveIcon: ImageVector,
    val badgeCount: Int? = null,
    val screenProvider: (S) -> T
) {
    data object OpenNotes : Screens<NotesScreen, NotesParams>(
        label = "Screen 1",
        activeIcon = Icons.Rounded.Home,
        inactiveIcon = Icons.Outlined.Home,
        screenProvider = { params: NotesParams -> NotesScreen("Screen 1", params) }
    )

    data object Screen2 : Screens<NotesScreen, NotesParams>(
        label = "Screen 2",
        activeIcon = Icons.Rounded.Info,
        inactiveIcon = Icons.Outlined.Info,
        screenProvider = { params: NotesParams -> NotesScreen("Screen 2", params) }
    )
}
