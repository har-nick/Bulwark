package uk.co.harnick.bulwark.core.settings.domain.usecase

import uk.co.harnick.bulwark.core.db.domain.mappers.GeneralSettingsMapper.toGeneralSettingsEntity
import uk.co.harnick.bulwark.core.settings.domain.model.Language
import uk.co.harnick.bulwark.core.settings.domain.model.Setting
import uk.co.harnick.bulwark.core.settings.domain.model.general.DefaultNoteLayoutSetting
import uk.co.harnick.bulwark.core.settings.domain.model.general.GeneralSettings
import uk.co.harnick.bulwark.core.settings.domain.model.general.LanguageSetting
import uk.co.harnick.bulwark.core.settings.domain.model.general.OptimiseImagesSetting
import uk.co.harnick.bulwark.core.settings.domain.repository.SettingsRepo
import uk.co.harnick.bulwark.features.notes.domain.model.NoteLayout

class SaveGeneralSetting(private val settingsRepo: SettingsRepo) {
    operator fun <T : Any> invoke(
        currentSettings: GeneralSettings,
        targetSetting: Setting<T>,
        newValue: Any
    ) {
        val updatedSetting = when (targetSetting) {
            is DefaultNoteLayoutSetting -> DefaultNoteLayoutSetting(newValue as NoteLayout)
            is LanguageSetting -> LanguageSetting(newValue as Language)
            is OptimiseImagesSetting -> OptimiseImagesSetting(newValue as Boolean)
            else -> throw Exception("Passed targetSetting is not a value of GeneralSettings")
        }

        val updatedCollection = when (updatedSetting) {
            is DefaultNoteLayoutSetting -> currentSettings.copy(defaultNoteLayout = updatedSetting)
            is LanguageSetting -> currentSettings.copy(language = updatedSetting)
            is OptimiseImagesSetting -> currentSettings.copy(optimiseImages = updatedSetting)
            else -> throw Exception("Passed updatedSetting is not a value of GeneralSettings")
        }.toGeneralSettingsEntity()

        settingsRepo.saveGeneralSettings(updatedCollection)
    }
}
