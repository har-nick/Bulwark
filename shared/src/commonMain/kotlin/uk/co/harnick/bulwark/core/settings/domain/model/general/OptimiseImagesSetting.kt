package uk.co.harnick.bulwark.core.settings.domain.model.general

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Filter
import androidx.compose.ui.graphics.vector.ImageVector


import uk.co.harnick.bulwark.core.settings.domain.model.Setting

class OptimiseImagesSetting(
    override val value: Boolean = true
) : Setting<Boolean> {
    override val description: String? = null
    override val helpLink: String? = null
    override val icon: ImageVector = Icons.Rounded.Filter
    override val isVisible: Boolean = true
    override val title: String = "Optimise Images"
    override val warning: String = "This may reduce image quality!"
}
