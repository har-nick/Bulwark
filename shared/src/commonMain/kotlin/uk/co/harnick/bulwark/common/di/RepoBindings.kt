package uk.co.harnick.bulwark.common.di

import uk.co.harnick.bulwark.LocalStorage
import uk.co.harnick.bulwark.core.settings.data.repository.SettingsRepoImpl
import uk.co.harnick.bulwark.core.settings.domain.repository.SettingsRepo
import uk.co.harnick.bulwark.features.notes.data.repository.NoteRepoImpl
import uk.co.harnick.bulwark.features.notes.domain.repository.NoteRepo

interface RepoBindings {
    val noteRepo: NoteRepo
    val settingsRepo: SettingsRepo
}

class RepoBindingsImpl(private val db: LocalStorage) : RepoBindings {
    override val noteRepo by lazy { NoteRepoImpl(db) }
    override val settingsRepo by lazy { SettingsRepoImpl(db) }
}
