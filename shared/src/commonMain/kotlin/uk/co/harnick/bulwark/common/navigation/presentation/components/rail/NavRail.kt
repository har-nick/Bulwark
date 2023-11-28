package uk.co.harnick.bulwark.common.navigation.presentation.components.rail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationRail
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uk.co.harnick.bulwark.common.navigation.domain.Screens.ArchivedNotes
import uk.co.harnick.bulwark.common.navigation.domain.Screens.DeletedNotes
import uk.co.harnick.bulwark.common.navigation.domain.Screens.OpenNotes
import uk.co.harnick.bulwark.common.navigation.domain.Screens.Settings

@Composable
fun NavRail() {
    NavigationRail(
        Modifier.padding(WindowInsets.displayCutout.asPaddingValues())
    ) {
        Box(
            modifier = Modifier.fillMaxHeight(),
            contentAlignment = Center
        ) {
            Column(
                horizontalAlignment = CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically)
            ) {
                OpenNotes.toNavRailItem()
                ArchivedNotes.toNavRailItem()
                DeletedNotes.toNavRailItem()
            }

            Settings.toNavRailItem(Modifier.align(BottomCenter))
        }
    }
}
