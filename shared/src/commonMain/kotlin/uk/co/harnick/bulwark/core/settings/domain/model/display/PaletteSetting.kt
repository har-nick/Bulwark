package uk.co.harnick.bulwark.core.settings.domain.model.display

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Style
import androidx.compose.ui.graphics.vector.ImageVector


import uk.co.harnick.bulwark.core.settings.domain.model.Palette
import uk.co.harnick.bulwark.core.settings.domain.model.Palette.Content
import uk.co.harnick.bulwark.core.settings.domain.model.Setting

class PaletteSetting(
    override val value: Palette = Content
) : Setting<Palette> {
    override val description: String = "Customise further with theme palettes"
    override val helpLink: String? = null
    override val icon: ImageVector = Icons.Rounded.Style
    override val isVisible: Boolean = true
    override val title: String = "Palette"
    override val warning: String? = null
}
