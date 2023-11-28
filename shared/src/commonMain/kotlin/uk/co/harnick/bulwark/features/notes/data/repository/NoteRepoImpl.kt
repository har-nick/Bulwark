package uk.co.harnick.bulwark.features.notes.data.repository

import app.cash.sqldelight.Query
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import kotlin.coroutines.CoroutineContext

import kotlinx.coroutines.flow.Flow
import uk.co.harnick.bulwark.LocalStorage
import uk.co.harnick.bulwark.NoteEntity
import uk.co.harnick.bulwark.features.notes.domain.repository.NoteRepo

class NoteRepoImpl(db: LocalStorage) : NoteRepo {
    private val noteQueries = db.note_entityQueries

    private fun loadNotes(
        query: Query<NoteEntity>,
        coroutineContext: CoroutineContext
    ): Flow<List<NoteEntity>> {
        return query
            .asFlow()
            .mapToList(coroutineContext)
    }

    override fun deleteNotes(notes: List<NoteEntity>) =
        notes.forEach { note -> noteQueries.deleteNote(note.id) }

    override fun loadArchivedNotes(coroutineContext: CoroutineContext): Flow<List<NoteEntity>> =
        loadNotes(noteQueries.loadArchivedNotes(), coroutineContext)

    override fun loadDeletedNotes(coroutineContext: CoroutineContext): Flow<List<NoteEntity>> =
        loadNotes(noteQueries.loadDeletedNotes(), coroutineContext)

    override fun loadOpenNotes(coroutineContext: CoroutineContext): Flow<List<NoteEntity>> =
        loadNotes(noteQueries.loadOpenNotes(), coroutineContext)


    override fun saveNote(note: NoteEntity) =
        noteQueries.saveNote(
            note.color,
            note.content,
            note.isArchived,
            note.isDeleted,
            note.isPinned,
            note.timestampCreated,
            note.timestampLastEdited,
            note.title
        )
}
