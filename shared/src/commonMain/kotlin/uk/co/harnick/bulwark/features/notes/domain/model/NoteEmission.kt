package uk.co.harnick.bulwark.features.notes.domain.model

data class NoteEmission(
    val pinnedNotes: List<Note>,
    val unpinnedNotes: List<Note>
)
