package uk.co.harnick.bulwark.common.navigation.domain

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Archive
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.StickyNote2
import androidx.compose.material.icons.rounded.Archive
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.StickyNote2
import androidx.compose.ui.graphics.vector.ImageVector
import cafe.adriel.voyager.core.screen.Screen
import uk.co.harnick.bulwark.core.settings.presentation.SettingsScreen
import uk.co.harnick.bulwark.features.notes.presentation.NoteScreen

sealed class Screens<T : Screen>(
    val label: String,
    val activeIcon: ImageVector,
    val inactiveIcon: ImageVector,
    val badgeCount: Int? = null,
    val screenProvider: () -> T
) {
    data object ArchivedNotes : Screens<NoteScreen>(
        label = "Archived",
        activeIcon = Icons.Rounded.Archive,
        inactiveIcon = Icons.Outlined.Archive,
        screenProvider = { NoteScreen("Archived") }
    )

    data object DeletedNotes : Screens<NoteScreen>(
        label = "Deleted",
        activeIcon = Icons.Rounded.Delete,
        inactiveIcon = Icons.Outlined.Delete,
        screenProvider = { NoteScreen("Deleted") }
    )

    data object OpenNotes : Screens<NoteScreen>(
        label = "Notes",
        activeIcon = Icons.Rounded.StickyNote2,
        inactiveIcon = Icons.Outlined.StickyNote2,
        screenProvider = { NoteScreen("Notes") }
    )

    data object Settings : Screens<SettingsScreen>(
        label = "Settings",
        activeIcon = Icons.Rounded.Settings,
        inactiveIcon = Icons.Outlined.Settings,
        screenProvider = { SettingsScreen("Settings") }
    )
}
