package uk.co.harnick.bulwark.common.navigation.presentation.components

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.FadeTransition
import uk.co.harnick.bulwark.common.navigation.domain.Screens.OpenNotes
import uk.co.harnick.bulwark.features.example.domain.NotesParams

@Composable
fun NavigationController() {
    Navigator(screen = OpenNotes.screenProvider(NotesParams())) { navigator ->
        NavigationComponent() {
            FadeTransition(navigator) { screen -> screen.Content() }
        }
    }
}
