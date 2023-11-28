package uk.co.harnick.bulwark.core.db.domain.adapters

import androidx.compose.ui.graphics.Color
import uk.co.harnick.bulwark.core.settings.domain.model.display.SeedColorSetting

object SeedColorSettingAdapter : ColorSettingAdapter<SeedColorSetting> {
    override fun decode(databaseValue: Long): SeedColorSetting =
        SeedColorSetting(Color(databaseValue))
}
