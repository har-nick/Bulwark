package uk.co.harnick.bulwark.common.di

expect object ServiceLocator {
    val coroutineModule: CoroutineModule
    val databaseModule: DatabaseModule
    val repoBindings: RepoBindings
    val useCaseModule: UseCaseModule
    val vmModule: ViewModelModule
}
