package pt.dev_sorcerer.currency_app.data.model

import kotlinx.serialization.Serializable


@Serializable
data class Coin(
    val code: String,
    val value: Float
)