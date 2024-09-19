package pt.dev_sorcerer.currency_app.presentation

import pt.dev_sorcerer.currency_app.data.model.Coin

sealed class AppUiModel {
    data object Loading: AppUiModel()
    data object Default: AppUiModel()
    data class ShowLastUpdatedDate(val date: String): AppUiModel()
    data class ShowError(val message: String): AppUiModel()
    data class ShowData(val data: List<Coin>): AppUiModel()
}