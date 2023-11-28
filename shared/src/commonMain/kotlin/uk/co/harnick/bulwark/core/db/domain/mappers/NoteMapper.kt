package uk.co.harnick.bulwark.core.db.domain.mappers

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import uk.co.harnick.bulwark.NoteEntity
import uk.co.harnick.bulwark.features.notes.domain.model.Note

object NoteMapper {
    private val localTimezone = TimeZone.currentSystemDefault()

    fun Note.toNoteEntity() = NoteEntity(
        color?.toArgb(),
        content,
        id,
        isArchived,
        isDeleted,
        isPinned,
        dateTimeCreated.toInstant(TimeZone.UTC).epochSeconds,
        dateTimeLastEdited?.toInstant(TimeZone.UTC)?.epochSeconds,
        title
    )

    fun NoteEntity.toNote(): Note {
        val dateTimeCreated =
            Instant.fromEpochMilliseconds(timestampCreated).toLocalDateTime(localTimezone)
        val dateTimeLastEdited = timestampLastEdited?.let {
            Instant.fromEpochMilliseconds(it).toLocalDateTime(localTimezone)
        }

        return Note(
            color?.let { Color(it) },
            content,
            id,
            isArchived,
            isDeleted,
            isPinned,
            dateTimeCreated,
            dateTimeLastEdited,
            title
        )
    }
}
