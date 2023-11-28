package uk.co.harnick.bulwark.core.settings.domain.model

import androidx.compose.ui.graphics.vector.ImageVector

interface Setting<T> {
    val description: String?
    val helpLink: String?
    val icon: ImageVector
    val isVisible: Boolean
    val title: String
    val value: T
    val warning: String?

    fun isInteractable(): Boolean = isVisible
}
