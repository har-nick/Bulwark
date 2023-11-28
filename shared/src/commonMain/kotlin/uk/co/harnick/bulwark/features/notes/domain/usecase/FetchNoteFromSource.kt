package uk.co.harnick.bulwark.features.notes.domain.usecase

import cafe.adriel.voyager.core.screen.ScreenKey
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import uk.co.harnick.bulwark.common.navigation.domain.Screens.ArchivedNotes
import uk.co.harnick.bulwark.common.navigation.domain.Screens.DeletedNotes
import uk.co.harnick.bulwark.common.navigation.domain.Screens.OpenNotes
import uk.co.harnick.bulwark.core.db.domain.mappers.NoteMapper.toNote
import uk.co.harnick.bulwark.features.notes.domain.model.Note
import uk.co.harnick.bulwark.features.notes.domain.repository.NoteRepo

class FetchNoteFromSource(private val noteRepo: NoteRepo) {
    operator fun invoke(
        coroutineContext: CoroutineContext,
        screenKey: ScreenKey
    ): Flow<Pair<List<Note>, List<Note>>> {
        val noteSource = when (screenKey) {
            ArchivedNotes.label -> noteRepo.loadArchivedNotes(coroutineContext)
            DeletedNotes.label -> noteRepo.loadDeletedNotes(coroutineContext)
            OpenNotes.label -> noteRepo.loadOpenNotes(coroutineContext)
            else -> throw NoSuchElementException("Screen key \"$screenKey\" has no matching label")
        }

        return noteSource.map { entityList ->
            entityList
                .map { noteEntity -> noteEntity.toNote() }
                .partition { it.isPinned }
        }
    }
}
