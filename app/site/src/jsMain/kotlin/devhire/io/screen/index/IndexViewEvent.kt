package devhire.io.screen.index

data class IndexViewState(
    val developersCount: Int,
    val hrsCount: Int,
)

sealed interface IndexViewEvent {

}