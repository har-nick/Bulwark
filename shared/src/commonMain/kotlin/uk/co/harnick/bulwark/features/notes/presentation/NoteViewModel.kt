package uk.co.harnick.bulwark.features.notes.presentation

import cafe.adriel.voyager.core.screen.ScreenKey
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import uk.co.harnick.bulwark.common.di.IODispatcher
import uk.co.harnick.bulwark.core.db.domain.mappers.NoteMapper.toNoteEntity
import uk.co.harnick.bulwark.core.ui.presentation.StatefulViewModel
import uk.co.harnick.bulwark.features.notes.domain.model.NoteLayout.Grid
import uk.co.harnick.bulwark.features.notes.domain.model.NoteLayout.List
import uk.co.harnick.bulwark.features.notes.domain.repository.NoteRepo
import uk.co.harnick.bulwark.features.notes.domain.usecase.NoteUseCases
import uk.co.harnick.bulwark.features.notes.presentation.NoteEvent.ArchiveNote
import uk.co.harnick.bulwark.features.notes.presentation.NoteEvent.DeleteNotes
import uk.co.harnick.bulwark.features.notes.presentation.NoteEvent.DeleteNotesPermanently
import uk.co.harnick.bulwark.features.notes.presentation.NoteEvent.SaveNote
import uk.co.harnick.bulwark.features.notes.presentation.NoteEvent.SelectNote
import uk.co.harnick.bulwark.features.notes.presentation.NoteEvent.ToggleNoteLayout
import uk.co.harnick.bulwark.features.notes.presentation.NoteEvent.UpdateSearchValue

class NoteViewModel(
    private val ioDispatcher: IODispatcher,
    private val noteUseCases: NoteUseCases,
    private val noteRepo: NoteRepo,
    private val screenKey: ScreenKey
) : StatefulViewModel<NoteState, NoteEvent>(NoteState()) {
    override fun onEvent(event: NoteEvent) = when (event) {
        is ArchiveNote -> TODO()
        is DeleteNotes -> TODO()
        is DeleteNotesPermanently -> TODO()
        is SaveNote -> noteRepo.saveNote(event.noteToSave.toNoteEntity())
        is SelectNote -> mutableState.update { it.copy(currentNote = event.selectedNote) }
        is ToggleNoteLayout -> toggleNoteLayout()
        is UpdateSearchValue -> mutableState.update { it.copy(searchValue = event.newValue) }
    }

    private fun toggleNoteLayout() {
        val newLayout = when (state.value.noteLayout) {
            Grid -> List
            List -> Grid
        }

        mutableState.update { it.copy(noteLayout = newLayout) }
    }

    init {
        monitorNoteSource()
    }

    private fun monitorNoteSource() =
        noteUseCases.fetchNoteFromSource(vmContext + ioDispatcher, screenKey)
            .flowOn(ioDispatcher)
            .onEach { emission ->
                val (pinnedNotes, unpinnedNotes) = emission
                mutableState.update { it.copy(notes = unpinnedNotes, pinnedNotes = pinnedNotes) }
            }
}
