package uk.co.harnick.bulwark.core.settings.domain.model.display

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Colorize
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import uk.co.harnick.bulwark.core.settings.domain.model.Setting

class SeedColorSetting(
    override val value: Color = Color(54, 115, 191)
) : Setting<Color> {
    override val description: String = "The deciding color for Bulwark's theme"
    override val helpLink: String? = null
    override val icon: ImageVector = Icons.Rounded.Colorize
    override val isVisible: Boolean = true
    override val title: String = "Seed Color"
    override val warning: String? = null
}
