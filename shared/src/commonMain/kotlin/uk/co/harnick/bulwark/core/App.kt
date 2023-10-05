package uk.co.harnick.bulwark.core

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import uk.co.harnick.bulwark.common.navigation.presentation.components.NavigationController
import uk.co.harnick.bulwark.core.ui.theme.ExampleTheme

object App {
    @Composable
    operator fun invoke() {
        ExampleTheme {
            Scaffold { NavigationController() }
        }
    }
}
