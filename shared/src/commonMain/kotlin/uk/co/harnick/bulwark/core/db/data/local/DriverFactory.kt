package uk.co.harnick.bulwark.core.db.data.local

import app.cash.sqldelight.adapter.primitive.IntColumnAdapter
import app.cash.sqldelight.db.SqlDriver
import uk.co.harnick.bulwark.DisplaySettingsEntity
import uk.co.harnick.bulwark.GeneralSettingsEntity
import uk.co.harnick.bulwark.LocalStorage
import uk.co.harnick.bulwark.NoteEntity
import uk.co.harnick.bulwark.SecuritySettingsEntity
import uk.co.harnick.bulwark.core.db.domain.adapters.BooleanSettingAdapter
import uk.co.harnick.bulwark.core.db.domain.adapters.EnumSettingAdapter
import uk.co.harnick.bulwark.core.db.domain.adapters.SeedColorSettingAdapter

expect class DriverFactory {
    fun createDriver(): SqlDriver
}

fun createLocalStorage(driverFactory: DriverFactory): LocalStorage {
    val driver = driverFactory.createDriver()
    return LocalStorage(
        driver,
        DisplaySettingsEntity.Adapter(
            material_youAdapter = BooleanSettingAdapter(),
            material_you_ishAdapter = BooleanSettingAdapter(),
            paletteAdapter = EnumSettingAdapter(),
            seed_colorAdapter = SeedColorSettingAdapter,
            themeAdapter = EnumSettingAdapter()
        ),
        GeneralSettingsEntity.Adapter(
            languageAdapter = EnumSettingAdapter(),
            default_note_layoutAdapter = EnumSettingAdapter(),
            optimise_imagesAdapter = BooleanSettingAdapter()
        ),
        NoteEntity.Adapter(colorAdapter = IntColumnAdapter),
        SecuritySettingsEntity.Adapter(
            isLockedAdapter = EnumSettingAdapter(),
            secureFlagEnabledAdapter = BooleanSettingAdapter()
        )
    )
}
