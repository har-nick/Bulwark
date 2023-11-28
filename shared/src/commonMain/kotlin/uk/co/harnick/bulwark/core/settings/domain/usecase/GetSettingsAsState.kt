package uk.co.harnick.bulwark.core.settings.domain.usecase

import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import uk.co.harnick.bulwark.core.db.domain.mappers.DisplaySettingsMapper.toDisplaySettings
import uk.co.harnick.bulwark.core.db.domain.mappers.GeneralSettingsMapper.toGeneralSettings
import uk.co.harnick.bulwark.core.db.domain.mappers.SecuritySettingsMapper.toSecuritySettings
import uk.co.harnick.bulwark.core.settings.domain.model.display.DisplaySettings
import uk.co.harnick.bulwark.core.settings.domain.model.general.GeneralSettings
import uk.co.harnick.bulwark.core.settings.domain.model.security.SecuritySettings
import uk.co.harnick.bulwark.core.settings.domain.repository.SettingsRepo
import uk.co.harnick.bulwark.core.settings.presentation.SettingsState

class GetSettingsAsState(private val settingsRepo: SettingsRepo) {
    operator fun invoke(coroutineContext: CoroutineContext): Flow<SettingsState> {
        val generalSettingsFlow = settingsRepo.getGeneralSettings(coroutineContext)
            .map { it?.toGeneralSettings() ?: GeneralSettings() }

        val displaySettingsFlow = settingsRepo.getDisplaySettings(coroutineContext)
            .map { it?.toDisplaySettings() ?: DisplaySettings() }

        val securitySettingsFlow = settingsRepo.getSecuritySettings(coroutineContext)
            .distinctUntilChanged()
            .map { it?.toSecuritySettings() ?: SecuritySettings() }

        return combine(
            displaySettingsFlow,
            generalSettingsFlow,
            securitySettingsFlow
        ) { displaySettings, generalSettings, securitySettings ->
            SettingsState(
                displaySettings = displaySettings,
                generalSettings = generalSettings,
                securitySettings = securitySettings
            )
        }
    }
}