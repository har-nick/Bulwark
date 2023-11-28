package uk.co.harnick.bulwark.features.notes.domain.model

import androidx.compose.ui.graphics.Color
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

data class Note(
    val color: Color? = null,
    val content: String = "",
    val id: Long = -1L,
    val isArchived: Boolean = false,
    val isDeleted: Boolean = false,
    val isPinned: Boolean = false,
    val dateTimeCreated: LocalDateTime =
        Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()),
    val dateTimeLastEdited: LocalDateTime? = null,
    val title: String = ""
)
