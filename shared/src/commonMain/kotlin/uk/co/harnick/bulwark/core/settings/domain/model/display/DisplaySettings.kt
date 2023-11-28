package uk.co.harnick.bulwark.core.settings.domain.model.display

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DisplaySettings
import androidx.compose.material.icons.rounded.DisplaySettings
import androidx.compose.ui.graphics.vector.ImageVector
import uk.co.harnick.bulwark.core.settings.domain.model.Setting
import uk.co.harnick.bulwark.core.settings.domain.model.SettingCollection

data class DisplaySettings(
    val materialYouIsh: MaterialYouIshSetting = MaterialYouIshSetting(),
    val materialYou: MaterialYouSetting = MaterialYouSetting(),
    val palette: PaletteSetting = PaletteSetting(),
    val seedColor: SeedColorSetting = SeedColorSetting(),
    val theme: ThemeSetting = ThemeSetting()
) : SettingCollection {
    override val activeIcon: ImageVector = Icons.Filled.DisplaySettings
    override val inactiveIcon: ImageVector = Icons.Rounded.DisplaySettings

    override val entries: List<Setting<out Any>> =
        listOf(theme, materialYou, materialYouIsh, seedColor, palette)

    override val title: String = "Display"
}
