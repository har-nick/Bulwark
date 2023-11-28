package uk.co.harnick.bulwark.features.notes.presentation

import cafe.adriel.voyager.core.lifecycle.JavaSerializable



import uk.co.harnick.bulwark.features.notes.domain.model.Note
import uk.co.harnick.bulwark.features.notes.domain.model.NoteLayout
import uk.co.harnick.bulwark.features.notes.domain.model.NoteLayout.Grid

data class NoteState(
    val error: String? = null,
    val currentNote: Note? = null,
    val noteLayout: NoteLayout = Grid,
    val notes: List<Note> = (0..100).map { Note(title = "$it") }.toList(),
    val pinnedNotes: List<Note> = listOf(),
    val searchValue: String = ""
) : JavaSerializable
