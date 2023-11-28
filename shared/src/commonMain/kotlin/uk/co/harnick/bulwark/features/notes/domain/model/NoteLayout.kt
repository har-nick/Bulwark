package uk.co.harnick.bulwark.features.notes.domain.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.GridView
import androidx.compose.material.icons.rounded.ViewAgenda
import androidx.compose.ui.graphics.vector.ImageVector
import uk.co.harnick.bulwark.core.settings.domain.model.EnumSettingValue

enum class NoteLayout(override val label: String, val icon: ImageVector) : EnumSettingValue {
    Grid(label = "Grid", icon = Icons.Rounded.GridView),
    List(label = "List", icon = Icons.Rounded.ViewAgenda);
}
