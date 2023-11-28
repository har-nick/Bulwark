package uk.co.harnick.bulwark.core.settings.domain.repository

import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.flow.Flow
import uk.co.harnick.bulwark.DisplaySettingsEntity
import uk.co.harnick.bulwark.GeneralSettingsEntity
import uk.co.harnick.bulwark.SecuritySettingsEntity

interface SettingsRepo {
    fun resetSettings()

    fun getDisplaySettings(coroutineContext: CoroutineContext): Flow<DisplaySettingsEntity?>
    fun saveDisplaySettings(newCollection: DisplaySettingsEntity)

    fun getGeneralSettings(coroutineContext: CoroutineContext): Flow<GeneralSettingsEntity?>
    fun saveGeneralSettings(newCollection: GeneralSettingsEntity)

    fun getSecuritySettings(coroutineContext: CoroutineContext): Flow<SecuritySettingsEntity?>
    fun saveSecuritySettings(newCollection: SecuritySettingsEntity)
}
