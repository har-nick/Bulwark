package uk.co.harnick.bulwark.features.notes.presentation


import uk.co.harnick.bulwark.features.notes.domain.model.Note

sealed interface NoteEvent {
    data class ArchiveNote(val noteToArchive: Note) : NoteEvent
    data class DeleteNotes(val notesToDelete: List<Note>) : NoteEvent
    data class DeleteNotesPermanently(val notesToPermaDelete: List<Note>) : NoteEvent
    data class SaveNote(val noteToSave: Note) : NoteEvent
    data class SelectNote(val selectedNote: Note) : NoteEvent
    data object ToggleNoteLayout : NoteEvent
    data class UpdateSearchValue(val newValue: String) : NoteEvent
}
