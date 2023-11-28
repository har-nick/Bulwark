package uk.co.harnick.bulwark.core.settings.domain.model.display

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Palette
import androidx.compose.ui.graphics.vector.ImageVector


import uk.co.harnick.bulwark.core.settings.domain.model.Setting

actual class MaterialYouIshSetting actual constructor(
    override val value: Boolean
) : Setting<Boolean> {
    override val description: String? = null
    override val helpLink: String? = null
    override val icon: ImageVector = Icons.Rounded.Palette
    override val isVisible: Boolean = false
    override val title: String = "Material You-Ish"
    override val warning: String? = null
}
