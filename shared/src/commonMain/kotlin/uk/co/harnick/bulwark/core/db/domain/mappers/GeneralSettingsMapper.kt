package uk.co.harnick.bulwark.core.db.domain.mappers

import uk.co.harnick.bulwark.GeneralSettingsEntity
import uk.co.harnick.bulwark.core.settings.domain.model.general.DefaultNoteLayoutSetting
import uk.co.harnick.bulwark.core.settings.domain.model.general.GeneralSettings
import uk.co.harnick.bulwark.core.settings.domain.model.general.LanguageSetting
import uk.co.harnick.bulwark.core.settings.domain.model.general.OptimiseImagesSetting

object GeneralSettingsMapper {
    fun GeneralSettings.toGeneralSettingsEntity(): GeneralSettingsEntity =
        GeneralSettingsEntity(id = 0, language, defaultNoteLayout, optimiseImages)

    fun GeneralSettingsEntity.toGeneralSettings(): GeneralSettings =
        GeneralSettings(
            default_note_layout ?: DefaultNoteLayoutSetting(),
            language ?: LanguageSetting(),
            optimise_images ?: OptimiseImagesSetting()
        )
}
