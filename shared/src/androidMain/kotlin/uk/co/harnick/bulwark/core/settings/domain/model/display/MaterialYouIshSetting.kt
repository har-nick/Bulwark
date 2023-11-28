package uk.co.harnick.bulwark.core.settings.domain.model.display

import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Palette
import androidx.compose.ui.graphics.vector.ImageVector


import uk.co.harnick.bulwark.core.settings.domain.model.Setting

actual class MaterialYouIshSetting actual constructor(
    override val value: Boolean
) : Setting<Boolean> {
    override val description: String = "Mimics a Material You theme with some limitations"
    // TODO: ADD HELP LINK
    override val helpLink: String = ""
    override val icon: ImageVector = Icons.Rounded.Palette
    override val isVisible: Boolean = (SDK_INT <= R)
    override val title: String = "Material You-Ish"
    override val warning: String? = null
}
