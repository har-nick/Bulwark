package uk.co.harnick.bulwark.core.window.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.ApplicationScope
import androidx.compose.ui.window.FrameWindowScope

@Composable
fun FrameWindowScope.Taskbar(
    applicationScope: ApplicationScope
) {
    TaskbarFrame {
        TaskbarIcon()
        TaskbarTitle()
        TaskbarActions(applicationScope)
    }
}
