package devhire.io.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import devhire.io.components.layouts.PageLayout
import org.jetbrains.compose.web.dom.Text

@Page(routeOverride = "/privacy")
@Composable
fun PrivacyPolicyPage() {
    PageLayout("DevHire: Privacy policy") {
        Text("TBD")
    }
}