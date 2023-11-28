package uk.co.harnick.bulwark.core.settings.domain.model.general

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Language
import androidx.compose.ui.graphics.vector.ImageVector
import uk.co.harnick.bulwark.core.settings.domain.model.Language
import uk.co.harnick.bulwark.core.settings.domain.model.Language.en_GB
import uk.co.harnick.bulwark.core.settings.domain.model.Setting

class LanguageSetting(
    override val value: Language = en_GB
) : Setting<Language> {
    override val description: String? = null
    override val helpLink: String? = null
    override val icon: ImageVector = Icons.Rounded.Language
    override val isVisible: Boolean = true
    override val title: String = "Language"
    override val warning: String? = null
}
