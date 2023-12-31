package uk.co.harnick.bulwark.common.navigation.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass.Companion.Expanded
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import uk.co.harnick.bulwark.common.navigation.presentation.components.expandablenavrail.ExpandableNavRail
import uk.co.harnick.bulwark.common.navigation.presentation.components.rail.NavRail

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
actual fun NavigationComponent(content: @Composable () -> Unit) {
    Row {
        when (calculateWindowSizeClass().widthSizeClass) {
            Expanded -> ExpandableNavRail()
            else -> NavRail()
        }
        content()
    }
}
