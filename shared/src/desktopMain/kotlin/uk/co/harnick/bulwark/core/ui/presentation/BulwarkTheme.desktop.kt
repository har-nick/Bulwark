package uk.co.harnick.bulwark.core.ui.presentation

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.materialkolor.AnimatedDynamicMaterialTheme
import uk.co.harnick.bulwark.core.settings.domain.model.Theme.Auto
import uk.co.harnick.bulwark.core.settings.domain.model.Theme.Dark
import uk.co.harnick.bulwark.core.settings.domain.model.Theme.Light
import uk.co.harnick.bulwark.core.settings.domain.model.display.DisplaySettings

actual object BulwarkTheme {
    @Composable
    actual operator fun invoke(
        displaySettings: DisplaySettings,
        content: @Composable () -> Unit
    ) {
        val deviceIsInDarkTheme = isSystemInDarkTheme()

        val darkThemeState = when (displaySettings.theme.value) {
            Dark -> true
            Light -> false
            Auto -> deviceIsInDarkTheme
        }

        AnimatedDynamicMaterialTheme(
            seedColor = displaySettings.seedColor.value,
            useDarkTheme = darkThemeState,
            style = displaySettings.palette.value.style
        ) {
            Surface { content() }
        }
    }
}
