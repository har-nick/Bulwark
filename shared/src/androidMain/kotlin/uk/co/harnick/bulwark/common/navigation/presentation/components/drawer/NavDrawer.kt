package uk.co.harnick.bulwark.common.navigation.presentation.components.drawer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerValue.Closed
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import uk.co.harnick.bulwark.common.navigation.domain.Screens.OpenNotes
import uk.co.harnick.bulwark.common.navigation.domain.Screens.Screen2
import uk.co.harnick.bulwark.common.navigation.presentation.components.drawer.toNavDrawerItem
import uk.co.harnick.bulwark.features.example.domain.NotesParams

@Composable
fun NavDrawer(content: @Composable () -> Unit) {
    val drawerState = rememberDrawerState(initialValue = Closed)

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Column(
                    Modifier
                        .width(300.dp)
                        .padding(horizontal = 12.dp)
                ) {
                    OpenNotes.toNavDrawerItem(NotesParams())
                    Screen2.toNavDrawerItem(NotesParams())
                }
            }
        },
        modifier = Modifier.zIndex(1F),
        drawerState = drawerState,
        content = content
    )
}
