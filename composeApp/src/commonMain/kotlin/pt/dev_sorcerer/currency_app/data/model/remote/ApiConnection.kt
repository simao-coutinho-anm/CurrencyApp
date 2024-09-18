package pt.dev_sorcerer.currency_app.data.model.remote

import pt.dev_sorcerer.currency_app.data.model.ResponseData

interface ApiConnection {
    suspend fun fetchData(): ResponseData
}