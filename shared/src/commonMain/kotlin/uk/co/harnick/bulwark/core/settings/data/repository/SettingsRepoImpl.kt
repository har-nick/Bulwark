package uk.co.harnick.bulwark.core.settings.data.repository

import app.cash.sqldelight.Query
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToOneOrNull
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.flow.Flow
import uk.co.harnick.bulwark.DisplaySettingsEntity
import uk.co.harnick.bulwark.GeneralSettingsEntity
import uk.co.harnick.bulwark.LocalStorage
import uk.co.harnick.bulwark.SecuritySettingsEntity
import uk.co.harnick.bulwark.core.settings.domain.repository.SettingsRepo

class SettingsRepoImpl(db: LocalStorage) : SettingsRepo {
    private val displayQueries = db.display_settingsQueries
    private val generalQueries = db.general_settingsQueries
    private val securityQueries = db.security_settingsQueries

    private fun <T : Any> getSetting(
        coroutineContext: CoroutineContext,
        query: Query<T>
    ): Flow<T?> =
        with(coroutineContext) {
            query
                .asFlow()
                .mapToOneOrNull(this)
        }

    override fun resetSettings() {
        displayQueries.drop()
        generalQueries.drop()
        securityQueries.drop()
    }

    override fun getDisplaySettings(coroutineContext: CoroutineContext): Flow<DisplaySettingsEntity?> =
        getSetting(coroutineContext, displayQueries.load())

    override fun saveDisplaySettings(newCollection: DisplaySettingsEntity) =
        displayQueries.save(
            newCollection.material_you_ish,
            newCollection.material_you,
            newCollection.palette,
            newCollection.seed_color,
            newCollection.theme
        )

    override fun getGeneralSettings(coroutineContext: CoroutineContext): Flow<GeneralSettingsEntity?> =
        getSetting(coroutineContext, generalQueries.load())

    override fun saveGeneralSettings(newCollection: GeneralSettingsEntity) =
        generalQueries.save(
            newCollection.language,
            newCollection.default_note_layout,
            newCollection.optimise_images
        )

    override fun getSecuritySettings(coroutineContext: CoroutineContext): Flow<SecuritySettingsEntity?> =
        getSetting(coroutineContext, securityQueries.loadSecuritySettings())

    override fun saveSecuritySettings(newCollection: SecuritySettingsEntity) =
        securityQueries.saveSecuritySettings(
            newCollection.isLocked,
            newCollection.secureFlagEnabled
        )
}
