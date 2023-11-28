package uk.co.harnick.bulwark.core.settings.domain.model.general

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Dashboard
import androidx.compose.ui.graphics.vector.ImageVector
import uk.co.harnick.bulwark.core.settings.domain.model.Setting
import uk.co.harnick.bulwark.features.notes.domain.model.NoteLayout
import uk.co.harnick.bulwark.features.notes.domain.model.NoteLayout.Grid

class DefaultNoteLayoutSetting(
    override val value: NoteLayout = Grid
) : Setting<NoteLayout> {
    override val description: String? = null
    override val helpLink: String? = null
    override val icon: ImageVector = Icons.Rounded.Dashboard
    override val isVisible: Boolean = true
    override val title: String = "Default Note Layout"
    override val warning: String? = null
}
