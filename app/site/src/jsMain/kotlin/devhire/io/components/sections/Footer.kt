package devhire.io.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import devhire.io.components.widgets.NavLink
import devhire.io.toSitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

val FooterStyle = CssStyle.base {
    Modifier
        .backgroundColor(colorMode.toSitePalette().nearBackground)
        .padding(topBottom = 1.5.cssRem, leftRight = 10.percent)
}

@Composable
fun Footer(modifier: Modifier = Modifier) {
    Box(FooterStyle.toModifier().then(modifier), contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavLink(text = "Terms of Use", path = "/tc")
            NavLink(text = "Privacy Policy", path = "/tc")
            Div(Modifier.padding(top = 1.cssRem).toAttrs()) {
                Text("Copyright © 2024 Ivy Apps")
            }
        }
    }
}
