package uk.co.harnick.bulwark.core.settings.domain.model.security

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.rounded.Security
import androidx.compose.ui.graphics.vector.ImageVector
import uk.co.harnick.bulwark.core.settings.domain.model.Setting
import uk.co.harnick.bulwark.core.settings.domain.model.SettingCollection

data class SecuritySettings(
    val isLocked: AppLockSetting = AppLockSetting(),
    val secureFlagEnabled: SecureFlagSetting = SecureFlagSetting()
) : SettingCollection {
    override val activeIcon: ImageVector = Icons.Filled.Security
    override val inactiveIcon: ImageVector = Icons.Rounded.Security
    override val entries: List<Setting<out Any?>> = listOf(isLocked, secureFlagEnabled)
    override val title: String = "Security"
}
