package uk.co.harnick.bulwark.core.settings.domain.usecase

import uk.co.harnick.bulwark.core.settings.domain.repository.SettingsRepo

class SettingsUseCases(settingsRepo: SettingsRepo) {
    val getSettingsAsState: GetSettingsAsState = GetSettingsAsState(settingsRepo)
    val saveDisplaySetting: SaveDisplaySetting = SaveDisplaySetting(settingsRepo)
    val saveGeneralSetting: SaveGeneralSetting = SaveGeneralSetting(settingsRepo)
    val saveSecuritySetting: SaveSecuritySetting = SaveSecuritySetting(settingsRepo)
}
