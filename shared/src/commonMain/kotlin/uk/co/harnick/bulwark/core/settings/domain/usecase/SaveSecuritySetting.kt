package uk.co.harnick.bulwark.core.settings.domain.usecase

import uk.co.harnick.bulwark.core.db.domain.mappers.SecuritySettingsMapper.toSecuritySettingsEntity
import uk.co.harnick.bulwark.core.settings.domain.model.Setting
import uk.co.harnick.bulwark.core.settings.domain.model.security.AppLockSetting
import uk.co.harnick.bulwark.core.settings.domain.model.security.SecureFlagSetting
import uk.co.harnick.bulwark.core.settings.domain.model.security.SecurityGateValue
import uk.co.harnick.bulwark.core.settings.domain.model.security.SecuritySettings
import uk.co.harnick.bulwark.core.settings.domain.repository.SettingsRepo

class SaveSecuritySetting(private val settingsRepo: SettingsRepo) {
    operator fun <T : Any> invoke(
        currentSettings: SecuritySettings,
        targetSetting: Setting<T>,
        newValue: Any
    ) {
        val updatedSetting = when (targetSetting) {
            is AppLockSetting -> AppLockSetting(newValue as SecurityGateValue)
            is SecureFlagSetting -> SecureFlagSetting(newValue as Boolean)
            else -> throw Exception("Passed targetSetting is not a value of SecuritySettings")
        }

        val updatedCollection = when (updatedSetting) {
            is AppLockSetting -> currentSettings.copy(isLocked = updatedSetting)
            is SecureFlagSetting -> currentSettings.copy(secureFlagEnabled = updatedSetting)
            else -> throw Exception("Passed updatedSetting is not a value of SecuritySettings")
        }.toSecuritySettingsEntity()

        settingsRepo.saveSecuritySettings(updatedCollection)
    }
}
