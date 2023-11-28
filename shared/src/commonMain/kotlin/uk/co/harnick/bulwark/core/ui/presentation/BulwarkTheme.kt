package uk.co.harnick.bulwark.core.ui.presentation

import androidx.compose.runtime.Composable
import uk.co.harnick.bulwark.core.settings.domain.model.display.DisplaySettings

expect object BulwarkTheme {
    @Composable
    operator fun invoke(displaySettings: DisplaySettings, content: @Composable () -> Unit)
}
