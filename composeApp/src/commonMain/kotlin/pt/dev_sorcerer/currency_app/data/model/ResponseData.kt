package pt.dev_sorcerer.currency_app.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ResponseData(
    val meta: Meta,
    val data: Map<String, Coin>
)