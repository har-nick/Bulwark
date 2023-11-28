package uk.co.harnick.bulwark.common.di

import uk.co.harnick.bulwark.core.settings.presentation.SettingsViewModel

interface ViewModelModule {
    val settingsViewModel: SettingsViewModel
}

class ViewModelModuleImpl(
    private val ioDispatcher: IODispatcher,
    private val repoBindings: RepoBindings,
    private val useCases: UseCaseModule
) : ViewModelModule {
    override val settingsViewModel by lazy {
        SettingsViewModel(ioDispatcher, repoBindings.settingsRepo, useCases.settingsUseCases)
    }
}
