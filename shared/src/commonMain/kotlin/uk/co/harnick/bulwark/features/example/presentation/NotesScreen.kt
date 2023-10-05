package uk.co.harnick.bulwark.features.example.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import uk.co.harnick.bulwark.features.example.domain.NotesParams

data class NotesScreen(override val key: ScreenKey, val params: NotesParams) : Screen {
    @Composable
    override fun Content() {
        Scaffold { scaffoldPadding ->
            Column(
                Modifier
                    .padding(scaffoldPadding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically)
            ) {
                Text(key)
                Text(params.greetingText)
            }
        }
    }
}
