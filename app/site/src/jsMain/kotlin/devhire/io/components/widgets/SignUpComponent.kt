package devhire.io.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.minWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.theme.colors.ColorScheme
import com.varabyte.kobweb.silk.theme.colors.ColorSchemes
import devhire.io.pages.Routes
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Tbody
import org.jetbrains.compose.web.dom.Text

private val MinButtonWidth = 200.px

@Composable
fun SignUpComponent(
    headerText: String,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Tbody(
            Modifier
                .fontSize(FontSize.Larger)
                .fontWeight(FontWeight.SemiBold)
                .padding(bottom = 1.cssRem)
                .toAttrs()
        ) {
            Text(headerText)
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            DeveloperButton(
                modifier = Modifier
                    .padding(leftRight = 1.cssRem)
            )
            HrButton(
                modifier = Modifier
                    .padding(leftRight = 1.cssRem)
            )
        }
    }
}

@Composable
fun DeveloperButton(
    modifier: Modifier = Modifier,
) {
    CtaButton(
        modifier = modifier,
        colorScheme = ColorSchemes.Blue,
        buttonLabel = "I am a Developer",
        caption = "Needs a job",
        route = Routes.DevLogin,
    )
}

@Composable
fun HrButton(
    modifier: Modifier = Modifier,
) {
    CtaButton(
        modifier = modifier,
        colorScheme = ColorSchemes.Amber,
        buttonLabel = "I am an HR",
        caption = "Offers a job",
        route = Routes.HrLogin,
    )
}

@Composable
private fun CtaButton(
    buttonLabel: String,
    caption: String,
    route: String,
    colorScheme: ColorScheme,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val ctx = rememberPageContext()
        Button(
            modifier = Modifier.minWidth(MinButtonWidth),
            colorScheme = colorScheme,
            onClick = {
                ctx.router.navigateTo(route)
            }
        ) {
            Text(buttonLabel)
        }
        Tbody(
            Modifier.fontWeight(FontWeight.Light).toAttrs()
        ) {
            Text(caption)
        }
    }
}