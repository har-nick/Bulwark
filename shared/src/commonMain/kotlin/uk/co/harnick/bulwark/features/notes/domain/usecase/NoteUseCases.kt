package uk.co.harnick.bulwark.features.notes.domain.usecase

import uk.co.harnick.bulwark.features.notes.domain.repository.NoteRepo

class NoteUseCases(noteRepo: NoteRepo) {
    val fetchNoteFromSource: FetchNoteFromSource = FetchNoteFromSource(noteRepo)
}
