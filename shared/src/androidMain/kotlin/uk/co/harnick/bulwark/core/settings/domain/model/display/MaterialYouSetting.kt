package uk.co.harnick.bulwark.core.settings.domain.model.display

import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.S
import androidx.annotation.ChecksSdkIntAtLeast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Palette
import androidx.compose.ui.graphics.vector.ImageVector


import uk.co.harnick.bulwark.core.settings.domain.model.Setting

actual class MaterialYouSetting actual constructor(
    override val value: Boolean
) : Setting<Boolean> {
    override val description: String? = null
    override val helpLink: String? = null
    override val icon: ImageVector = Icons.Rounded.Palette
    @ChecksSdkIntAtLeast(api = S)
    override val isVisible: Boolean = (SDK_INT >= S)
    override val title: String = "Material You"
    override val warning: String? = null
}
