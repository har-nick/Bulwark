package uk.co.harnick.bulwark.features.example.domain

import uk.co.harnick.bulwark.common.navigation.domain.ScreenParams

data class NotesParams(
    val greetingText: String = "Hi there!"
) : ScreenParams
