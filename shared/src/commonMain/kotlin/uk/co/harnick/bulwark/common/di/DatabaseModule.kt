package uk.co.harnick.bulwark.common.di

import uk.co.harnick.bulwark.LocalStorage

interface DatabaseModule {
    val localStorage: LocalStorage
}

expect class DatabaseModuleImpl : DatabaseModule {
    override val localStorage: LocalStorage
}
