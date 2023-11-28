package uk.co.harnick.bulwark.common.di

import android.content.Context

actual object ServiceLocator {
    private lateinit var applicationContext: Context

    operator fun invoke(appContext: Context) {
        applicationContext = appContext
    }

    // By lazy is required as value instantiation happens before invoke can assign a context
    actual val coroutineModule: CoroutineModule = CoroutineModuleImpl
    actual val databaseModule: DatabaseModule by lazy { DatabaseModuleImpl(applicationContext) }
    actual val repoBindings: RepoBindings by lazy { RepoBindingsImpl(databaseModule.localStorage) }
    actual val useCaseModule: UseCaseModule by lazy {
        UseCaseModuleImpl(repoBindings.noteRepo, repoBindings.settingsRepo)
    }
    actual val vmModule: ViewModelModule by lazy {
        ViewModelModuleImpl(coroutineModule.ioDispatcher, repoBindings, useCaseModule)
    }
}
