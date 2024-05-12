import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import java.awt.Dimension
import org.company.app.App
import org.company.app.AppLaunch

fun main() = application {
    Window(
        title = "Sentify",
        state = rememberWindowState(size = DpSize.Unspecified),
        onCloseRequest = ::exitApplication,
    ) {
        AppLaunch()
    }//.\gradlew :composeApp:run
}