package pt.dev_sorcerer.currency_app.presentation

sealed class AppUiModel {
    data object Loading: AppUiModel()
    data object Default: AppUiModel()
    data class ShowLastUpdatedDate(val date: String): AppUiModel()
}