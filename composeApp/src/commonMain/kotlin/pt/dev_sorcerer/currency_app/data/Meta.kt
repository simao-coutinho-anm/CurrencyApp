package pt.dev_sorcerer.currency_app.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Meta(
    @SerialName("last_updated_at")
    val lastUpdatedAt: String,
)