package uk.co.harnick.bulwark.features.notes.domain.repository

import kotlin.coroutines.CoroutineContext

import kotlinx.coroutines.flow.Flow
import uk.co.harnick.bulwark.NoteEntity

interface NoteRepo {
    fun deleteNotes(notes: List<NoteEntity>)
    fun loadArchivedNotes(coroutineContext: CoroutineContext): Flow<List<NoteEntity>>
    fun loadDeletedNotes(coroutineContext: CoroutineContext): Flow<List<NoteEntity>>
    fun loadOpenNotes(coroutineContext: CoroutineContext): Flow<List<NoteEntity>>
    fun saveNote(note: NoteEntity)
}