package uk.co.harnick.bulwark.core.db.domain.mappers

import uk.co.harnick.bulwark.DisplaySettingsEntity
import uk.co.harnick.bulwark.core.settings.domain.model.display.DisplaySettings
import uk.co.harnick.bulwark.core.settings.domain.model.display.MaterialYouIshSetting
import uk.co.harnick.bulwark.core.settings.domain.model.display.MaterialYouSetting
import uk.co.harnick.bulwark.core.settings.domain.model.display.PaletteSetting
import uk.co.harnick.bulwark.core.settings.domain.model.display.SeedColorSetting
import uk.co.harnick.bulwark.core.settings.domain.model.display.ThemeSetting

object DisplaySettingsMapper {
    fun DisplaySettings.toDisplaySettingsEntity(): DisplaySettingsEntity =
        DisplaySettingsEntity(id = 0, materialYouIsh, materialYou, palette, seedColor, theme)

    fun DisplaySettingsEntity.toDisplaySettings(): DisplaySettings =
        DisplaySettings(
            material_you_ish ?: MaterialYouIshSetting(),
            material_you ?: MaterialYouSetting(),
            palette ?: PaletteSetting(),
            seed_color ?: SeedColorSetting(),
            theme ?: ThemeSetting()
        )
}
