package uk.co.harnick.bulwark.features.notes.presentation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import uk.co.harnick.bulwark.common.di.ServiceLocator

data class NoteScreen(override val key: ScreenKey) : Screen {
    @Composable
    override fun Content() {
        val vm = rememberScreenModel {
            NoteViewModel(
                ioDispatcher = ServiceLocator.coroutineModule.ioDispatcher,
                noteRepo = ServiceLocator.repoBindings.noteRepo,
                noteUseCases = ServiceLocator.useCaseModule.noteUseCases,
                screenKey = key
            )
        }
        val state by vm.state.collectAsState()

        Scaffold { scaffoldPadding ->

        }
    }
}
