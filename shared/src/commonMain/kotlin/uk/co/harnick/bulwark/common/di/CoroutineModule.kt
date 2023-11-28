package uk.co.harnick.bulwark.common.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

typealias MainDispatcher = CoroutineDispatcher
typealias DefaultDispatcher = CoroutineDispatcher
typealias IODispatcher = CoroutineDispatcher

interface CoroutineModule {
    val mainDispatcher: MainDispatcher
    val defaultDispatcher: DefaultDispatcher
    val ioDispatcher: IODispatcher
}

object CoroutineModuleImpl : CoroutineModule {
    override val mainDispatcher: MainDispatcher by lazy { Dispatchers.Main }
    override val defaultDispatcher: DefaultDispatcher by lazy { Dispatchers.Default }
    override val ioDispatcher: IODispatcher by lazy { Dispatchers.IO }
}

