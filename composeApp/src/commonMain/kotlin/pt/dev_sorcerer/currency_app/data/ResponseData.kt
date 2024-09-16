package pt.dev_sorcerer.currency_app.data

import kotlinx.serialization.Serializable

@Serializable
data class ResponseData(
    val meta: Meta,
    val data: List<Coin>
)