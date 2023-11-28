package uk.co.harnick.bulwark.core.settings.domain.model.display

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FormatPaint
import androidx.compose.ui.graphics.vector.ImageVector


import uk.co.harnick.bulwark.core.settings.domain.model.Setting
import uk.co.harnick.bulwark.core.settings.domain.model.Theme
import uk.co.harnick.bulwark.core.settings.domain.model.Theme.Auto

class ThemeSetting(
    override val value: Theme = Auto
) : Setting<Theme> {
    override val description: String? = null
    override val helpLink: String? = null
    override val icon: ImageVector = Icons.Rounded.FormatPaint
    override val isVisible: Boolean = true
    override val title: String = "Theme"
    override val warning: String? = null
}
