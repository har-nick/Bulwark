package uk.co.harnick.bulwark.common.di

import android.content.Context
import uk.co.harnick.bulwark.LocalStorage
import uk.co.harnick.bulwark.core.db.data.local.DriverFactory
import uk.co.harnick.bulwark.core.db.data.local.createLocalStorage

actual class DatabaseModuleImpl(applicationContext: Context) : DatabaseModule {
    actual override val localStorage: LocalStorage =
        createLocalStorage(DriverFactory(applicationContext))
}