package uk.co.harnick.bulwark.core.db.domain.mappers

import uk.co.harnick.bulwark.SecuritySettingsEntity
import uk.co.harnick.bulwark.core.settings.domain.model.security.AppLockSetting
import uk.co.harnick.bulwark.core.settings.domain.model.security.SecureFlagSetting
import uk.co.harnick.bulwark.core.settings.domain.model.security.SecuritySettings

object SecuritySettingsMapper {
    fun SecuritySettings.toSecuritySettingsEntity(): SecuritySettingsEntity =
        SecuritySettingsEntity(id = 0, isLocked, secureFlagEnabled)

    fun SecuritySettingsEntity.toSecuritySettings(): SecuritySettings =
        SecuritySettings(isLocked ?: AppLockSetting(), secureFlagEnabled ?: SecureFlagSetting())
}
