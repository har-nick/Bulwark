package uk.co.harnick.bulwark.common.di

import uk.co.harnick.bulwark.LocalStorage
import uk.co.harnick.bulwark.core.db.data.local.DriverFactory
import uk.co.harnick.bulwark.core.db.data.local.createLocalStorage

actual class DatabaseModuleImpl : DatabaseModule {
    actual override val localStorage: LocalStorage = createLocalStorage(DriverFactory())
}
