package devhire.io.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import devhire.io.components.layouts.PageLayout
import devhire.io.components.widgets.SignUpComponent
import org.jetbrains.compose.web.css.cssRem
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
            H1(
                Modifier
                    .padding(bottom = 0.cssRem)
                    .toAttrs()
            ) {
                Text("Improve you hiring odds!")
            }
            H2(
                Modifier
                    .padding(top = 0.cssRem)
                    .textAlign(TextAlign.Center)
                    .fontSize(FontSize.XLarge)
                    .fontWeight(FontWeight.Normal)
                    .toAttrs()
            ) {
                Text(
                    "The job market is tough. Landing a job is even harder. " +
                            "We connect developers with HR professionals to close this gap."
                )
            }
            SignUpComponent()
        }
    }
}
