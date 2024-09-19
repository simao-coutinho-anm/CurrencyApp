package pt.dev_sorcerer.currency_app.presentation

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import pt.dev_sorcerer.currency_app.data.model.Coin
import pt.dev_sorcerer.currency_app.data.model.local.AppPreferences
import pt.dev_sorcerer.currency_app.data.model.local.dao.CoinDao
import pt.dev_sorcerer.currency_app.data.model.remote.ApiConnection

class AppViewModel (
    private val apiConnection: ApiConnection,
    private val appPreferences: AppPreferences,
    private val coinDao: CoinDao
): ScreenModel {
    private var _state = MutableStateFlow<AppUiModel>(AppUiModel.Default)
    val state: StateFlow<AppUiModel> get() = _state


    init {
        val isNotUpdated = appPreferences.isGreaterThanOneDay()

        if (isNotUpdated) {
            _state.value = AppUiModel.Loading
            runBlocking {
                coroutineScope {
                    launch(Dispatchers.IO) {
                        val response = apiConnection.fetchData()
                        appPreferences.setLastUpdatedDate(response.meta.lastUpdatedAt)
                    }
                }
            }
        }
    }

    fun getLastUpdatedDate(): String {
        return appPreferences.getFormatedLastUpdatedDate()
    }

    fun getCoins() {
        runBlocking {
            coroutineScope {
                launch {
                    val coins = coinDao.getAllData()

                    _state.value = AppUiModel.ShowData(coins)
                }
            }
        }
    }
}