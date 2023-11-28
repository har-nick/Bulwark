package uk.co.harnick.bulwark.core.settings.domain.model.general

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.rounded.Tune
import androidx.compose.ui.graphics.vector.ImageVector
import uk.co.harnick.bulwark.core.settings.domain.model.Setting
import uk.co.harnick.bulwark.core.settings.domain.model.SettingCollection

data class GeneralSettings(
    val defaultNoteLayout: DefaultNoteLayoutSetting = DefaultNoteLayoutSetting(),
    val language: LanguageSetting = LanguageSetting(),
    val optimiseImages: OptimiseImagesSetting = OptimiseImagesSetting()
) : SettingCollection {
    override val activeIcon: ImageVector = Icons.Filled.Tune
    override val inactiveIcon: ImageVector = Icons.Rounded.Tune

    override val entries: List<Setting<out Any>> =
        listOf(language, defaultNoteLayout, optimiseImages)

    override val title: String = "General"
}



