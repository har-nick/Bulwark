package uk.co.harnick.bulwark.core.db.domain.adapters

import app.cash.sqldelight.ColumnAdapter
import uk.co.harnick.bulwark.core.db.util.toBool
import uk.co.harnick.bulwark.core.db.util.toLong
import uk.co.harnick.bulwark.core.settings.domain.model.Setting

object BooleanSettingAdapter {
    inline operator fun <reified T : Setting<Boolean>> invoke(): ColumnAdapter<T, Long> {
        return object : ColumnAdapter<T, Long> {
            override fun decode(databaseValue: Long): T =
                T::class.java
                    .getConstructor(Boolean::class.java)
                    .newInstance(databaseValue.toBool())

            override fun encode(value: T): Long = value.value.toLong()
        }
    }
}
