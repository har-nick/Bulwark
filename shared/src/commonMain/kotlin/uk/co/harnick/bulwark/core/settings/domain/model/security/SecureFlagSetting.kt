package uk.co.harnick.bulwark.core.settings.domain.model.security

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Preview
import androidx.compose.ui.graphics.vector.ImageVector


import uk.co.harnick.bulwark.core.settings.domain.model.Setting
import uk.co.harnick.bulwark.core.util.BuildIdentifiers.Android
import uk.co.harnick.bulwark.core.util.bulwarkBuild

class SecureFlagSetting(
    override val value: Boolean = (bulwarkBuild == Android)
) : Setting<Boolean> {
    override val description: String? = null
    // TODO: Add screen-recording warning
    override val helpLink: String = ""
    override val icon: ImageVector = Icons.Rounded.Preview
    override val isVisible: Boolean = (bulwarkBuild == Android)
    override val title: String = "Allow screenshots"
    override val warning: String? = null
}
