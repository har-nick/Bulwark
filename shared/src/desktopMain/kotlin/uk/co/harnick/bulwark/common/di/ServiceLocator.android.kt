package uk.co.harnick.bulwark.common.di

actual object ServiceLocator {
    actual val coroutineModule: CoroutineModule = CoroutineModuleImpl
    actual val databaseModule: DatabaseModule = DatabaseModuleImpl()
    actual val repoBindings: RepoBindings = RepoBindingsImpl(databaseModule.localStorage)
    actual val useCaseModule: UseCaseModule =
        UseCaseModuleImpl(repoBindings.noteRepo, repoBindings.settingsRepo)
    actual val vmModule: ViewModelModule =
        ViewModelModuleImpl(coroutineModule.ioDispatcher, repoBindings, useCaseModule)
}
