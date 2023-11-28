package uk.co.harnick.bulwark.core

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import uk.co.harnick.bulwark.common.di.ServiceLocator
import uk.co.harnick.bulwark.common.navigation.presentation.components.NavigationController
import uk.co.harnick.bulwark.core.ui.presentation.BulwarkTheme

object BulwarkApp {
    @Composable
    operator fun invoke(paddingValues: PaddingValues = PaddingValues()) {
        val settingsState by ServiceLocator.vmModule.settingsViewModel.state.collectAsState()

        BulwarkTheme(settingsState.displaySettings) {
            Box(
                modifier = Modifier.padding(paddingValues),
                content = { NavigationController() }
            )
        }
    }
}
