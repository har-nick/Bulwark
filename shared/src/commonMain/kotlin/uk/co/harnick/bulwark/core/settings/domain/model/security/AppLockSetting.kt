package uk.co.harnick.bulwark.core.settings.domain.model.security

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.ui.graphics.vector.ImageVector


import uk.co.harnick.bulwark.core.settings.domain.model.Setting
import uk.co.harnick.bulwark.core.settings.domain.model.security.SecurityGateValue.None

data class AppLockSetting(
    override val value: SecurityGateValue = None
) : Setting<SecurityGateValue> {
    override val description: String = "Lock Bulwark behind a prompt, such as a password or PIN."
    // TODO: Add help link
    override val helpLink: String = ""
    override val icon: ImageVector = Icons.Rounded.Lock
    override val isVisible: Boolean = true
    override val title: String = "App Lock"
    override val warning: String? = null
}
