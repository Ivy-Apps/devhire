package devhire.io.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import devhire.io.components.layouts.PageLayout
import org.jetbrains.compose.web.dom.Text


@Page(Routes.DevLogin)
@Composable
fun DevLoginPage() {
    PageLayout("Developer: Get a job") {
        Text("Hello, Developer!")
    }
}
