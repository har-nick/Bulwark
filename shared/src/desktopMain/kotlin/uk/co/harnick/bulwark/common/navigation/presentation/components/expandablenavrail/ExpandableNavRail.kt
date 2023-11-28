package uk.co.harnick.bulwark.common.navigation.presentation.components.expandablenavrail

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uk.co.harnick.bulwark.common.navigation.domain.Screens.ArchivedNotes
import uk.co.harnick.bulwark.common.navigation.domain.Screens.DeletedNotes
import uk.co.harnick.bulwark.common.navigation.domain.Screens.OpenNotes
import uk.co.harnick.bulwark.common.navigation.domain.Screens.Settings

@Composable
fun ExpandableNavRail() {
    var railIsExpanded by remember { mutableStateOf(false) }
    val maxWidth by animateDpAsState(
        targetValue = if (railIsExpanded) 180.dp else 80.dp
    )

    Box(
        modifier = Modifier
            .widthIn(min = 80.dp, max = maxWidth)
            .fillMaxHeight()
            .padding(all = 12.dp),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ExpandableNavRailToggle(railIsExpanded) { railIsExpanded = !railIsExpanded }

            OpenNotes.toExpandableNavRailItem(railIsExpanded)
            ArchivedNotes.toExpandableNavRailItem(railIsExpanded)
            DeletedNotes.toExpandableNavRailItem(railIsExpanded)
        }

        Settings.toExpandableNavRailItem(railIsExpanded, Modifier.align(Alignment.BottomStart))
    }
}
