package devhire.io.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import devhire.io.components.layouts.PageLayout
import org.jetbrains.compose.web.dom.Text


@Page("/developer-login")
@Composable
fun DeveloperLoginPage() {
    PageLayout("Developer") {
        Text("Hello, Developer!")
    }
}
