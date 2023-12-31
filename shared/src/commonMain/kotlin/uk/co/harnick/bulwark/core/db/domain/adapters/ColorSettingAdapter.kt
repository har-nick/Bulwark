package uk.co.harnick.bulwark.core.db.domain.adapters

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import app.cash.sqldelight.ColumnAdapter
import uk.co.harnick.bulwark.core.settings.domain.model.Setting

// TODO: Find out why Color can't be decoded generically
interface ColorSettingAdapter<T : Setting<Color>> : ColumnAdapter<T, Long> {
    override fun encode(value: T): Long = value.value.toArgb().toLong()
}
