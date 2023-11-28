import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import java.awt.Dimension
import uk.co.harnick.bulwark.core.BulwarkApp
import uk.co.harnick.bulwark.core.window.presentation.components.Taskbar

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Bulwark",
        undecorated = true,
        state = rememberWindowState(width = 1400.dp, height = 800.dp)
    ) {
        LaunchedEffect(window.cursor) {
            println(window.cursor)
        }
        window.minimumSize = Dimension(800, 600)

        Scaffold(
            topBar = { Taskbar(applicationScope = this@application) }
        ) { scaffoldPadding ->
            BulwarkApp(scaffoldPadding)
        }
    }
}
