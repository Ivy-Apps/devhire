package devhire.io.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.minWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.theme.colors.ColorSchemes
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text

private val MinButtonWidth = 180.px

@Composable
fun SignUpComponent() {
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

@Composable
fun DeveloperButton(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val ctx = rememberPageContext()
        Button(
            modifier = Modifier.minWidth(MinButtonWidth),
            colorScheme = ColorSchemes.Blue,
            onClick = {
                ctx.router.navigateTo("/dev-login")
            }
        ) {
            Text("I am a Developer")
        }
        Text("Need a job")
    }
}

@Composable
fun HrButton(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val ctx = rememberPageContext()
        Button(
            modifier = Modifier.minWidth(MinButtonWidth),
            colorScheme = ColorSchemes.Yellow,
            onClick = {
                ctx.router.navigateTo("/hr-login")
            }
        ) {
            Text("I am a HR")
        }
        Text("Offers a job")
    }
}