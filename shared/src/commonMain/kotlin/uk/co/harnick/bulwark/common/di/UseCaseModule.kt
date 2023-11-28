package uk.co.harnick.bulwark.common.di

import uk.co.harnick.bulwark.core.settings.domain.repository.SettingsRepo
import uk.co.harnick.bulwark.core.settings.domain.usecase.SettingsUseCases
import uk.co.harnick.bulwark.features.notes.domain.repository.NoteRepo
import uk.co.harnick.bulwark.features.notes.domain.usecase.NoteUseCases

interface UseCaseModule {
    val noteUseCases: NoteUseCases
    val settingsUseCases: SettingsUseCases
}

class UseCaseModuleImpl(noteRepo: NoteRepo, settingsRepo: SettingsRepo) : UseCaseModule {
    override val noteUseCases: NoteUseCases = NoteUseCases(noteRepo)
    override val settingsUseCases: SettingsUseCases = SettingsUseCases(settingsRepo)
}
