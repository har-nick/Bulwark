package uk.co.harnick.bulwark.core.settings.domain.model

import androidx.compose.ui.graphics.vector.ImageVector

interface SettingCollection {
    val entries: List<Setting<out Any?>>
    val activeIcon: ImageVector
    val inactiveIcon: ImageVector
    val title: String
}
