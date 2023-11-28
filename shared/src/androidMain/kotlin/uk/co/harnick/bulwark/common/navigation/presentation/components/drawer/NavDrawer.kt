package uk.co.harnick.bulwark.common.navigation.presentation.components.drawer

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerValue.Closed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import uk.co.harnick.bulwark.core.ui.presentation.components.BackHandler

object NavDrawer {
    private lateinit var drawerScope: CoroutineScope

    private object ToggleDrawer
    private val _toggleListener = Channel<ToggleDrawer>()

    fun open() = drawerScope.launch { _toggleListener.send(ToggleDrawer) }

    @Composable
    operator fun invoke(content: @Composable () -> Unit) {
        drawerScope = rememberCoroutineScope()
        val drawerState = rememberDrawerState(initialValue = Closed)
        val toggleListener = _toggleListener.consumeAsFlow()

        LaunchedEffect(null) {
            toggleListener
                .onEach { drawerState.open() }
                .collect()
        }

        BackHandler(enabled = drawerState.isOpen) {
            drawerScope.launch { drawerState.close() }
        }

        ModalNavigationDrawer(
            drawerContent = {
                ModalDrawerSheet(
                    modifier = Modifier.width(300.dp)
                ) {
                    Text(
                        text = "Bulwark",
                        modifier = Modifier
                            .padding(vertical = 20.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.headlineSmall
                    )

                    NavDrawerItems()
                }
            },
            modifier = Modifier.zIndex(1F),
            drawerState = drawerState,
            content = content
        )
    }
}
