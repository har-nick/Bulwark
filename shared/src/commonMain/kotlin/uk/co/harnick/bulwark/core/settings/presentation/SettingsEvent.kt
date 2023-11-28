package uk.co.harnick.bulwark.core.settings.presentation

import uk.co.harnick.bulwark.core.settings.domain.model.Setting
import uk.co.harnick.bulwark.core.settings.domain.model.SettingCollection

sealed interface SettingsEvent {
    data object ResetSettings : SettingsEvent

    data class UpdateSetting<T : Any>(
        val targetCollection: SettingCollection,
        val targetSetting: Setting<T>,
        val newValue: T
    ) : SettingsEvent
}
