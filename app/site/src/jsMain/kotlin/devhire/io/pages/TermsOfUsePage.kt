package devhire.io.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import devhire.io.components.layouts.PageLayout
import org.jetbrains.compose.web.dom.Text

@Page(Routes.TemsOfUse)
@Composable
fun TermsOfUsePage() {
    PageLayout("DevHire: Terms of Use") {
        Text("TBD")
    }
}