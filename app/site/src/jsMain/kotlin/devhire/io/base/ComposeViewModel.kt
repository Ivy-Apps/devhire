package devhire.io.base

import androidx.compose.runtime.Composable

interface ComposeViewModel<V, E> {
    @Composable
    fun viewState(): V

    fun onEvent(e: E)
}