package uk.co.harnick.bulwark.core.settings.presentation

import uk.co.harnick.bulwark.core.settings.domain.model.SettingCollection
import uk.co.harnick.bulwark.core.settings.domain.model.display.DisplaySettings
import uk.co.harnick.bulwark.core.settings.domain.model.general.GeneralSettings
import uk.co.harnick.bulwark.core.settings.domain.model.security.SecuritySettings

data class SettingsState(
    val displaySettings: DisplaySettings = DisplaySettings(),
    val encryptionKeyPromptIsVisible: Boolean = false,
    val generalSettings: GeneralSettings = GeneralSettings(),
    val securitySettings: SecuritySettings = SecuritySettings()
) {
    val settingEntries: List<SettingCollection> =
        listOf(displaySettings, generalSettings, securitySettings)
}
