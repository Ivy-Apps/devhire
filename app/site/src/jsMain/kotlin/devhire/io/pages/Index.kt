package devhire.io.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.core.Page
import devhire.io.components.layouts.PageLayout
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Text


@Page
@Composable
fun HomePage() {
    PageLayout("DevHire: Improve your hiring odds!") {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            H1 {
                Text("Improve you hiring odds!")
            }
            H2(
                attrs = {
                    // TODO: TextAlign.Center, center the text horizontally
                }
            ) {
                Text(
                    "The job market is tough. Landing a job is even harder. " +
                            "We connect developers with HR professionals to close this gap."
                )
            }
        }
    }
}
