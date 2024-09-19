package pt.dev_sorcerer.currency_app.data.model.local.dao

import pt.dev_sorcerer.currency_app.data.model.Coin
import pt.dev_sorcerer.currency_app.data.model.local.model.CoinEntity

interface CoinDao {
    suspend fun writeData(data: List<CoinEntity>)
    suspend fun getAllData(): List<Coin>
}