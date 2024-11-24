package devhire.io.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import devhire.io.components.layouts.PageLayout
import org.jetbrains.compose.web.dom.Text

@Page(routeOverride = "/hr-login")
@Composable
fun HRLoginPage() {
    PageLayout("HR: Fill a job") {
        Text("Hello HR!")
    }
}