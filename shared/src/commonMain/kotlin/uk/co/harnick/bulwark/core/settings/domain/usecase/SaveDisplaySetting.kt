package uk.co.harnick.bulwark.core.settings.domain.usecase

import androidx.compose.ui.graphics.Color
import uk.co.harnick.bulwark.core.db.domain.mappers.DisplaySettingsMapper.toDisplaySettingsEntity
import uk.co.harnick.bulwark.core.settings.domain.model.Palette
import uk.co.harnick.bulwark.core.settings.domain.model.Setting
import uk.co.harnick.bulwark.core.settings.domain.model.Theme
import uk.co.harnick.bulwark.core.settings.domain.model.display.DisplaySettings
import uk.co.harnick.bulwark.core.settings.domain.model.display.MaterialYouIshSetting
import uk.co.harnick.bulwark.core.settings.domain.model.display.MaterialYouSetting
import uk.co.harnick.bulwark.core.settings.domain.model.display.PaletteSetting
import uk.co.harnick.bulwark.core.settings.domain.model.display.SeedColorSetting
import uk.co.harnick.bulwark.core.settings.domain.model.display.ThemeSetting
import uk.co.harnick.bulwark.core.settings.domain.repository.SettingsRepo

class SaveDisplaySetting(private val settingsRepo: SettingsRepo) {
    operator fun <T : Any> invoke(
        currentSettings: DisplaySettings,
        targetSetting: Setting<T>,
        newValue: Any
    ) {
        val updatedSetting = when (targetSetting) {
            is MaterialYouIshSetting -> MaterialYouIshSetting(newValue as Boolean)
            is MaterialYouSetting -> MaterialYouSetting(newValue as Boolean)
            is PaletteSetting -> PaletteSetting(newValue as Palette)
            is SeedColorSetting -> SeedColorSetting(newValue as Color)
            is ThemeSetting -> ThemeSetting(newValue as Theme)
            else -> throw Exception("Passed targetSetting is not a value of DisplaySettings")
        }

        val updatedCollection = when (updatedSetting) {
            is MaterialYouIshSetting -> currentSettings.copy(materialYouIsh = updatedSetting)
            is MaterialYouSetting -> currentSettings.copy(materialYou = updatedSetting)
            is PaletteSetting -> currentSettings.copy(palette = updatedSetting)
            is SeedColorSetting -> currentSettings.copy(seedColor = updatedSetting)
            is ThemeSetting -> currentSettings.copy(theme = updatedSetting)
            else -> throw Exception("Passed updatedSetting is not a value of DisplaySettings")
        }.toDisplaySettingsEntity()

        settingsRepo.saveDisplaySettings(updatedCollection)
    }
}
