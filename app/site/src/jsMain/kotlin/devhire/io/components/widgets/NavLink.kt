package devhire.io.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.components.navigation.UndecoratedLinkVariant

@Composable
fun NavLink(text: String, path: String) {
    Link(path, text, variant = UndecoratedLinkVariant.then(UncoloredLinkVariant))
}
