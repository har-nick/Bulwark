package uk.co.harnick.composemptemplate.common.navigation.presentation.components.rail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uk.co.harnick.bulwark.common.navigation.domain.Screens.OpenNotes
import uk.co.harnick.bulwark.common.navigation.domain.Screens.Screen2
import uk.co.harnick.bulwark.features.example.domain.NotesParams

@Composable
fun NavRail() {
    NavigationRail(
        Modifier
            .background(MaterialTheme.colorScheme.surface)
            .padding(WindowInsets.displayCutout.asPaddingValues())
    ) {
        Column(
            Modifier.fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically)
        ) {
            OpenNotes.toNavRailItem(NotesParams())
            Screen2.toNavRailItem(NotesParams())
        }
    }
}
