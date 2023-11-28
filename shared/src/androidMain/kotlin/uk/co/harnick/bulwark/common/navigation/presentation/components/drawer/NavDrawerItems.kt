package uk.co.harnick.bulwark.common.navigation.presentation.components.drawer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uk.co.harnick.bulwark.common.navigation.domain.Screens.ArchivedNotes
import uk.co.harnick.bulwark.common.navigation.domain.Screens.DeletedNotes
import uk.co.harnick.bulwark.common.navigation.domain.Screens.OpenNotes
import uk.co.harnick.bulwark.common.navigation.domain.Screens.Settings

@Composable
fun NavDrawerItems() {
    Column(
        Modifier.padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        OpenNotes.ToNavDrawerItem()
        ArchivedNotes.ToNavDrawerItem()
        DeletedNotes.ToNavDrawerItem()
        Settings.ToNavDrawerItem()
    }
}